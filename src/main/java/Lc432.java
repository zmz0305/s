//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
//public class Lc432 {
//    Map<Integer, BucketNode> countBucketMap = new HashMap<>();
//    Map<String, Integer> valueCountMap = new HashMap<>();
//    class BucketNode {
//        Set<String> valueSet;
//        int count;
//        BucketNode prev;
//        BucketNode next;
//        public BucketNode() {
//            valueSet = new HashSet<>();
//            count = 1;
//        }
//        public void addValue(String value) {
//            valueSet.add(value);
//        }
//        public void removeValue(String value) {
//            valueSet.remove(value);
//        }
//    }
//    BucketNode head;
//    BucketNode tail;
//    public Lc432() {
//        head = new BucketNode();
//        tail = new BucketNode();
//        head.next = tail;
//        tail.prev= head;
//    }
//
//    public void inc(String key) {
//    }
//
//    public void dec(String key) {
//
//    }
//
//    public String getMaxKey() {
//
//    }
//
//    public String getMinKey() {
//
//    }
//}
