package com.yongwoonlim.api.customer.lambda;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class MyFunctionTest {

    @Test
    void applyTest() {
        MyFunction<String, Integer> myFunction = String::length;
        List<String> list = IntStream.rangeClosed(0, 10).mapToObj(value ->  RandomString.make(new Random().nextInt(9)+1)).collect(Collectors.toList());
        List<Integer> lengthList = map(list, myFunction);

        for (int i = 0; i < list.size(); i++) {
            assertThat(list.get(i).length(), is(equalTo(lengthList.get(i))));
        }
    }

    public static <T, R> List<R> map(List<T> list, MyFunction<T, R> function) {
        Objects.requireNonNull(list);
        List<R> newList = new ArrayList<>();
        for (T element : list) {
            newList.add(function.apply(element));
        }

        return newList;
    }
}