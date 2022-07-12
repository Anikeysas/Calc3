import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // Задача: программа "Строковый калькулятор"
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (!HelpersExpression.isValidException(line)) throw new IOException("Invalid expression");
        List<String> tokens = HelpersExpression.parserExression(line);
        String[] variables = line.split(String.format("\\%s", tokens.get(1)));
        Mark mark = HelpersExpression.getMark(tokens.get(1));
        Variable var1 = UtilsParsing.parseVariable(variables[0].trim(), true);
        Variable var2 = UtilsParsing.parseVariable(variables[1].trim(), false);
        var1.setValue(var1.getValue().replace("\"", ""));
        var2.setValue(var2.getValue().replace("\"", ""));
        Expression expression = new Expression(var1, var2, mark);
        expression.getResult();
    }
}