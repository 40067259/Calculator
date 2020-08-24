package com.concoridia.project.controller;

import com.concoridia.project.entities.Operation;
import com.concoridia.project.service.CalculatorImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * @author Fred Zhang
 * @create 2020-05-10 10:58 AM
 */
@Controller
public class CalculatorController {
  int style = 0;
  // Get javaBean and use it functions to calculate
  @Autowired CalculatorImp calculatorImp;

  public void modifyPattern(Map<String, Object> map) {
    if (this.style == 1) {
      map.put("button1", "background:#006666;");
      map.put("background", "background:#1f3347;");
      map.put("display", "background:#1f3347;");
      map.put("equal", "background:#00661a");
    } else if (this.style == 2) {
      map.put("button1", "background:gray;");
      map.put("background", "background:#303336;");
      map.put("display", "background:gray;");
      map.put("equal", "background:#808080");
    }
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String getHome() {
    return "advance";
  }

  @PostMapping(value = "/pattern")
  public String pattern(Map<String, Object> map) {
    if (this.style == 0 || this.style == 1) this.style++;
    else this.style = 0;
    modifyPattern(map);
    return "advance";
  }

  @PostMapping(value = "/complex")
  public String postComplex(Map<String, Object> map, String operand3) {
    modifyPattern(map);
    double res = 0;
    try {
      res = calculatorImp.complex(operand3);
    } catch (Exception e) {
      map.put("error", " Invalid expression");
      return "advance";
    }
    if (calculatorImp.isFakeDouble(res)) {
      int resInt = (int) res;
      map.put("value", resInt);
      return "advance";
    }
    map.put("value", res);
    return "advance";
  }

  // Handle post from advance
  @PostMapping(value = "/")
  public String postAdvance(Map<String, Object> map, Operation operation) {
    // ----------------Check General Validation------------------
    // check the operator missed or not
   modifyPattern(map);
    if (operation.getOperator().equals("")) {
      map.put("error", "miss operator");
      return "advance";
    }
    // check the essential value missed or not
    if (operation.getOperand1() == null) {
      map.put("error", "miss operand");
      return "advance";
    }

    // ----------------Calculate and return solution-------------

    double solution = 0;
    // call corresponding function to get sin value
    if (operation.getOperator().equals("sin"))
      solution = calculatorImp.sin(operation.getOperand1());

    // call corresponding function to get exp10 value
    else if (operation.getOperator().equals("exp1o"))
      solution = calculatorImp.exp10(operation.getOperand1());

    // call corresponding function to get log value
    else if (operation.getOperator().equals("log")) {
      if (operation.getOperand1() <= 0) {

        map.put("error", "x should be positive");
        return "advance";
      }
      solution = calculatorImp.log(operation.getOperand1());
    }

    // call corresponding function to get exp value
    else if (operation.getOperator().equals("exp"))
      solution = calculatorImp.exp(operation.getOperand1());

    // call corresponding function to get sinh value
    else if (operation.getOperator().equals("sinh"))
      solution = calculatorImp.sinh(operation.getOperand1());

    // call corresponding function to get complex value
    else if (operation.getOperator().equals("complex")) {
      if (operation.getOperand3() == null) {
        map.put("error", "type question for complex");
        return "advance";
      }
      solution = calculatorImp.complex(operation.getOperand3());
    }

    // call corresponding function to get pow
    else if (operation.getOperator().equals("pow")) {
      // ---------- Further Validation Check for function pow ---------
      if (operation.getOperand2() == null) {
        map.put("error", "miss parameter");
        return "advance";
      }
      // if base is a negative, the exponent must be a integer
      double change = Math.round(operation.getOperand2());
      if (operation.getOperand1() < 0 && change != operation.getOperand2()) {
        map.put("error", "x<0, y needs integer");
        return "advance";
      }
      solution = calculatorImp.pow(operation.getOperand1(), operation.getOperand2());
    }
    // get add
    else if (operation.getOperator().equals("+")) {
      // ---------- Further Validation Check for function add ---------
      if (operation.getOperand2() == null) {
        map.put("error", "miss parameter");
        return "advance";
      }
      solution = calculatorImp.add(operation.getOperand1(), operation.getOperand2());
    }
    // get sub
    else if (operation.getOperator().equals("-")) {
      // ---------- Further Validation Check for function sub---------
      if (operation.getOperand2() == null) {
        map.put("error", "need 2 parameters");
        return "advance";
      }
      solution = calculatorImp.sub(operation.getOperand1(), operation.getOperand2());
    }
    // get mul
    else if (operation.getOperator().equals("*")) {
      // ---------- Further Validation Check for function mul ---------
      if (operation.getOperand2() == null) {
        map.put("error", "need 2 parameters");
        return "advance";
      }
      solution = calculatorImp.mul(operation.getOperand1(), operation.getOperand2());
    }
    // get div
    else if (operation.getOperator().equals("/")) {
      // ---------- Further Validation Check for function div ---------
      if (operation.getOperand2() == null) {
        map.put("error", "need 2 parameters");
        return "advance";
      }
      if (operation.getOperand2() == 0) {
        map.put("error", "divisor can't be 0");
        return "advance";
      }
      solution = calculatorImp.div(operation.getOperand1(), operation.getOperand2());
    } else { // double check if we can handle the operation
      map.put("error", "input error");
      return "advance";
    }
    // -------Pass result to value and display on web page---------
    double res = calculatorImp.round(solution); // remove no meaning 0s

    if (calculatorImp.isFakeDouble(res)) {
      int resInt = (int) res;
      map.put("value", resInt);
      return "advance";
    }
    map.put("value", res);
    return "advance";
  }
}
