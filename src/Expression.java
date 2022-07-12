import java.io.IOException;

public class Expression {
    private Variable variableOne = null;
    private Variable variableTwo = null;
    private Mark operator = null;
    public Expression(Variable variableOne, Variable variableTwo, Mark operator) {
        this.variableOne = variableOne;
        this.variableTwo = variableTwo;
        this.operator = operator;
    }
    public Variable getVariableOne() {
        return variableOne;
    }
    public Variable getVariableTwo() {
        return variableTwo;
    }
    public Mark getOperator() {
        return operator;
    }
    public void getResult() throws Exception {
        if (variableOne.getType() == TypeVariable.STRING && variableTwo.getType() == TypeVariable.STRING) {
            if (this.operator == Mark.PLUS){
                System.out.println(variableOne.getValue().concat(variableTwo.getValue()));
            } else if(this.operator == Mark.MINUS){
                System.out.println(variableOne.getValue().replace(variableTwo.getValue(), ""));
            }
        } else if(variableOne.getType() == TypeVariable.STRING && variableTwo.getType() == TypeVariable.INT){
            if (this.operator == Mark.DIVIDE){
                int lengthOne = variableOne.getValue().length();
                int lengthTwo = Integer.parseInt(variableTwo.getValue());
                int del = lengthOne / lengthTwo;
                if (del == 0){
                    throw new Exception("Invalid expression");
                }
                System.out.println(variableOne.getValue().substring(0, del));
            } else if (this.operator == Mark.MULTIPLY){
                String result = variableOne.getValue().repeat(Integer.parseInt(variableTwo.getValue()));
                if (result.length() > 40) {
                    System.out.println(result.substring(0, 40) + "...");
                }else {
                    System.out.println(result);
                }

            }
        }
        else {
            System.out.println("ERROR");
            throw new IOException("Invalid expression");
        }
    }

}
