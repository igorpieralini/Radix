package me.pieralini.com;

import me.pieralini.com.radix.model.Binary;
import me.pieralini.com.radix.model.Decimal;
import me.pieralini.com.radix.model.HexaDecimal;

import static me.pieralini.com.radix.converter.RadixConverter.*;

public class Main {
    public static void main(String[] args) {

        // 1. CRIAÇÃO DE NÚMEROS EM DIFERENTES BASES

        System.out.println("\n▶ 1. CRIAÇÃO DE NÚMEROS");
        System.out.println("─".repeat(60));

        Binary binary = new Binary("11010110");
        Decimal decimal = new Decimal(214);
        HexaDecimal hex = new HexaDecimal("D6");

        System.out.println("Binário:     " + binary.getValue() + " (base 2)");
        System.out.println("Decimal:     " + decimal.getValue() + " (base 10)");
        System.out.println("Hexadecimal: " + hex.getValue() + " (base 16)");


        // 2. CONVERSÕES ENTRE BASES

        System.out.println("\n▶ 2. CONVERSÕES ENTRE BASES");
        System.out.println("─".repeat(60));

        Decimal num = new Decimal(255);
        System.out.println("Decimal 255:");
        System.out.println("  → Binário:     " + toBinary(num).getValue());
        System.out.println("  → Hexadecimal: " + toHexadecimal(num).getValue());

        Binary bin = new Binary("10101010");
        System.out.println("\nBinário 10101010:");
        System.out.println("  → Decimal:     " + toDecimal(bin).getValue());
        System.out.println("  → Hexadecimal: " + toHexadecimal(bin).getValue());

        HexaDecimal hexNum = new HexaDecimal("FF");
        System.out.println("\nHexadecimal FF:");
        System.out.println("  → Decimal:     " + toDecimal(hexNum).getValue());
        System.out.println("  → Binário:     " + toBinary(hexNum).getValue());

        System.out.println("\nConversão via métodos de instância:");
        Decimal d100 = new Decimal(100);
        System.out.println("  Decimal 100 → Binário:     " + d100.toBinary());
        System.out.println("  Decimal 100 → Hexadecimal: " + d100.toHexaDecimal());

        // 3. OPERAÇÕES ARITMÉTICAS

        System.out.println("\n▶ 3. OPERAÇÕES ARITMÉTICAS");
        System.out.println("─".repeat(60));

        Binary a = new Binary("1010");
        Binary b = new Binary("0101");

        System.out.println("a = " + a.getValue() + " (decimal: " + a.toDecimal() + ")");
        System.out.println("b = " + b.getValue() + " (decimal: " + b.toDecimal() + ")");
        System.out.println();

        System.out.println("Soma:         a + b = " + a.add(b).getValue() + " (decimal: " + a.add(b).toDecimal() + ")");
        System.out.println("Subtração:    a - b = " + a.subtract(b).getValue() + " (decimal: " + a.subtract(b).toDecimal() + ")");
        System.out.println("Multiplicação: a * b = " + a.multiply(b).getValue() + " (decimal: " + a.multiply(b).toDecimal() + ")");
        System.out.println("Divisão:      a / b = " + a.divide(b).getValue() + " (decimal: " + a.divide(b).toDecimal() + ")");
        System.out.println("Módulo:       a % b = " + a.mod(b).getValue() + " (decimal: " + a.mod(b).toDecimal() + ")");

        Decimal base = new Decimal(2);
        System.out.println("\nPotência: 2^10 = " + base.pow(10).getValue());

        Decimal square = new Decimal(144);
        System.out.println("Raiz quadrada de 144 = " + square.sqrt().getValue());

        Decimal negative = new Decimal(-50);
        System.out.println("\nNegativo: " + negative.getValue());
        System.out.println("Absoluto: " + negative.abs().getValue());
        System.out.println("Negação de 50: " + new Decimal(50).negate().getValue());

        // 4. OPERAÇÕES BITWISE

        System.out.println("\n▶ 4. OPERAÇÕES BITWISE");
        System.out.println("─".repeat(60));

        Binary x = new Binary("11110000");
        Binary y = new Binary("10101010");

        System.out.println("x = " + x.getValue());
        System.out.println("y = " + y.getValue());
        System.out.println();

        System.out.println("AND:      x & y = " + x.and(y).getValue());
        System.out.println("OR:       x | y = " + x.or(y).getValue());
        System.out.println("XOR:      x ^ y = " + x.xor(y).getValue());
        System.out.println("NOT x:    ~x    = " + x.not().getValue());

        // Shift operations
        Binary shift = new Binary("00001111");
        System.out.println("\nShift operations com " + shift.getValue() + ":");
        System.out.println("  Shift Left  2: " + shift.shiftLeft(2).getValue());
        System.out.println("  Shift Right 2: " + shift.shiftRight(2).getValue());


        // 5. COMPARAÇÕES

        System.out.println("\n▶ 5. COMPARAÇÕES");
        System.out.println("─".repeat(60));

        Decimal d1 = new Decimal(100);
        Decimal d2 = new Decimal(50);
        Decimal d3 = new Decimal(100);

        System.out.println("d1 = " + d1.getValue() + ", d2 = " + d2.getValue() + ", d3 = " + d3.getValue());
        System.out.println();

        System.out.println("d1 > d2:  " + d1.isGreaterThan(d2));
        System.out.println("d1 < d2:  " + d1.isLessThan(d2));
        System.out.println("d1 >= d3: " + d1.isGreaterOrEqual(d3));
        System.out.println("d1 <= d3: " + d1.isLessOrEqual(d3));
        System.out.println("d1 == d3: " + d1.equals(d3));

        Decimal zero = new Decimal(0);
        Decimal pos = new Decimal(42);
        Decimal neg = new Decimal(-42);

        System.out.println("\nVerificações especiais:");
        System.out.println("  0 é zero?     " + zero.isZero());
        System.out.println("  42 é positivo? " + pos.isPositive());
        System.out.println("  -42 é negativo? " + neg.isNegative());


        // 6. FORMATAÇÃO

        System.out.println("\n▶ 6. FORMATAÇÃO");
        System.out.println("─".repeat(60));

        Binary formatBin = new Binary("11010110");
        HexaDecimal formatHex = new HexaDecimal("A3F");
        Decimal formatDec = new Decimal(255);

        System.out.println("Padding (completar com zeros):");
        System.out.println("  Binário 11010110 com 16 dígitos: " + formatBin.pad(16));
        System.out.println("  Hex A3F com 8 dígitos: " + formatHex.pad(8));

        System.out.println("\nAgrupamento:");
        System.out.println("  Binário agrupado 4 em 4: " + formatBin.group(4, " "));
        System.out.println("  Binário agrupado 4 em 4 (separador _): " + formatBin.group(4, "_"));

        System.out.println("\nCom prefixo:");
        System.out.println("  Binário: " + formatBin.withPrefix());
        System.out.println("  Hexadecimal: " + formatHex.withPrefix());
        System.out.println("  Decimal: " + formatDec.withPrefix());

        System.out.println("\nCom base:");
        System.out.println("  Binário: " + formatBin.withBase());
        System.out.println("  Hexadecimal: " + formatHex.withBase());
        System.out.println("  Decimal: " + formatDec.withBase());


        // 7. EXEMPLO PRÁTICO: MÁSCARAS DE REDE

        System.out.println("\n▶ 7. EXEMPLO PRÁTICO: MÁSCARAS DE REDE");
        System.out.println("─".repeat(60));

        Binary ip1 = Binary.fromDecimal(192);
        Binary ip2 = Binary.fromDecimal(168);
        Binary ip3 = Binary.fromDecimal(1);
        Binary ip4 = Binary.fromDecimal(100);

        System.out.println("IP Address: 192.168.1.100");
        System.out.println("Em binário:");
        System.out.println("  " + ip1.pad(8) + "." + ip2.pad(8) + "." + ip3.pad(8) + "." + ip4.pad(8));

        Binary mask = new Binary("11111111");
        System.out.println("\nMáscara /24:");
        System.out.println("  " + mask.pad(8) + "." + mask.pad(8) + "." + mask.pad(8) + ".00000000");

        System.out.println("\nEndereço de rede (IP AND Máscara):");
        System.out.println("  Último octeto: " + ip4.getValue() + " AND 00000000 = " + ip4.and(new Binary("0")).getValue());



        // 8. OPERAÇÕES EM CADEIA (FLUENT API)

        System.out.println("\n▶ 9. OPERAÇÕES EM CADEIA (FLUENT API)");
        System.out.println("─".repeat(60));

        var resultado = new Decimal(10)
                .add(new Decimal(5))
                .multiply(new Decimal(2))
                .subtract(new Decimal(6))
                .divide(new Decimal(4));
        System.out.println("((10 + 5) * 2 - 6) / 4 = " + resultado.getValue());

        Binary binResult = new Decimal(255)
                .toBinary();
        System.out.println("\n255 em binário formatado: " + binResult.group(4, " "));
    }
}



