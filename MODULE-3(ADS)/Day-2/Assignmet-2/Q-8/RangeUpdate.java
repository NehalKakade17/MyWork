public class RangeUpdate {
    public static void main(String[] args) {
        int n = 5;
        int[][] queries = {{1, 2, 100}, {2, 5, 100}, {3, 4, 100}};
        int[] array = new int[n];
        for (int[] query : queries) {
            applyQuery(array, query[0] - 1, query[1] - 1, query[2]);
        }
        int result = sumArray(array);
        System.out.println(result);
    }
    private static void applyQuery(int[] array, int start, int end, int value) {
        if (start > end) return; 
        array[start] += value;
        applyQuery(array, start + 1, end, value);
    }
    private static int sumArray(int[] array) {
        return sumArrayHelper(array, 0);
    }
    private static int sumArrayHelper(int[] array, int index) {
        if (index >= array.length) return 0; 
        return array[index] + sumArrayHelper(array, index + 1);
    }
}
