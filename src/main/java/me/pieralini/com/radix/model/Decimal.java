package me.pieralini.com.radix.model;

import me.pieralini.com.radix.validation.RadixValidator;

import java.math.BigInteger;

public class Decimal extends RadixNumber {

    public Decimal() {
        this.internalValue = BigInteger.ZERO;
    }

    public Decimal(int value) {
        this.internalValue = BigInteger.valueOf(value);
    }

    public Decimal(long value) {
        this.internalValue = BigInteger.valueOf(value);
    }

    public Decimal(BigInteger value) {
        this.internalValue = value;
    }

    public Decimal(String value) {
        RadixValidator.validate(value, 10);
        this.internalValue = new BigInteger(value, 10);
    }

    @Override
    public int getRadix() {
        return 10;
    }

    @Override
    public String getValue() {
        return internalValue.toString(10);
    }

    public int getIntValue() {
        return internalValue.intValue();
    }

    @Override
    protected Decimal fromBigInteger(BigInteger value) {
        return new Decimal(value);
    }

    @Override
    public String toString() {
        return getValue();
    }
}
