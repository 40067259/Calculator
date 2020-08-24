package com.concoridia.project.entities;

/**
 * @author Fred Zhang
 * @create 2020-05-11 11:15 AM
 */
// This is a entity class
// It is a model which frontend data can be encapsulated as
public class Operation {
  private String operator;
  private Double operand1;
  private Double operand2;
  private String operand3;

  public Operation() {}

  public String getOperand3() {
    return operand3;
  }

  public void setOperand3(String operand3) {
    this.operand3 = operand3;
  }

  public String getOperator() {
    return operator;
  }

  public void setOperator(String operator) {
    this.operator = operator;
  }

  public Double getOperand1() {
    return operand1;
  }

  public void setOperand1(Double operand1) {
    this.operand1 = operand1;
  }

  public Double getOperand2() {
    return operand2;
  }

  public void setOperand2(Double operand2) {
    this.operand2 = operand2;
  }

  @Override
  public String toString() {
    return "Operation{"
        + "operator='"
        + operator
        + '\''
        + ", operand1="
        + operand1
        + ", operand2="
        + operand2
        + ", operand3="
        + operand3
        + '}';
  }
}
