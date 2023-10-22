public class minSumTriplet2 {

    public static int minSumTripletOptimized(int[] arr) {
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        left[0] = arr[0];
        right[0] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.min(left[i - 1], arr[i]);
        }

        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.min(right[i + 1], arr[i]);
        }

        for (int i = 1; i < arr.length; i++) {
            sum = left[i - 1] + arr[i] + right[i + 1];
            minSum = Math.min(sum, minSum);
        }
        return minSum;

    }
}
