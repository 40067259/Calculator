package com.concoridia.project.service;

import org.springframework.stereotype.Service;

/**
 * @author Fred Zhang
 * @create 2020-05-11 11:20 AM
 */
// The calculator functions which we need to implement
// It is easy to extend when we need extra functions
public interface Calculation {

  /** <i>e</i> (Euler's constant) */
  double E = e();

  /** <i>π</i> (Archimedes' constant) */
  double PI = pi();

  /**
   * Returns the value of the first number raised to the power of the second number, throwing an
   * exception if the first number is less than 0 and the second number is decimal.
   *
   * @param x base
   * @param y exponent
   * @return <i>x</i><sup><i>y</i></sup>
   * @throws ArithmeticException if <i>x</i>&nbsp;<&nbsp;0 and y is decimal
   */
  double pow(double x, double y);

  /**
   * Returns the trigonometric sine of an angle.
   *
   * @param x angle, in radians
   * @return sin&nbsp;<i>x</i>
   */
  double sin(double x);

  /**
   * Returns the hyperbolic sine of a number.
   *
   * @param x number
   * @return sinh&nbsp;<i>x</i>
   */
  double sinh(double x);

  /**
   * Returns <i>e</i>(Euler's constant) raised to the power of a number.
   *
   * @param x exponent
   * @return <i>e</i><sup><i>x</i></sup>
   */
  double exp(double x);

  /**
   * Returns 10 raised to the power of a number.
   *
   * @param x exponent
   * @return 10<sup><i>x</i></sup>
   */
  double exp10(double x);

  /**
   * Returns the natural logarithm of a number, throwing an exception if the number is less than or
   * equal to 0.
   *
   * @param x number
   * @return ln&nbsp;<i>x</i>
   * @throws ArithmeticException if <i>x</i>&nbsp;<=&nbsp;0
   */
  double log(double x);

  /**
   * Returns the base 10 logarithm of a number, throwing an exception if the number is less than or
   * equal to 0.
   *
   * @param x number
   * @return log<sub>10&nbsp;</sub><i>x</i>
   * @throws ArithmeticException if <i>x</i>&nbsp;<=&nbsp;0
   */
  double log10(double x);

  /**
   * Returns the factorial of a number, throws an exception the number is less than 0.
   *
   * @param x number
   * @return x!
   * @throws ArithmeticException if <i>x</i>&nbsp;<&nbsp;0
   */
  int factorial(int x);

  public static double e() {
    double exp = 0;

    double numerator = 1;
    double denominator = 1;
    for (int i = 0; i < 130; i++) {
      double term = numerator / denominator;
      exp += term;

      numerator *= 1;
      denominator *= i + 1;
    }

    return exp;
  }

  public static double pi() {
    double ramanujan = 0;

    double term = 1103;
    for (int i = 0; i < 3; i++) {
      ramanujan += term;

      term =
          term
              * (4 * i + 1)
              * (4 * i + 2)
              * (4 * i + 3)
              * (4 * i + 4)
              / (1103 + 26390 * i)
              * (1103 + 26390 * (i + 1))
              / (i + 1)
              / (i + 1)
              / (i + 1)
              / (i + 1)
              / 24591257856d;
    }

    final double SQRT2 = 1.414213562373095;

    return 9801 / ramanujan / 2 / SQRT2;
  }

  /**
   * @param x
   * @param y
   * @return double x + y
   */
  double add(double x, double y);
  /**
   * @param x
   * @param y
   * @return double x - y
   */
  double sub(double x, double y);
  /**
   * @param x
   * @param y
   * @return double x times y
   */
  double mul(double x, double y);
  /**
   * @param x
   * @param y
   * @return double x / y
   */
  double div(double x, double y);

  /**
   * @param x
   * @return a double after a complex calculation:sin5 + log3
   */
  double complex(String x);
}
