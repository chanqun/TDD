package com.example.project;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
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
@Retention(RetentionPolicy.RUNTIME)
/*
    어노테이션 타입을 어디까지 보유할지 설정 default class 메모리 보유 범위
    SOURCE 컴파일시 메모리 버림,
    CLASS 런타임시에는 사라짐,
    RUNTIME 런타임이 종료할 때까지 메모리는 살아있음
 */
@Tag("fast")
@Test
public @interface FastTest {
    //create my own test
}
