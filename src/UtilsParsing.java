import java.io.IOException;

public class UtilsParsing {
    private static boolean StringUtils;

    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }

    public static Variable parseVariable(String line, boolean isFirst) throws Exception {
        try{
            if (isFirst){
                if(UtilsParsing.count(line, "\"") < 2) throw new IOException("Invalid expression");
                String[] tokens = line.split("");
                if (tokens.length < 13){
                    return new Variable(TypeVariable.STRING, line);
                }
                throw new IOException("Invalid variable");
            }
            int number = Integer.parseInt(line);
            if (number < 10 && number > 0){
                return new Variable(TypeVariable.INT, line);
            }
            throw new IOException("Invalid variable");

        } catch (NumberFormatException e){
            String[] tokens = line.replace("\"", "" ).split("");
            if (tokens.length < 11){
                return new Variable(TypeVariable.STRING, line);
            }
           throw new IOException("Invalid variable");
        }
    }
}
