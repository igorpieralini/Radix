package me.pieralini.com.radix.validation;

public class RadixValidator {

    public static void validate(String value, int radix) {

        String validChars;
        String baseName;
        String toCheck = value;

        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Valor não pode ser nulo ou vazio.");
        }

        if (toCheck.startsWith("-")) {
            toCheck = toCheck.substring(1);
        }

        if (toCheck.isEmpty()) {
            throw new IllegalArgumentException("Valor não pode ser apenas um sinal negativo.");
        }

        switch (radix) {

            case 2:
                validChars = "01";
                baseName = "binário (base 2)";
                break;

            case 10:
                validChars = "0123456789";
                baseName = "decimal (base 10)";
                break;

            case 16:
                validChars = "0123456789ABCDEFabcdef";
                baseName = "hexadecimal (base 16)";
                break;

            default:
                throw new IllegalArgumentException("Base não suportada: " + radix);
        }

        for (char c : toCheck.toCharArray()) {   
            if (validChars.indexOf(c) == -1) {
                throw new IllegalArgumentException(
                        "Caractere inválido '" + c + "' para " + baseName + ". Valor: " + value
                );
            }
        }
    }

    public static boolean isValid(String value, int radix) {
        
        try {
            validate(value, radix);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
        
    }
}

