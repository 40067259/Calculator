package com.concoridia.project;

import com.concoridia.project.service.CalculatorImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

  @Autowired CalculatorImp calculatorImp;

  private final double ACCURACY = 0.00001;

  @Test
  void testSin() {

    for (int i = 0; i < 20; i++) {
      double random = Math.random() * 1000; // create a random double from 0 - 999.9999
      double diff = Math.sin(random) - calculatorImp.sin(random);
      System.out.println(
          "We test a random number sin"
              + random
              + ", the result is "
              + (Math.abs(diff) <= ACCURACY));

      if (Math.abs(diff) > ACCURACY) System.out.println("The difference is ----> " + diff);
    }
  }

  @Test
  void testLog() {

    for (int i = 0; i < 20; i++) {
      double random = Math.random() * 1000; // create a random double from 0 - 999.9999
      double diff = Math.log(random) - calculatorImp.log(random);
      System.out.println(
          "We test a random number ln"
              + random
              + ", the result is "
              + (Math.abs(diff) <= ACCURACY));

      if (Math.abs(diff) > ACCURACY) System.out.println("The difference is ----> " + diff);
    }
  }

  @Test
  void testPow() {

    for (int i = 0; i < 20; i++) {
      double random =
          Math.random() * 10; // create a random double from 0 - 9.999 to keep it under the range
      double random1 =
          Math.random() * 10; // create a random double from 0 - 9.999 to keep it under the range
      double diff = Math.pow(random, random1) - calculatorImp.pow(random, random1);
      System.out.println(
          "We test a random number "
              + random
              + " power"
              + random1
              + ","
              + "the result is "
              + (Math.abs(diff) <= ACCURACY));

      if (Math.abs(diff) > ACCURACY) // if the accuracy is larger than our standard, display it
      System.out.println("The difference is ----> " + diff);
    }
  }

  @Test
  void testSinh() {

    for (int i = 0; i < 20; i++) {
      double random = Math.random() * 12; // create a random double from 0 - 11.9999
      double diff = Math.sinh(random) - calculatorImp.sinh(random);
      System.out.println(
          "We test a random number sinh"
              + random
              + ", the result is "
              + (Math.abs(diff) <= ACCURACY));

      if (Math.abs(diff) > ACCURACY) System.out.println("The difference is ----> " + diff);
    }
  }

  @Test
  void testEx() {

    for (int i = 0; i < 20; i++) {
      double random =
          Math.random() * 10; // create a random double from 0 - 9.9999 to keep it under the range
      double diff = Math.exp(random) - calculatorImp.exp(random);
      System.out.println(
          "We test a random number exp"
              + random
              + ", the result is "
              + (Math.abs(diff) <= ACCURACY));

      if (Math.abs(diff) > ACCURACY) System.out.println("The difference is ----> " + diff);
    }
  }

  @Test
  void pow10() {

    for (int i = 0; i < 20; i++) {
      double random =
          Math.random() * 10; // create a random double from 0 - 9.9999 to keep it under the range
      double diff = Math.pow(10, random) - calculatorImp.exp10(random);
      System.out.println(
          "We test a random number 10^"
              + random
              + ", the result is "
              + (Math.abs(diff) <= ACCURACY));

      if (Math.abs(diff) > ACCURACY) System.out.println("The difference is ----> " + diff);
    }
  }
}
