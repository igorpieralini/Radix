package me.pieralini.com.radix.model;

import me.pieralini.com.radix.validation.RadixValidator;

import java.math.BigInteger;

public class Binary extends RadixNumber {

    public Binary() {
        this.internalValue = BigInteger.ZERO;
    }

    public Binary(String value) {
        RadixValidator.validate(value, 2);
        this.internalValue = new BigInteger(value, 2);
    }

    public Binary(BigInteger value) {
        this.internalValue = value;
    }

    @Override
    public int getRadix() {
        return 2;
    }

    @Override
    public String getValue() {
        return internalValue.toString(2);
    }

    @Override
    protected Binary fromBigInteger(BigInteger value) {
        return new Binary(value);
    }

    public static Binary fromDecimal(int decimal) {
        return new Binary(BigInteger.valueOf(decimal));
    }

    @Override
    public String toString() {
        return getValue();
    }
}