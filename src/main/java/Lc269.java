import java.util.*;

public class Lc269 {
    Map<Character, Integer> inDegrees = new HashMap<>();
    Map<Character, List<Character>> adjList = new HashMap<>();

    public String alienOrder(String[] words) {
        for (String word : words) {
            char[] curCharArr = word.toCharArray();
            for (char c : curCharArr) {
                inDegrees.putIfAbsent(c, 0);
                adjList.putIfAbsent(c, new ArrayList<>());
            }
        }

        for (int i = 1; i < words.length; i++) {
            char[] w1 = words[i - 1].toCharArray();
            char[] w2 = words[i].toCharArray();
            int w1Idx = 0;
            int w2Idx = 0;
            while (w1Idx < w1.length && w2Idx < w2.length) {
                if (w1[w1Idx] != w2[w2Idx]) {
                    adjList.get(w1[w1Idx]).add(w2[w2Idx]);
                    inDegrees.put(w2[w2Idx], inDegrees.get(w2[w2Idx]) + 1);
                    break;
                }
                w1Idx++;
                w2Idx++;
            }
            if ((w1Idx >= w1.length || w2Idx >= w2.length) && w1.length > w2.length) {
                return "";
            }
        }
        LinkedList<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> inDegree: inDegrees.entrySet()) {
            if (inDegree.getValue().equals(0)) {
                queue.addLast(inDegree.getKey());
            }
        }
        StringBuilder resSb = new StringBuilder();
        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                char curChar = queue.pollFirst();
                resSb.append(curChar);
                for (Character nb : adjList.get(curChar)) {
                    inDegrees.put(nb, inDegrees.get(nb) - 1);
                    if (inDegrees.get(nb).equals(0)) {
                        queue.addLast(nb);
                    }
                }
            }
        }
        return resSb.toString();
    }
}
