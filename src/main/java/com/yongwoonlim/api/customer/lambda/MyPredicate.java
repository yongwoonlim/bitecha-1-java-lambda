package com.yongwoonlim.api.customer.lambda;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}
