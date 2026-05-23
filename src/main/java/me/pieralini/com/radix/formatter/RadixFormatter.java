package me.pieralini.com.radix.formatter;

import me.pieralini.com.radix.model.RadixNumber;

public class RadixFormatter {

    /**
     * Adiciona zeros à esquerda até atingir o total de dígitos.
     */
    public static String pad(RadixNumber number, int totalDigits) {
        String val = number.getValue();
        if (val.length() >= totalDigits) return val;
        return "0".repeat(totalDigits - val.length()) + val;
    }

    /**
     * Agrupa dígitos com separador para facilitar leitura.
     */
    public static String group(RadixNumber number, int groupSize, String separator) {

        StringBuilder result = new StringBuilder();

        String val = number.getValue();
        int remainder = val.length() % groupSize;

        if (remainder != 0) {
            val = "0".repeat(groupSize - remainder) + val;
        }

        for (int i = 0; i < val.length(); i += groupSize) {

            if (result.length() > 0) {
                result.append(separator);
            }

            result.append(val, i, i + groupSize);
        }

        return result.toString();
    }

    /**
     * Retorna o valor com o prefixo da base.
     */
    public static String withPrefix(RadixNumber number) {
        switch (number.getRadix()) {
            case 2:
                return "0b" + number.getValue();
            case 16:
                return "0x" + number.getValue();
            default:
                return number.getValue();
        }
    }

    /**
     * Retorna uma representação completa com base.
     */
    public static String withBase(RadixNumber number) {
        return number.getValue() + " (base " + number.getRadix() + ")";
    }
}

