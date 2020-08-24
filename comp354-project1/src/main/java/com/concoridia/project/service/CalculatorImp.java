package com.concoridia.project.service;

import org.springframework.stereotype.Service;

/**
 * @author Fred Zhang
 * @create 2020-05-11 11:14 AM
 */
// It is a class to implement the desired functions
// We consider it a javaBean and put it to IOC
//
@Service
public class CalculatorImp implements Calculation {

  @Override
  public double pow(double x, double y) {
    if (isInt(y)) return round(pow(x, (int) Math.round(y)));

    // x^y = e^(y * lnx)
    return round(exp(y * log(x)));
  }

  /**
   * Returns the value of the first number raised to the power of the second number.
   *
   * @param x base
   * @param y exponent
   * @return <i>x</i><sup><i>y</i></sup>
   */
  private double pow(double x, int y) {
    double pow = 1;

    if (y < 0) {
      x = 1 / x;
      y = -y;
    }

    for (; y != 0; x *= x, y /= 2) {
      if (y % 2 == 1) pow *= x;
    }

    return round(pow);
  }

  @Override
  public double exp(double x) {
    double exp = 0;

    // Taylor series expansion
    double numerator = 1;
    double denominator = 1;
    for (int i = 0; i < 130; i++) {
      double term = numerator / denominator;
      exp += term;

      numerator *= x;
      denominator *= i + 1;
    }

    return round(exp);
  }

  @Override
  public double exp10(double x) {
    // 10^x = e^(x * ln10)
    return round(exp(x * LOG10));
  }

  @Override
  public double log(double x) {
    if (x <= 0) throw new ArithmeticException();

    double log = 0;

    // ln(x / 10) = lnx - ln10
    if (x < 2.0 / 11) {
      while (x < 2.0 / 11) {
        x *= 10;
        log -= LOG10;
      }
    }
    // ln(x * 10) = lnx + ln10
    else if (x > 20.0 / 11) {
      while (x > 20.0 / 11) {
        x /= 10;
        log += LOG10;
      }
    }

    return round(log + log1p(x - 1));
  }

  /**
   * Returns the natural logarithm of a number plus 1.
   *
   * @param x number
   * @return ln&nbsp;<i>(1 + x)</i>
   */
  private double log1p(double x) {
    double log1p = 0;

    // Taylor series expansion
    int sign = 1;
    double numerator = x;
    double denominator = 1;
    for (int i = 1; i < 159; i++) {
      double term = sign * numerator / denominator;
      log1p += term;

      sign = -sign;
      numerator *= x;
      denominator += 1;
    }

    return log1p;
  }

  @Override
  public double log10(double x) {
    // log_10(x) = lnx / ln10
    return round(log(x) / LOG10);
  }

  @Override
  public double sin(double x) {
    double sin = 0;

    // shrink the domain to [-PI * 2, PI * 2] using the property of periodic functions
    int sign;
    x %= 2 * PI;
    if (x > -2 * PI && x < -3.0 * PI / 2) {
      x += 2 * PI;
      sign = 1;
    } else if (x >= -3.0 * PI / 2 && x < -PI / 2) {
      x += PI;
      sign = -1;
    } else if (x > PI / 2 && x <= 3 * PI / 2) {
      x -= PI;
      sign = -1;
    } else if (x > 3 * PI / 2 && x < 2 * PI) {
      x -= 2 * PI;
      sign = 1;
    } else sign = 1;

    // Taylor series expansion
    double numerator = x;
    double denominator = 1;
    for (int i = 0; i < 11; i++) {
      double term = sign * numerator / denominator;
      sin += term;

      sign = -sign;
      numerator *= x * x;
      denominator *= (2 * i + 2) * (2 * i + 3);
    }

    return round(sin);
  }

  @Override
  public double sinh(double x) {
    double sinh = 0;

    // Taylor series expansion
    double numerator = x;
    double denominator = 1;
    for (int i = 0; i < 66; i++) {
      double term = numerator / denominator;
      sinh += term;

      numerator *= x * x;
      denominator *= (2 * i + 2) * (2 * i + 3);
    }

    return round(sinh);
  }

  @Override
  public int factorial(int x) {
    if (x < 0) throw new ArithmeticException();

    int factorial = 1;

    for (int i = x; i > 0; i--) factorial *= i;

    return factorial;
  }

  private static final double LOG10 = 2.30258509299404568402;

  private boolean isInt(double num) {
    return num > Math.round(num) - 0.000001 && num < Math.round(num) + 0.000001;
  }

  public double round(double num) {
    if (isInt(num)) return Math.round(num);
    else return num;
  }
  // if a number is very close to an integer(actually it is, double tight error)
  public boolean isFakeDouble(double num) {

    return num == Math.round(num);
  }

  @Override
  public double add(double x, double y) {
    return x + y;
  }

  @Override
  public double sub(double x, double y) {
    return x - y;
  }

  @Override
  public double mul(double x, double y) {
    return x * y;
  }

  @Override
  public double div(double x, double y) {
    if (y == 0) throw new IllegalArgumentException("divisor is 0");
    return x / y;
  }

  @Override
  public double complex(String x) {
    return MyParser.complexCalculation(x);
  }

  public static void main(String[] args) {

    // ---------Our test under test package,please go there to check out---------

  }
}
