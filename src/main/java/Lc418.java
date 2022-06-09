public class Lc418 {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] nextWordIndex = new int[sentence.length];
        int[] count = new int[sentence.length];
        for (int i = 0; i < sentence.length; i++) {
            int curIndex = i;
            int curLen = 0;
            int curCount = 0;
            while (curLen + sentence[curIndex].length() <= cols) {
                curLen += sentence[curIndex++].length() + 1;
                if (curIndex == sentence.length) {
                    curIndex = 0;
                    curCount++;
                }
            }
            nextWordIndex[i] = curIndex;
            count[i] = curCount;
        }
        int index = 0;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            res += count[index];
            index = nextWordIndex[index];
        }
        return res;
    }

    public static void main(String[] args) {
        String[] s = new String[]{"hello","world"};
        int rows = 20000;
        int cols = 20000;
        Lc418 instance = new Lc418();
        System.out.println(instance.wordsTyping(s, rows, cols));
    }
}
