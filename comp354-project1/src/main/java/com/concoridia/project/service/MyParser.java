package com.concoridia.project.service;

import java.util.*;

public class MyParser {

  private static HashSet<Character> basic_operators =
      new HashSet<Character>(Arrays.asList('+', '-', '*', '/', '^'));
  private static HashSet<Character> operands =
      new HashSet<Character>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'));
  private static HashSet<Character> alphabets =
      new HashSet<Character>(
          Arrays.asList(
              'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
              'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));

  // Tree inner class
  private class Tree {
    private String content;
    private Tree left, right;

    private Tree(String content) {
      this.content = content;
      left = null;
      right = null;
    }

    private void setContent(String content) {
      this.content = content;
    }
  }

  // Method to traverse tree in order
  public static void printInorder(Tree root) {
    if (root == null) return;

    printInorder(root.left);

    System.out.println(root.content);

    printInorder(root.right);
  }

  // Method to create a parse tree from string
  public static Tree createParseTree(String str) {

    char[] strArr = str.replaceAll("\\s", "").toCharArray();
    Tree parseTree = new MyParser().new Tree(null);
    Stack<Tree> treeStack = new Stack<Tree>();

    // creating parse tree
    for (int i = 0; i < strArr.length; i++) {

      // when parsing an operand (numerical)
      if (operands.contains(strArr[i])) {
        String numericalToken = "";
        while (operands.contains(strArr[i])) {
          numericalToken += strArr[i];
          i++;
        }
        i--;
        parseTree.setContent(numericalToken);
        parseTree = treeStack.pop();
      } else if (strArr[i] == '(') {
        parseTree.left = new MyParser().new Tree(null);
        treeStack.push(parseTree);
        parseTree = parseTree.left;
      }

      // when parsing basic operators
      else if (basic_operators.contains(strArr[i])) {
        parseTree.setContent(Character.toString(strArr[i]));
        parseTree.right = new MyParser().new Tree(null);
        treeStack.push(parseTree);
        parseTree = parseTree.right;
      } else if (strArr[i] == ')') {
        if (!treeStack.isEmpty()) {
          parseTree = treeStack.pop();
        }
      }

      // when parsing other operators
      else {
        String operatorToken = "";
        while (!basic_operators.contains(strArr[i]) && strArr[i] != '(' && strArr[i] != ')') {
          operatorToken += strArr[i];
          i++;
        }
        i--;
        parseTree.setContent(operatorToken);
        parseTree = treeStack.pop();
      }
    }

    return parseTree;
  }

  // Helper method to turn specific strings into values
  private static double stringToDouble(String str) {

    // when str is a transcendental function (ex. sin3.2)
    if (str.contains("expt")) {
      return Math.pow(10, Double.parseDouble(str.substring(4)));
    } else if (str.contains("sinh")) {
      return Math.sinh(Double.parseDouble(str.substring(4)));
    } else if (str.contains("sin")) {
      return Math.sin(Double.parseDouble(str.substring(3)));
    } else if (str.contains("log")) {
      return Math.log(Double.parseDouble(str.substring(3)));
    } else if (str.contains("exp")) {
      return Math.exp(Double.parseDouble(str.substring(3)));
    }
    // when str is simply a number
    else {
      return Double.parseDouble(str);
    }
  }

  // Method to evaluate a parse tree
  public static double evaluateParseTree(Tree root) {

    if (root.left == null && root.right == null) return stringToDouble(root.content);

    String operator = root.content;

    switch (operator) {
      case "+":
        return evaluateParseTree(root.left) + evaluateParseTree(root.right);
      case "-":
        return evaluateParseTree(root.left) - evaluateParseTree(root.right);
      case "*":
        return evaluateParseTree(root.left) * evaluateParseTree(root.right);
      case "/":
        return evaluateParseTree(root.left) / evaluateParseTree(root.right);
      case "^":
        return Math.pow(evaluateParseTree(root.left), evaluateParseTree(root.right));
    }

    System.out.println("Error");
    return -1;
  }
  // Complex operation
  public static double complexCalculation(String x) {
    Tree parseTree = createParseTree(x);
    // printInorder(parseTree);
    return evaluateParseTree(parseTree);
  }

  // main method
  public static void main(String args[]) throws invalidExpressionException {

    // ---------Our test under test package,please go there to check out---------

  }
}
