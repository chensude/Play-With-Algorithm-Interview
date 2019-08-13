public class BinarySearch<T> {

    /**
     * 从【l...r】区间中二分搜索target，返回当前数组索引
     *
     * @param arr
     * @param n
     * @param target
     * @return
     */

    public static <T extends Comparable<T>> int binarySearch(T[] arr, int n, T target) {

        //从【l...r】区间中二分搜索target
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (arr[mid].compareTo(target) == 0) {
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                //target在右边，更新l的值
                l = mid + 1;
            } else {
                //左边
                r = mid - 1;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int n = (int) Math.pow(10, 7);
        Integer data[] = Util.generateOrderedArray(n);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i++)
            if (i != binarySearch(data, n, i))
                throw new IllegalStateException("find i failed!");
        long endTime = System.currentTimeMillis();


        System.out.println("Binary Search test complete");
        System.out.println("Time cost:" + (endTime - startTime + " ms"));
    }
}