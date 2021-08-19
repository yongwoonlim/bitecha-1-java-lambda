package com.yongwoonlim.api.customer.lambda;

public interface MyFunction<T, R> {
    R apply(T t);
}
