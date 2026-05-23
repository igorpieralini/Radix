package me.pieralini.com.radix.comparator;

import me.pieralini.com.radix.model.RadixNumber;

import java.math.BigInteger;

/**
 * Comparações entre RadixNumber.
 * Maior, menor, igual, zero, negativo, positivo.
 */
public class RadixComparator {

    /**
     * Compara dois RadixNumber.
     */
    public static int compare(RadixNumber a, RadixNumber b) {
        return a.toBigInteger().compareTo(b.toBigInteger());
    }

    /**
     * Verifica se a é maior que b.
     */
    public static boolean isGreaterThan(RadixNumber a, RadixNumber b) {
        return compare(a, b) > 0;
    }

    /**
     * Verifica se a é menor que b.
     */
    public static boolean isLessThan(RadixNumber a, RadixNumber b) {
        return compare(a, b) < 0;
    }

    /**
     * Verifica se a é maior ou igual a b.
     */
    public static boolean isGreaterOrEqual(RadixNumber a, RadixNumber b) {
        return compare(a, b) >= 0;
    }

    /**
     * Verifica se a é menor ou igual a b.
     */
    public static boolean isLessOrEqual(RadixNumber a, RadixNumber b) {
        return compare(a, b) <= 0;
    }

    /**
     * Verifica se dois RadixNumber representam o mesmo valor.
     */
    public static boolean isEqual(RadixNumber a, RadixNumber b) {
        return compare(a, b) == 0;
    }

    /**
     * Verifica se o valor é zero.
     */
    public static boolean isZero(RadixNumber a) {
        return a.toBigInteger().equals(BigInteger.ZERO);
    }

    /**
     * Verifica se o valor é negativo.
     */
    public static boolean isNegative(RadixNumber a) {
        return a.toBigInteger().signum() < 0;
    }

    /**
     * Verifica se o valor é positivo.
     */
    public static boolean isPositive(RadixNumber a) {
        return a.toBigInteger().signum() > 0;
    }
}

