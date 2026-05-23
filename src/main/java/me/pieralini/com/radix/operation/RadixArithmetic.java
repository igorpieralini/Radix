package me.pieralini.com.radix.operation;

import me.pieralini.com.radix.model.RadixNumber;

import java.math.BigInteger;

public class RadixArithmetic {

    /**
     * Soma dois RadixNumber.
     */
    public static BigInteger add(RadixNumber a, RadixNumber b) {
        return a.toBigInteger().add(b.toBigInteger());
    }

    /**
     * Subtrai b de a.
     */
    public static BigInteger subtract(RadixNumber a, RadixNumber b) {
        return a.toBigInteger().subtract(b.toBigInteger());
    }

    /**
     * Multiplica a por b.
     */
    public static BigInteger multiply(RadixNumber a, RadixNumber b) {
        return a.toBigInteger().multiply(b.toBigInteger());
    }

    /**
     * Divide a por b (divisão inteira).
     */
    public static BigInteger divide(RadixNumber a, RadixNumber b) {
        return a.toBigInteger().divide(b.toBigInteger());
    }

    /**
     * Calcula o resto da divisão de a por b.
     */
    public static BigInteger mod(RadixNumber a, RadixNumber b) {
        return a.toBigInteger().remainder(b.toBigInteger());
    }

    /**
     * Eleva a à potência exponent.
     */
    public static BigInteger pow(RadixNumber a, int exponent) {
        return a.toBigInteger().pow(exponent);
    }

    /**
     * Valor absoluto de a.
     */
    public static BigInteger abs(RadixNumber a) {
        return a.toBigInteger().abs();
    }

    /**
     * Inverte o sinal de a.
     */
    public static BigInteger negate(RadixNumber a) {
        return a.toBigInteger().negate();
    }

    /**
     * Raiz quadrada inteira de a.
     */
    public static BigInteger sqrt(RadixNumber a) {
        return a.toBigInteger().sqrt();
    }
}

