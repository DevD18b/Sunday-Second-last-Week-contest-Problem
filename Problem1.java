public class Problem1 {
    public static int minimumSumTriplet(int[] arr) {

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; j < arr.length; j++) {
                    if (arr[i] < arr[j] && arr[j] > arr[k]) {
                        int sum = arr[i] + arr[j] + arr[k];
                        minSum = Math.min(minSum, sum);
                    }
                }
            }
        }
        return minSum;
    }
}