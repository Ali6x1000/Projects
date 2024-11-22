# Math Function Library 📚

This project provides a collection of classes that represent various mathematical functions and their derivatives. The library allows you to define functions, evaluate their values, and compute their derivatives. ⚙️

## Classes 🧑‍💻

### `Function` 🏛️
The `Function` interface defines the structure for mathematical functions. It includes methods for evaluating the function at a given input and computing its derivative.

Methods:
- `double value(double input)`: Returns the value of the function at the given input. 🔢
- `Function derivative()`: Returns the derivative of the function. 🔄

### `Number` 🔢
Represents a constant number. The `Number` class always returns its constant value when evaluated, and its derivative is always 0. 🛑

Methods:
- `double value(double x)`: Returns the constant value. 💯
- `Function derivative()`: Returns `Number(0)`. 🚫

### `Variable` 📏
Represents the variable `x`. When evaluated, it returns the value of `x`, and its derivative is always 1. 🔑

Methods:
- `double value(double x)`: Returns the value of the variable `x`. 🔄
- `Function derivative()`: Returns `Number(1)`. ➕

### `Sin` 🔺
Represents the sine function. The sine function is defined as `sin(f(x))` where `f(x)` is another function.

Methods:
- `double value(double x)`: Returns the value of `sin(f(x))`. 🌊
- `Function derivative()`: Computes the derivative using the chain rule: `cos(f(x)) * f'(x)`. ➗

### `Cos` 🔵
Represents the cosine function. The cosine function is defined as `cos(f(x))` where `f(x)` is another function.

Methods:
- `double value(double x)`: Returns the value of `cos(f(x))`. 🌀
- `Function derivative()`: Computes the derivative using the chain rule: `-sin(f(x)) * f'(x)`. ➖

### `Exp` 📈
Represents the natural exponential function. The exponential function is defined as `exp(f(x))` where `f(x)` is another function.

Methods:
- `double value(double x)`: Returns the value of `exp(f(x))`. 🚀
- `Function derivative()`: Computes the derivative using the chain rule: `exp(f(x)) * f'(x)`. 🔄

### `Log` 📊
Represents the natural logarithm function. The logarithmic function is defined as `log(f(x))` where `f(x)` is another function.

Methods:
- `double value(double x)`: Returns the value of `log(f(x))`. 🔍
- `Function derivative()`: Computes the derivative using the formula `f'(x) / f(x)`. ➗

### `Polynomial` 📏
Represents a function raised to a power. The polynomial function is defined as `(f(x))^n` where `f(x)` is another function, and `n` is a constant.

Methods:
- `double value(double x)`: Returns the value of `(f(x))^n`. 📐
- `Function derivative()`: Computes the derivative using the power rule: `n * (f(x))^(n-1) * f'(x)`. 🔢

### `BinaryOp` ➗✖️
Represents a binary operator (`+`, `-`, `*`, `/`) that operates on two functions.

Methods:
- `double value(double x)`: Returns the result of the operation applied to the two operand functions. ⚖️
- `Function derivative()`: Computes the derivative of the operation using standard derivative rules. ➕

## Example Usage 📝

```java
Function f = new Sin(new Variable());
Function fDerivative = f.derivative();
double valueAtX = f.value(1.0);
double derivativeAtX = fDerivative.value(1.0);
