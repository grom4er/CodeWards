package CodeWars;

public class SimpleStringReversal {
    public static String solve(String s) {
        String tempValue = s;
        s = s.replaceAll(" ", "");
        StringBuffer changeValue = new StringBuffer(s);
        changeValue.reverse();
        s = changeValue.toString();
        for (int i = 0; i < s.length(); i++) {
            if (tempValue.charAt(i) == ' ') {
                s = s.substring(0, i) + " " + s.substring(i);
            }
        }

        return s;
    }
}