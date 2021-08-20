package com.yongwoonlim.api.customer.lambda;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class MyPredicateTest {

    @Test
    void testTest() {
        List<String> list = new ArrayList<>();
        list.add("Bithumb");
        list.add("");
        list.add("KakaoTalk");
        list.add("");
        list.add("Bitcamp");

        MyPredicate<String> myPredicate = string -> !string.isEmpty();
        List<String> filteredList = filter(list, myPredicate);
        assertThat(filteredList, is(equalTo(Arrays.asList("Bithumb", "KakaoTalk", "Bitcamp"))));

        MyPredicate<String> myFilterPredicate = string -> string.contains("Talk");
        List<String> talkFilteredList = filter(list, myFilterPredicate);
        assertThat(talkFilteredList, is(equalTo(Collections.singletonList("KakaoTalk"))));

        List<Integer> numbers = Arrays.asList(1, 4, 6, 7, 8);
        MyPredicate<Integer> evenFilter = number -> number % 2 == 0;
        List<Integer> evenFilteredNumbers = filter(numbers, evenFilter);
        assertThat(evenFilteredNumbers, is(equalTo(Arrays.asList(4, 6, 8))));
    }

    private static <T> List<T> filter(List<T> list, MyPredicate<T> myPredicate) {
        List<T> filteredList = new ArrayList<>();

        for (T string : list) {
            if (myPredicate.test(string)) {
                filteredList.add(string);
            }
        }

        return filteredList;
    }
}