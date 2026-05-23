# Radix

Uma futura biblioteca Maven para manipulação de números em diferentes bases numéricas (binário, decimal e hexadecimal).

## 📋 Funcionalidades

- **Representação de números** em Binary, Decimal e HexaDecimal
- **Conversões** entre diferentes bases numéricas
- **Operações aritméticas**: soma, subtração, multiplicação, divisão, módulo, potência, raiz quadrada
- **Operações bitwise**: AND, OR, XOR, NOT, shift left/right
- **Comparações**: maior, menor, igual, verificações de zero/positivo/negativo
- **Formatação**: padding, agrupamento, prefixos

## 📁 Estrutura do Projeto

```
src/main/java/me/pieralini/com/radix/
├── model/
│   ├── RadixNumber.java    # Classe base abstrata
│   ├── Binary.java         # Representação binária
│   ├── Decimal.java        # Representação decimal
│   └── HexaDecimal.java    # Representação hexadecimal
├── converter/
│   └── RadixConverter.java # Conversões entre bases
├── operation/
│   ├── RadixArithmetic.java # Operações aritméticas
│   └── RadixBitwise.java    # Operações bitwise
├── comparator/
│   └── RadixComparator.java # Comparações
├── formatter/
│   └── RadixFormatter.java  # Formatação
└── validation/
    └── RadixValidator.java  # Validação
```
