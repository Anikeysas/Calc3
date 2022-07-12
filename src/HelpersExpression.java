import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HelpersExpression {

    public static List<String> parserExression(String line) {
        List<String> matchList = new ArrayList<String>();
        Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
        Matcher regexMatcher = regex.matcher(line);
        while (regexMatcher.find()) {
            if (regexMatcher.group(1) != null) {
                matchList.add(regexMatcher.group(1));
            } else if (regexMatcher.group(2) != null) {
                matchList.add(regexMatcher.group(2));
            } else {
                matchList.add(regexMatcher.group());
            }
        }
        return matchList;
    }
    public static List<String> parserVariable(String line) {
        List<String> matchList = new ArrayList<String>();
        Pattern regex = Pattern.compile("/[,.\\s]/");
        Matcher regexMatcher = regex.matcher(line);
        while (regexMatcher.find()) {
            if (regexMatcher.group(1) != null) {
                matchList.add(regexMatcher.group(1));
            } else if (regexMatcher.group(2) != null) {
                matchList.add(regexMatcher.group(2));
            } else {
                matchList.add(regexMatcher.group());
            }
        }
        return matchList;
    }
    public static boolean isValidException(String line) {
        int count = UtilsParsing.count(line, "\"");
        List<String> matchList = HelpersExpression.parserExression(line);
        return (matchList.size() == 3 || matchList.size() == 1) && (count == 2 || count == 4);
    }
    public static Mark getMark(String token) {
        if (token.equals("+")) return Mark.PLUS;
        if (token.equals("-")) return Mark.MINUS;
        if (token.equals("*")) return Mark.MULTIPLY;
        if (token.equals("/")) return Mark.DIVIDE;
        throw new IllegalArgumentException("Invalid mark");
    }

}
