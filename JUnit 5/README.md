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

```java
package com.example.project;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class DisplayNameGeneratorDemo {
    @Nested
    class A_year_is_not_supported {

        @Test
        void if_it_is_zero() {

        }

    }

    @Nested
    @IndicativeSentencesGeneration(separator = "->", generator = DisplayNameGenerator.ReplaceUnderscores.class)
    class A_year_is_a_leap_year {

        @ParameterizedTest(name = "Year {0} is a leap year")
        @ValueSource(ints = {2016, 2020, 2048})
        void if_it_is_one_of_the_following_years(int year) {

        }

    }
}

```

2.3.2 Setting the Default Display Name Generator



### 2.4. Assertions

> AssertionsDemo.java

2.4.2 Third-party Assertion Libraries

AssertJ, Hamcrest, Truth



### 2.5. Assumptions

