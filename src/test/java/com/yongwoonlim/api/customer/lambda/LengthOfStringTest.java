package com.yongwoonlim.api.customer.lambda;

import net.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

class LengthOfStringTest {

    @Test
    @DisplayName("Functional string length count test")
    void mainTest() {
        LengthOfString lengthOfString = str -> {
            int strLength = str.length();
            System.out.println("The length of random string '" + str + "' is " + strLength);
            return strLength;
        };

        String randomString = RandomString.make(new Random().nextInt(100));

        assertThat(lengthOfString.main(randomString), is(equalTo(randomString.length())));
    }
}