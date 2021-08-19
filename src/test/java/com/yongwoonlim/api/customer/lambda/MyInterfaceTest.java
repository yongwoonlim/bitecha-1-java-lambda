package com.yongwoonlim.api.customer.lambda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class MyInterfaceTest {

    @DisplayName("Imperative(명령형) vs Declarative(선언형)")
    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("1부터 100까지의 합을 통해 본 명령형과 함수형의 비교")
    void sumFrom0To100Test() {
        // Imperative(명령형)
        int sumOfEvens = 0;
        for (int i = 0; i <= 100; i++) {
            if (i % 2 == 0) {
                sumOfEvens += i;
            }
        }
        System.out.println("Imperative(명령형): " + sumOfEvens);

        // Declarative(선언형) = Functional
        sumOfEvens = IntStream.rangeClosed(0, 100)
                .filter(i -> i % 2 == 0)
                .reduce((x, y) -> x + y)
                .getAsInt();

        System.out.println("Declarative(선언형): " + sumOfEvens);
    }

    static String myFunction(MyInterface fun){
        return fun.myMethod();
    }

    @Test
    @DisplayName("Functional Interface")
    void myMethodTest(){
        assertThat(myFunction(() -> "Hello Functional Interface"),
                is(equalTo("Hello Functional Interface")));
    }
}