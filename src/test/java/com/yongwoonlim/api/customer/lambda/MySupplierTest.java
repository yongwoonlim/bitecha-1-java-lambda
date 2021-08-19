package com.yongwoonlim.api.customer.lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class MySupplierTest {

    @Test
    void getTest() {
        String string = "12345";
        MySupplier mySupplier = () -> "12345";

        assertThat(string, is(equalTo(mySupplier.get())));
    }
}