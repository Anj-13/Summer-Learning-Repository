# Calculator App — Basic Plan

## 1. Pre-Launch & Discovery

### Problem
Users need a simple calculator for basic arithmetic.

### MVP Scope
- Addition
- Subtraction
- Multiplication
- Division
- Percentage
- Power
- Square root
- Factorial
- Sine
- Cosine
- Tangent
- Calculation History (view, clear, save/load)
- Clear result
- Exit app

### Stretch Scope
- GUI
- Currency converter
- Unit converter
- Expression parser

---

## 2. Planning & Design

### Data Model
You do not need a complex model.

```java
double firstNumber;
double secondNumber;
String operator;
double result;
```

### Menu
```
===== Calculator =====
1.  Add
2.  Subtract
3.  Multiply
4.  Divide
5.  Percentage
6.  Power
7.  Square Root
8.  Factorial
9.  Sine
10. Cosine
11. Tangent
12. View History
13. Clear History
14. Exit
======================
```

### Classes
- `Calculator.java`
- `CalculationHistory.java`
- `Main.java`

---

## 3. Development

### Build Order

| Step | Task                       |
|------|----------------------------|
| 1    | Create calculator methods  |
| 2    | Create menu               |
| 3    | Handle user input         |
| 4    | Add divide-by-zero check  |
| 5    | Add advanced operations   |
| 6    | Add history               |
| 7    | Add file save for history |

### Methods

```java
double add(double a, double b)
double subtract(double a, double b)
double multiply(double a, double b)
double divide(double a, double b)
double power(double a, double b)
double squareRoot(double a)
double percentage(double a, double b)
double factorial(int a)
double sine(double degrees)
double cosine(double degrees)
double tangent(double degrees)
```

---

## 4. Testing & QA

| Test                      | Expected              |
|---------------------------|-----------------------|
| 5 + 3                     | 8                     |
| 5 - 3                     | 2                     |
| 5 * 3                     | 15                    |
| 6 / 3                     | 2                     |
| 5 / 0                     | Error message         |
| 2 ^ 3                     | 8                     |
| sqrt(9)                   | 3                     |
| 10% of 200                | 20                    |
| factorial(5)              | 120                   |
| sin(30)                   | 0.5                   |
| cos(60)                   | 0.5                   |
| tan(45)                   | 1.0                   |
| Invalid menu choice       | Ask again             |

---

## 5. Deployment & Launch

- Push to GitHub
- Add README
- Add example usage

---

## 6. Post-Launch

### Improvements
- JavaFX GUI
- Scientific calculator
- Currency converter
- Unit converter
- Expression parser

### Leads To
- Finance apps
- Data processing tools
- Scientific calculators
- Trading simulators
