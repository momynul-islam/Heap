public class PriorityQueue {
    private MaxHeap heap;
    public PriorityQueue(int capacity){
        heap = new MaxHeap(capacity);
    }

    public void enqueue(int value){
        heap.insert(value);
    }
    public void dequeue(){
        heap.remove();
    }
    public boolean isEmpty(){
        return heap.isEmpty();
    }
    public boolean isFull(){
        return heap.isFull();
    }
}
