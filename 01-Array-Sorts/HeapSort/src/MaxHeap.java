
/**
 * 堆的数据结构
 */
public class MaxHeap<E extends Comparable> {

    private E[] arr;

    private int size;
    private int capacity;


    public MaxHeap(int capacity) {
        arr = (E[])new Comparable[capacity+1];
        this.size=0;
        this.capacity=capacity;
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

    public int getSize() {
        return size;
    }
    public Boolean isEmpty() {
        return size==0;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
