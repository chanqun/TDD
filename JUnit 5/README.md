# JUnit 5

[JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)



#### 2.1. Annotations

##### Test Class

: any top-level class, static member class, or @Nested class that contains at least one test method

Test classes must not be abstract and must have a single constructor.

##### Test Method

- @Test
  Denotes that a method is a test method.

- @ParameterizedTest

  parameterized tests make it possible to run a test multiple times with different arguments. they are declared just likt regular @Test methods but the @ParameterizedTest annotation instead

- @RepeatedTest
  JUnit Jupiter provides the ability to repeat a test a specified number of times by annotating a method with @RepeatedTest and specifying the total number of repetitions desired

- @TestFactory

  @Test These test cases are static in the sense that they are fully specified at compile time, and their behavior cannot be changed by anything happening at runtime. Assumptions provide a basic form of dynamic behavior but are intentionally rather limited in their expressiveness (의도적 표현)

- @TestTemplate

##### Lifecycle method

- @BeforeAll

- @AfterAll

  -> class내의 모든 method가 실행 된다고 할 때 @BeforeAll, @AfterAll

- @BeforeEach

  denotes that the method should be executed before each 
  @Test, @RepeatedTest, @ParameterizedTest, @TestFactory method in the current class

- @AfterEach

  denotes that the annotated method should be executed after each
  @Test, @RepeatedTest, @ParameterizedTest, @TestFactory method in the current class

  -> 각각의 method가 실행될 때 @BeforeEach, @AfterEach

##### Others

- @Displayname - other sentence, emoji 
- @DisplayNameGenetration(DisplayNameGenerator.ReplaceUnderscores.class) 

- @Nested 중천된 구조로 테스트를 구성할 수 있음, cannot use @AfterAll @BeforeAll

#### 2.1.1 Meta-Annotations and Composed Annotation

meta-annotation means that you can define your own composed annotation that will automatically inherit the semantics of its meta-annotations 

```java
package com.example.project;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
@Target({
        ElementType.PACKAGE, // 패키지 선언시
        ElementType.TYPE, // 타입 선언시
        ElementType.CONSTRUCTOR, // 생성자 선언시
        ElementType.FIELD, // 멤버 변수 선언시
        ElementType.METHOD, // 메소드 선언시
        ElementType.ANNOTATION_TYPE, // 어노테이션 타입 선언시
        ElementType.LOCAL_VARIABLE, // 지역 변수 선언시
        ElementType.PARAMETER, // 매개 변수 선언시
        ElementType.TYPE_PARAMETER, // 매개 변수 타입 선언시
        ElementType.TYPE_USE // 타입 사용시
})
* */
/*
    어노테이션 타입을 어디까지 보유할지 설정 default class 메모리 보유 범위
    SOURCE 컴파일시 메모리 버림,
    CLASS 런타임시에는 사라짐,
    RUNTIME 런타임이 종료할 때까지 메모리는 살아있음
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Tag("fast")
@Test
public @interface FastTest {
    //create my own test
}

```



#### 2.2. Test Classes and methods

> !! BeforeAll에서 static을 사용하는 이유
> 기본적으로 테스트는 서로 독립적이어야 한다. 
> 테스트 순서 때문에 테스트의 성공 여부가 결정되면 안 된다.
>
> 1. @Test메소드마다 클래스의 인스턴스를 새롭게 만든다.
> 2. @BeforeEach라고 붙은 setUp 메소드를 실행한다.
>
> 그렇다면 @BeforeAll은 언제 사용될까?
> 되도록이면 사용하지 않는 것이 맞다.
> 하지만 초기화를 하면 아주 시간이 오래걸리는 작업이 존재한다. 또는 수백메가의 데이터를 읽어들이거나
> 이런 경우, 테스트가 서로 영향을 주지 않는 선에서 초기화하는 작업을 @BeforeAll에 static으로 사용한다.

```java
package com.example.project;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class StandardTest {

    //? BeforeAll은 왜 static?
    @BeforeAll //클래스를 초기화할 때 딱 한 번
    static void initAll() {

    }

    @BeforeEach
    void init() {

    }

    @Test
    void succeedingTest() {

    }

    @Test
    void failingTest() {
        fail("a failing test");
    }

    @Test
    @Disabled("for demonstration purposes") //붙이면 무시됨
    void skippedTest() {

    }

    @Test
    void abortedTest() {
        assumeTrue("abc".contains("Z"));
        fail("test should have been aborted");
    }

    @AfterEach
    void tearDown() {

    }

    @AfterAll
    static void tearDownAll() {

    }
}

```

#### 2.3. Display Names

Test classes and test methods can declare custom display names via @DisplayName

> DisplayNameDemo.java

2.3.1 Display Name Generators

Standard, Simple, ReplaceUnderscores, IndicativeSentences

> DisplayNameGeneratorDemo .java

2.3.2 Setting the Default Display Name Generator



### 2.4. Assertions

> AssertionsDemo.java

2.4.2 Third-party Assertion Libraries

AssertJ, Hamcrest, Truth



### 2.5. Assumptions

특정 환경에서만 테스트를 실행할 수 있다.
특정 환경이 아니라면 test를 skip한다.

//현재는 null -  LOCAL, BETA, RC, REAL등 특정 환경을 설정할 수 있을 것이다.

```java
System.getEnv("ENV");
```

### 2.6. Disabling Tests

test skipped

@Disabled



##### 2.7. Conditional Test Execution

-> ExecutionCondition 5.3.

#### Operating System Conditions

OS, JRE, ENV, customCondition을 이용해 skip or not 가능

##### 2.8. Tagging and Filtering

4.6. Tag Expressions에서 조건으로 사용함



### 2.9. Test Excution Order

@TestMethodOrder (DisplayName, MethodName, OrderAnnotation, Random, 

Alphanumeric -> MethodName)



### 2.10. Test Instance Lifecycle

per-class: class 당 인스턴스가 생성,

per-method: method당 인스턴스가 생성

@TestInstance(Lifecycle.PER_CLASS)
"per-class" mode has some additional benefits over the default "per-method" mode

with the "per-class"mode it becomes possible to declare @BeforeAll and @AfterAll on non-static methods

--> ??? static method가 없는 kotlin에서도 @BeforeAll, @AfterAll 사용할 수 있게 된다.



### 2.11 Nested Tests

@Nested tests give the test writer more capabilities to express the relationship among several groups of tests. Such nested tests make use of Java's nested classes and facilitate **hierarchical** thinking about the test structure.

> TestingAStackDemo.java