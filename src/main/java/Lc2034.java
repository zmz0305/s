import java.util.HashMap;
import java.util.TreeMap;

public class Lc2034 {
    class StockPrice {
        TreeMap<Integer, Integer> timePriceMap = new TreeMap<>();
        TreeMap<Integer, Integer>  priceCountsMap = new TreeMap<>();

        public StockPrice() {

        }

        public void update(int timestamp, int price) {
            if (timePriceMap.containsKey(timestamp)) {
                priceCountsMap.put(price, priceCountsMap.getOrDefault(price, 0) + 1);
                int oldPrice = timePriceMap.get(timestamp);
                priceCountsMap.put(oldPrice, priceCountsMap.get(oldPrice) - 1);
                if (priceCountsMap.get(oldPrice) == 0) {
                    priceCountsMap.remove(oldPrice);
                }
                timePriceMap.put(timestamp, price);
            } else {
                priceCountsMap.put(price, priceCountsMap.getOrDefault(price, 0) + 1);
                timePriceMap.put(timestamp, price);
            }
        }

        public int current() {
            return timePriceMap.lastEntry().getValue();
        }

        public int maximum() {
            return priceCountsMap.lastKey();
        }

        public int minimum() {
            return priceCountsMap.firstKey();
        }
    }
}
