import java.util.HashMap;
import java.util.Map;

public class Lc359 {
    class Logger {
        Map<String, Integer> msgTimeMap;
        public Logger() {
            msgTimeMap = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!msgTimeMap.containsKey(message)) {
                msgTimeMap.put(message, timestamp);
                return true;
            }
            boolean shouldPrint = timestamp - msgTimeMap.get(message) >= 10;
            if (shouldPrint) {
                msgTimeMap.put(message, timestamp);
            }
            return shouldPrint;
        }
    }
}
