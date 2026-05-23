package me.pieralini.com.radix.model;

import me.pieralini.com.radix.validation.RadixValidator;
import java.math.BigInteger;

public class HexaDecimal extends RadixNumber {

    public HexaDecimal() {
        this.internalValue = BigInteger.ZERO;
    }

    public HexaDecimal(String value) {
        RadixValidator.validate(value, 16);
        this.internalValue = new BigInteger(value, 16);
    }

    public HexaDecimal(BigInteger value) {
        this.internalValue = value;
    }

    @Override
    public int getRadix() {
        return 16;
    }

    @Override
    public String getValue() {
        return internalValue.toString(16).toUpperCase();
    }

    @Override
    protected HexaDecimal fromBigInteger(BigInteger value) {
        return new HexaDecimal(value);
    }

    public static HexaDecimal fromDecimal(int decimal) {
        return new HexaDecimal(BigInteger.valueOf(decimal));
    }

    @Override
    public String toString() {
        return getValue();
    }
}
