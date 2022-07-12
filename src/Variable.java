public class Variable {
    private String value = "";
    private int type = 0;

    public Variable(int type, String value) {
        this.type = type;
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public int getType() {
        return type;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
