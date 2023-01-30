package com.gl.dsa.question1;

import java.util.Stack;

public class BalancingBracket {

	public static void main(String[] args) {
		String bracketExpression = "[{(a+b)*(c+d)} - {(a+b)*(c+d)}]";
		boolean result;
		result = checkingBalancingBracket(bracketExpression);
		if (result)
			System.out.println("The entered String has balanced bracket...");
		else
			System.out.println("The entered String has not contained balanced bracket.....");

	}

	private static boolean checkingBalancingBracket(String bracketExpression) {

		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < bracketExpression.length(); i++) {
			char character = bracketExpression.charAt(i);
			if (character == '(' || character == '{' || character == '[') {
				stack.push(character);
			} else if (character == ')' || character == '}' || character == ']') {
				if (stack.isEmpty())
					return false;
				stack.pop();
			}
		}
		return stack.isEmpty() ? true : false;
	}
}
