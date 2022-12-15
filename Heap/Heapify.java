public class Heapify {
    public static void inPlaceHeapify(int[] arr){
        // for optimize we use lastParentIndex
        var lastParentIndex = (arr.length/2) - 1;
        for(int i=lastParentIndex; i>=0; i--)
            inPlaceHeapify(arr,i);
    }
    private static void inPlaceHeapify(int[] arr,int index){
        int leftChild = (index*2) + 1;
        int rightChild = (index*2) + 2;
        int largerChild = index;

        if(leftChild<arr.length && arr[largerChild]<arr[leftChild]) largerChild = leftChild;
        if(rightChild<arr.length && arr[largerChild]<arr[rightChild]) largerChild = rightChild;

        if(largerChild == index) return;
        swap(arr,index,largerChild);
        inPlaceHeapify(arr,largerChild);
    }
    private static void swap(int[] arr,int first,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    public static int getKthLargest(int[] arr,int k){
        if(k<1 || k>arr.length) throw new IllegalArgumentException();
        var heap = new MaxHeap(arr.length);
        for(var item: arr) heap.insert(item);
        for(int i=0; i<k-1; i++) heap.remove();
        return heap.max();
    }
}
