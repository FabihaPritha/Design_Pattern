//......Interpreter Pattern......
//Define a grammar and interpret expressions based on that grammar.

//🔧 Use Case:
//Simple languages (e.g. SQL, regex, arithmetic evaluators)
//Scripting inside apps

//Real Life Example:
//Like a language interpreter translating "2 + 3" into 5.


package patterns.Behavioral_Design_Pattern;

//Every expression must define how to interpret() itself.
interface Expression {
    int interpret();
}

class Number implements Expression {
    int value;
    Number(int value) {
        this.value = value;
    }

    public int interpret() {
        return value;
    }
}

class Add implements Expression {
    Expression left, right;
    Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

public class InterpreterPattern {
    public static void main(String[] args) {
        Expression result = new Add(new Number(2), new Number(3));
        System.out.println(result.interpret()); // Output: 5
    }
}

