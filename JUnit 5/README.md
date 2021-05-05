# JUnit 5

[JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)



2.1. Annotations

Test Class

: any top-level class, static member class, or @Nested class that contains at least one test method

Test classes must not be abstract and must have a single constructor.

Test Method

- @Test
  Denotes that a method is a test method.

- @ParameterizedTest

  parameterized tests make it possible to run a test multiple times with different arguments. they are declared just likt regular @Test methods but the @ParameterizedTest annotation instead

- @RepeatedTest
  JUnit Jupiter provides the ability to repeat a test a specified number of times by annotating a method with @RepeatedTest and specifying the total number of repetitions desired

- @TestFactory

  @Test These test cases are static in the sense that they are fully specified at compile time, and their behavior cannot be changed by anything happening at runtime. Assumptions provide a basic form of dynamic behavior but are intentionally rather limited in their expressiveness (의도적 표현)

- @TestTemplate

Lifecycle method

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

Others

- @Displayname - other sentence, emoji 
- @DisplayNameGenetration(DisplayNameGenerator.ReplaceUnderscores.class) 



2.1.1 Meta-Annotations and Composed Annotation

meta-annotation means that you can define your own composed annotation that will automatically inherit the semantics of its meta-annotations 