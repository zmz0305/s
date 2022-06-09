import java.util.TreeMap;

public class Lc1146 {
    class SnapshotArray {
        int snapId = 0;
        TreeMap<Integer, Integer>[] dataMap;
        public SnapshotArray(int length) {
            dataMap = new TreeMap[length];
            for (int i = 0; i < length; i++) {
                dataMap[i] = new TreeMap<>();
                dataMap[i].put(0, 0);
            }
        }

        public void set(int index, int val) {
            dataMap[index].put(snapId, val);
        }

        public int snap() {
            return snapId++;
        }

        public int get(int index, int snap_id) {
            return dataMap[index].floorEntry(snap_id).getValue();
        }
    }
}
