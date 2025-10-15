package Experiment.Experiment2.task3;

import java.util.Stack;

public class ArithmeticExpression {
    private final String expr;

    public ArithmeticExpression(String expr) {
        this.expr = expr;
    }

    public int getResult() {
        String[] tokens = expr.split(" ");
        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                values.push(Integer.parseInt(token));
            } else if (token.equals("(")) {
                ops.push('(');
            } else if (token.equals(")")) {
                while (ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop(); // Pop '('
            } else { // Operator
                while (!ops.empty() && hasPrecedence(token.charAt(0), ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(token.charAt(0));
            }
        }

        while (!ops.empty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        return values.pop();
    }

    private boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')') {
            return false;
        }
        return (op1 != '*' && op1 != '/') || (op2 != '+' && op2 != '-');
    }

    private int applyOp(char op, int b, int a) {
        return switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> {
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                yield a / b;
            }
            default -> 0;
        };
    }
}
