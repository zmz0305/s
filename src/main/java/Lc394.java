public class Lc394 {
    int index = 0;

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') {
            if (!Character.isDigit(s.charAt(index))) {
                sb.append(s.charAt(index));
            } else {
                int endOfNum = index;
                while (Character.isDigit(s.charAt(endOfNum))) {
                    endOfNum++;
                }
                int k = Integer.parseInt(s.substring(index, endOfNum));
                index = endOfNum+1;
                String insideStr = decodeString(s);
                index++;
                for (int i = 0; i < k; i++) {
                    sb.append(insideStr);
                }
            }
        }
        return sb.toString();
    }
}
