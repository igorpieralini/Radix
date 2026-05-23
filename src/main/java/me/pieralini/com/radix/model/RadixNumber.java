package me.pieralini.com.radix.model;

import me.pieralini.com.radix.comparator.RadixComparator;
import me.pieralini.com.radix.formatter.RadixFormatter;
import me.pieralini.com.radix.operation.RadixArithmetic;
import me.pieralini.com.radix.operation.RadixBitwise;
import me.pieralini.com.radix.validation.RadixValidator;

import java.math.BigInteger;
import java.util.Objects;

public abstract class RadixNumber implements Comparable<RadixNumber> {

    protected BigInteger internalValue;

    public abstract int getRadix();

    public abstract String getValue();

    protected abstract RadixNumber fromBigInteger(BigInteger value);

    public int toDecimal() {
        return internalValue.intValue();
    }

    public long toLong() {
        return internalValue.longValue();
    }

    public BigInteger toBigInteger() {
        return internalValue;
    }

    public Binary toBinary() {
        return new Binary(internalValue.toString(2));
    }

    public Decimal toDecimalObj() {
        return new Decimal(internalValue);
    }

    public HexaDecimal toHexaDecimal() {
        return new HexaDecimal(internalValue.toString(16).toUpperCase());
    }

    public RadixNumber add(RadixNumber other) {
        return fromBigInteger(RadixArithmetic.add(this, other));
    }

    public RadixNumber subtract(RadixNumber other) {
        return fromBigInteger(RadixArithmetic.subtract(this, other));
    }

    public RadixNumber multiply(RadixNumber other) {
        return fromBigInteger(RadixArithmetic.multiply(this, other));
    }

    public RadixNumber divide(RadixNumber other) {
        return fromBigInteger(RadixArithmetic.divide(this, other));
    }

    public RadixNumber mod(RadixNumber other) {
        return fromBigInteger(RadixArithmetic.mod(this, other));
    }

    public RadixNumber pow(int exponent) {
        return fromBigInteger(RadixArithmetic.pow(this, exponent));
    }

    public RadixNumber abs() {
        return fromBigInteger(RadixArithmetic.abs(this));
    }

    public RadixNumber negate() {
        return fromBigInteger(RadixArithmetic.negate(this));
    }

    public RadixNumber sqrt() {
        return fromBigInteger(RadixArithmetic.sqrt(this));
    }

    public RadixNumber and(RadixNumber other) {
        return fromBigInteger(RadixBitwise.and(this, other));
    }

    public RadixNumber or(RadixNumber other) {
        return fromBigInteger(RadixBitwise.or(this, other));
    }

    public RadixNumber xor(RadixNumber other) {
        return fromBigInteger(RadixBitwise.xor(this, other));
    }

    public RadixNumber not() {
        return fromBigInteger(RadixBitwise.not(this));
    }

    public RadixNumber shiftLeft(int n) {
        return fromBigInteger(RadixBitwise.shiftLeft(this, n));
    }

    public RadixNumber shiftRight(int n) {
        return fromBigInteger(RadixBitwise.shiftRight(this, n));
    }

    @Override
    public int compareTo(RadixNumber other) {
        return RadixComparator.compare(this, other);
    }

    public boolean isGreaterThan(RadixNumber other) {
        return RadixComparator.isGreaterThan(this, other);
    }

    public boolean isLessThan(RadixNumber other) {
        return RadixComparator.isLessThan(this, other);
    }

    public boolean isGreaterOrEqual(RadixNumber other) {
        return RadixComparator.isGreaterOrEqual(this, other);
    }

    public boolean isLessOrEqual(RadixNumber other) {
        return RadixComparator.isLessOrEqual(this, other);
    }

    public boolean isZero() {
        return RadixComparator.isZero(this);
    }

    public boolean isNegative() {
        return RadixComparator.isNegative(this);
    }

    public boolean isPositive() {
        return RadixComparator.isPositive(this);
    }

    public String pad(int totalDigits) {
        return RadixFormatter.pad(this, totalDigits);
    }

    public String group(int groupSize, String separator) {
        return RadixFormatter.group(this, groupSize, separator);
    }

    public String withPrefix() {
        return RadixFormatter.withPrefix(this);
    }

    public String withBase() {
        return RadixFormatter.withBase(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof RadixNumber)) return false;
        RadixNumber other = (RadixNumber) obj;
        return this.internalValue.equals(other.internalValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internalValue);
    }
}
