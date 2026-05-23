package me.pieralini.com.radix.converter;

import me.pieralini.com.radix.model.Binary;
import me.pieralini.com.radix.model.Decimal;
import me.pieralini.com.radix.model.HexaDecimal;

public class RadixConverter {

    public static Decimal toDecimal(Binary binary) {
        String binaryValue = binary.getValue();
        int decimalValue = 0;
        int length = binaryValue.length();

        for (int i = 0; i < length; i++) {
            char bit = binaryValue.charAt(length - 1 - i);
            if (bit == '1') {
                decimalValue += (int) Math.pow(2, i);
            }
        }

        return new Decimal(decimalValue);
    }

    public static HexaDecimal toHexadecimal(Binary binary) {
        int decimalValue = toDecimal(binary).getIntValue();
        return decimalToHex(decimalValue);
    }

    public static Binary toBinary(Decimal decimal) {
        int decimalValue = decimal.getIntValue();

        if (decimalValue == 0) {
            return new Binary("0");
        }

        StringBuilder binaryValue = new StringBuilder();

        while (decimalValue > 0) {
            int remainder = decimalValue % 2;
            binaryValue.insert(0, remainder);
            decimalValue /= 2;
        }

        return new Binary(binaryValue.toString());
    }

    public static HexaDecimal toHexadecimal(Decimal decimal) {
        return decimalToHex(decimal.getIntValue());
    }

    public static Decimal toDecimal(HexaDecimal hexadecimal) {
        String hexValue = hexadecimal.getValue().toUpperCase();
        int decimalValue = 0;
        int length = hexValue.length();

        for (int i = 0; i < length; i++) {
            char hexDigit = hexValue.charAt(length - 1 - i);
            int digitValue;

            if (hexDigit >= '0' && hexDigit <= '9') {
                digitValue = hexDigit - '0';
            } else {
                digitValue = hexDigit - 'A' + 10;
            }
            decimalValue += digitValue * (int) Math.pow(16, i);
        }

        return new Decimal(decimalValue);
    }

    public static Binary toBinary(HexaDecimal hexadecimal) {
        int decimalValue = toDecimal(hexadecimal).getIntValue();

        if (decimalValue == 0) {
            return new Binary("0");
        }

        StringBuilder binaryValue = new StringBuilder();

        while (decimalValue > 0) {
            int remainder = decimalValue % 2;
            binaryValue.insert(0, remainder);
            decimalValue /= 2;
        }

        return new Binary(binaryValue.toString());
    }

    private static HexaDecimal decimalToHex(int decimalValue) {
        if (decimalValue == 0) {
            return new HexaDecimal("0");
        }

        StringBuilder hexValue = new StringBuilder();

        while (decimalValue > 0) {
            int remainder = decimalValue % 16;
            char hexDigit;

            if (remainder < 10) {
                hexDigit = (char) ('0' + remainder);
            } else {
                hexDigit = (char) ('A' + remainder - 10);
            }

            hexValue.insert(0, hexDigit);
            decimalValue /= 16;
        }

        return new HexaDecimal(hexValue.toString());
    }
}

