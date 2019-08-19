/**
 * 加入ShiftUp和shiftDown操作
 * 堆排序用数组实现
 * @param <E>
 */
public class MaxHeapII<E extends Comparable> {
    private E[] arr;

    private int size;
    private int capacity;


    public MaxHeapII(int capacity) {
        arr = (E[])new Comparable[capacity+1];
        this.size=0;
        this.capacity=capacity;
    }

    public  E extractMap() {
        assert size+1<=capacity;
        E element =arr[1];
        swap(arr,1,size);
        size--;
        shiftDown(1);
        return element;
    }

    private void shiftDown(int index) {

        while (index*2<=size) {
            int j = 2*index; // 在此轮循环中,data[k]和data[j]交换位置
            if(j+1<=size&& arr[j+1].compareTo(arr[j])>0) {
                j++;
            }
            if(arr[index].compareTo(arr[j])<0) {
                swap(arr,index,j);
            }
            index=j;
        }
    }

    public void add(E e) {

        assert size+1<=capacity;
        arr[size+1]=e;
        size++;
        shitUp(size);
    }

    private void shitUp(int index) {
        while (index>1 &&arr[index].compareTo(arr[index/2])>0) {
            swap(arr,index,index/2);
            index=index/2;
        }
    }
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }


    public static void main(String[] args) {

        MaxHeapII<Integer> maxHeap = new MaxHeapII<Integer>(100);
        int N = 100; // 堆中元素个数
        int M = 100; // 堆中元素取值范围[0, M)
        for( int i = 0 ; i < N ; i ++ )
            maxHeap.add( new Integer((int)(Math.random() * M)) );

        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for( int i = 0 ; i < N ; i ++ ){
            arr[i] = maxHeap.extractMap();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for( int i = 1 ; i < N ; i ++ )
            assert arr[i-1] >= arr[i];
    }

    }
