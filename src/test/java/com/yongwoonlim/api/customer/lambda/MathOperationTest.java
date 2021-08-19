package com.yongwoonlim.api.customer.lambda;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class MathOperationTest {

    @Test
    @DisplayName("Plus test")
    void plusTest() {
        MathOperation plus = operands -> {
            int result = 0;

            for (int operand : operands) {
                result += operand;
            }

            return result;
        };

        int[] numbers = IntStream.rangeClosed(0, 10).map(number -> new Random().nextInt(10)).toArray();

        assertThat(plus.main(numbers), is(equalTo(Arrays.stream(numbers).sum())));
    }

    @Test
    @DisplayName("Minus test")
    void minusTest() {
        MathOperation minus = operands -> {
            if (operands.length == 0) {
                return 0;
            }

            int result = operands[0];
            for (int i = 1; i < operands.length; i++) {
                result -= operands[i];
            }

            return result;
        };

        int[] numbers = IntStream.rangeClosed(0, 10).map((number) -> new Random().nextInt(10)).toArray();
        assertThat(minus.main(numbers), is(equalTo(Arrays.stream(numbers).reduce((x, y) -> x - y).getAsInt())));
    }

    @Test
    @DisplayName("Multiply test")
    void multiplyTest() {
        MathOperation multiply = operands -> {
            if (operands.length == 0) {
                return 0;
            }

            int result = 1;
            for (int operand : operands) {
                result *= operand;
            }

            return result;
        };

        int[] numbers = IntStream.rangeClosed(0, 10).map((number) -> new Random().nextInt(10)).toArray();
        assertThat(multiply.main(numbers), is(equalTo(Arrays.stream(numbers).reduce((x, y) -> x * y).getAsInt())));
    }
}