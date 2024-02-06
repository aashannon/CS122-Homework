import java.util.Scanner;

public class Calculator {

    double[] calc;
    int pointer;

    /**
     * _Part 1: Implement this constructor_
     *
     * Create a new Calculator with d slots in the stack
     * @param d - number of spaces in the stack
     */
    public Calculator(int d) {
        // Builds a new double Calculator and sets a pointer variable to 0
        calc = new double[d];
        pointer = 0;
    }

    /**
     * _Part 2: Implement this method_
     *
     * Push the specified double onto the stack
     * @param d - the value to push
     * throw an IllegalStateException if the stack has 10 or more values.
     */
    private void push(double d) {
        // Checks first to see if stack is out of bounds the sets pointer index element to d
        //increments pointer by one to the next position on the stack

        if(pointer >= 10){
            throw new IllegalStateException("This stack has 10 or more values");
        }
        calc[pointer] = d;
        pointer++;

    }

    /**
     * _Part 3: Implement this method_
     *
     * Pop the top value off the stack
     * throw an IllegalStateException if the stack is currently empty.
     */
    private double pop() {
        // Checks to see if stack is empty before setting the taken double to the top element on the stack
        // decrements the pointer to the now empty position and returns the double
        double take;

        if (pointer == 0){
            throw new IllegalStateException("This stack is empty");
        }
        take = calc[pointer-1];
        pointer --;

        return take;
    }

    /**
     * _Part 4: Implement this method_
     *
     * Calculate the value from a String of operations.
     *
     * Required operations:
     *  "+" - adds the top two entries on the stack
     *  "*" - multiplies the top two entries on the stack
     *  "-" - subtracts the top entry in the stack from the 2nd entry in the stack
     *  "/" - divides the 2nd entry in the stack by the top entry in the stack
     *  "^" - raises the 2nd entry in the stack to the power indicated by the top entry in the stack
     *  "lg" - takes the lg (log base 2) of the top entry in the stack
     *
     *  Operations for more practice: Variables
     *   expand the use of the calculator by supporting the use of
     *   three variables 'x', 'y', and 'z' in expressions. Specifically
     *   for each variable, there should be a way to set its value 
     *   the tokens 'setx', 'sety', and 'setz' respectively, and a way to 
     *   read its value -- the tokens: 'x', 'y', and 'z' respectively.
     *   With these new operators we should be able to evaluate
     *   expressions such as:
     *   "10 4 + setx" (set the 'x' variable to 14)
     *   "42 x /"      (divide 42 by the value stored for 'x' -- currently 14)
     *   "x x -"       (subtract 14 from 14)
     *
     * @param s - the string representing a mathematic expression
     * throw an IllegalArgumentException if a specified operator is unknown.
     */
    public double calculate(String s) {
        // Reads of the passed String and if it finds a double then in pushes to the stack
        // once an operator is found it checks against switch cases then pops off the doubles
        // from the stack and initiated the calculations and returns the answer after pushing the total back
        // to the stack
        String arithm;
        double x;
        double y;
        double total;
        double answer;
        Scanner search = new Scanner(s);

        while (search.hasNext() == true){
            if (search.hasNextDouble() == true){
                push(search.nextDouble());
            }else{
                arithm = (String) search.next();
                switch (arithm){
                    case "+":
                        y = pop();
                        x = pop();
                        total = x + y;
                        push(total);
                        break;

                    case "-":
                        y = pop();
                        x = pop();
                        total = x - y;
                        push(total);
                        break;

                    case "*":
                        y = pop();
                        x = pop();
                        total = x * y;
                        push(total);
                        break;

                    case "/":
                        y = pop();
                        x = pop();
                        total = x / y;
                        push(total);
                        break;

                    case "^":
                        y = pop();
                        x = pop();
                        total = Math.pow(x, y);
                        push(total);
                        break;

                    case "lg":
                        y = pop();
                        total = Math.log(y) / Math.log(2);
                        push(total);
                        break;

                    default:
                        throw new IllegalArgumentException();



                }
            }

        }
        answer = pop();
        return answer;
    }

    public static void main(String[] args) {
        Calculator c = new Calculator(5);
        System.out.println(c.calculate("10 4 +") + " should equal 14");
        System.out.println(c.calculate("4 2 /") + " should equal 2");
        System.out.println(c.calculate("10 4 + 3 * 2 /") + " should equal 21");
        System.out.println(c.calculate("16 lg") + " should equal 4");
        System.out.println(c.calculate("16 4 -") + " should equal 12");
        System.out.println(c.calculate("5 16 4 + -") + " should equal -15");
        System.out.println(c.calculate("5 20 -") + " should equal -15");
        System.out.println(c.calculate("5") + " should equal 5");

    }
}
