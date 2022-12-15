import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = { 10, 5, 3, 20, 1 };
        var heap = new MaxHeap(arr.length);

        for(var item: arr) heap.insert(item);
        for(int i=arr.length-1; i>=0; i--) arr[i] = heap.remove();

        System.out.println(Arrays.toString(arr));
    }
}
