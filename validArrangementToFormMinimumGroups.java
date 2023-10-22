import java.util.*;

public class validArrangementToFormMinimumGroups {
    public static int driverSolution(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxFreq = Integer.MIN_VALUE;
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            maxFreq = Math.min(maxFreq, map.get(i));
        }

        for (int size = maxFreq; size >= 1; size--) {
            if (isPossibleToEvenlyDistribute(size, map)) {
                int result = 0;
                for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                    int count = m.getValue();
                    int group = count / size;
                    int remain = count % size;
                    if (remain == 0) {
                        remain += group;
                    } else if (remain > 0) {
                        result++;
                    }
                }
                return result;
            }
        }
        return arr.length;
    }

    public static boolean isPossibleToEvenlyDistribute(int size, HashMap<Integer, Integer> m) {

        for (Map.Entry<Integer, Integer> map : m.entrySet()) {
            // int currentElement = map.getKey();
            int freq = map.getValue();

            int possibleGroup = freq / size;
            int extraElement = freq % size;

            if (extraElement < size - 1) {
                int req = (size - 1) - extraElement;
                if (possibleGroup >= req) {
                    extraElement = size - 1;
                }
            }
            if (extraElement > 0 && extraElement < size - 1) {
                return false;
            }
        }
        return true;
    }
}