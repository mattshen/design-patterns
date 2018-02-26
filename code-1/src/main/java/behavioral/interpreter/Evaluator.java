package behavioral.interpreter;

import java.util.Map;
import java.util.Stack;

public class Evaluator implements Expression {
    private Expression syntaxTree;

    public Evaluator(final String expression)
    {
        final Stack<Expression> expressionsStack = new Stack<>();
        for (final String token : expression.split(" ")) {
            if (token.equals("+")) {
                final Expression subExpr = new Plus(expressionsStack.pop(), expressionsStack.pop());
                expressionsStack.push(subExpr);
            } else if (token.equals("-")) {
                final Expression right = expressionsStack.pop();
                final Expression left = expressionsStack.pop();
                final Expression subExpr = new Minus(left, right);
                expressionsStack.push(subExpr);
            } else {
                expressionsStack.push(new Variable(token));
            }

        }
        this.syntaxTree = expressionsStack.pop();
    }

    @Override
    public int interpret(Map<String, Expression> context)
    {
        return syntaxTree.interpret(context);
    }
}
