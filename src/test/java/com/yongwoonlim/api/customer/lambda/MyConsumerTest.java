package com.yongwoonlim.api.customer.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

class MyConsumerTest {

    @Test
    void consumeTest() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        Consumer<Integer> consumer = System.out::println;

        printElements(numbers, consumer);
    }

    private static <T> void printElements(List<T> list, Consumer<T> consumer){
        for(T t: list){
            consumer.accept(t);
        }
    }
}