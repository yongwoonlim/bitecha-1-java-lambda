package com.yongwoonlim.api.customer.lambda;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class MyUnaryOperatorTest {

    @Test
    void unaryOperatorTest() {
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50);
        MyUnaryOperator<Integer> myUnaryOperator = i -> i * 100;
        List<Integer> newList = mapper(list, myUnaryOperator);
        assertThat(newList, is(equalTo(Arrays.asList(1000, 2000, 3000, 4000, 5000))));
    }

    private static <T> List<T> mapper(List<T> list, MyUnaryOperator<T> operator) {
        List<T> newList = new ArrayList<>();

        for (T element : list) {
            newList.add(operator.apply(element));
        }

        return newList;
    }
}