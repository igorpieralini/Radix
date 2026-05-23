package me.pieralini.com.radix.operation;

import me.pieralini.com.radix.model.RadixNumber;

import java.math.BigInteger;

public class RadixBitwise {

    /**
     * AND
     */
    public static BigInteger and(RadixNumber a, RadixNumber b) {
        return a.toBigInteger().and(b.toBigInteger());
    }

    /**
     * OR
     */
    public static BigInteger or(RadixNumber a, RadixNumber b) {
        return a.toBigInteger().or(b.toBigInteger());
    }

    /**
     * XOR
     */
    public static BigInteger xor(RadixNumber a, RadixNumber b) {
        return a.toBigInteger().xor(b.toBigInteger());
    }

    /**
     * NOT
     */
    public static BigInteger not(RadixNumber a) {
        return a.toBigInteger().not();
    }

    /**
     * Deslocamento de bits à esquerda.
     */
    public static BigInteger shiftLeft(RadixNumber a, int n) {
        return a.toBigInteger().shiftLeft(n);
    }

    /**
     * Deslocamento de bits à direita.
     */
    public static BigInteger shiftRight(RadixNumber a, int n) {
        return a.toBigInteger().shiftRight(n);
    }
}

