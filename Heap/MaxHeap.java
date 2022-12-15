import java.util.List;

public class MaxHeap {
    private int[] items;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.items = new int[capacity];
    }

    public void insert(int value){
        if(isFull()){
            System.out.println("Heap Overflow");
            return;
        }
        items[size++] = value;
        bubbleUp();
    }

    public int remove(){
        if(isEmpty()){
            System.out.println("Heap Underflow");
            return -1;
        }
        var item = items[0];
        items[0] = items[--size];
        bubbleDown();
        return item;
    }

    public boolean isFull(){
        return size == capacity;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int max(){
        if(isEmpty()) throw new IllegalArgumentException();
        return items[0];
    }
    public void clear(){
        size = 0;
    }
    private void swap(int first,int second){
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }
    private void bubbleUp(){
        int index = size - 1;
        while (index>0 && items[index] > items[parent(index)]){
            swap(index,parent(index));
            index = parent(index);
        }
    }
    private void bubbleDown(){
        int index = 0;
        while (index<=size && !isValidindex(index)){
            int largestChild = largestChild(index);
            swap(index,largestChild);
            index = largestChild;
        }
    }
    private boolean isValidindex(int index){
        if(leftChild(index) > size) return true;
        if(rightChild(index) > size) return items[index] >= items[leftChild(index)];

        return items[index] >= items[leftChild(index)] && items[index] >= items[rightChild(index)];
    }
    private int parent(int index){
        return (index - 1)/2;
    }
    private int leftChild(int index){
        return (index*2) + 1;
    }
    private int rightChild(int index){
        return (index*2) + 2;
    }
    private int largestChild(int index){
        if(leftChild(index) > size) return index;
        if(rightChild(index) > size) return leftChild(index);

        return (items[leftChild(index)] > items[rightChild(index)]) ? leftChild(index) : rightChild(index);
    }
}
