package Trees.L29;

public class MinHeap {
    private int capacity;
    private int size;
    private int[] heap;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void minHeapify(int index) {
        int smallest = index;
        int l = leftChild(index);
        int r = rightChild(index);

        if (l < this.size && this.heap[l] < this.heap[smallest]) {
            smallest = l;
        }
        if (r < this.size && this.heap[r] < this.heap[smallest]) {
            smallest = r;
        }
        if (smallest != index) {
            swap(index, smallest);
            minHeapify(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }

    public void push(int key) {
        if (this.size == this.capacity) {
            System.out.println("Heap is full");
            return;
        }
        this.size++;
        int index = this.size - 1;
        this.heap[index] = key;

        while (index != 0 && this.heap[index] < this.heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    public int top() {
        if (this.size == 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        return this.heap[0];
    }

    public void pop() {
        if (this.size == 0) {
            System.out.println("Heap is empty");
            return;
        }
        if (this.size == 1) {
            this.size--;
            return;
        }
        this.heap[0] = this.heap[this.size - 1];
        this.size--;
        minHeapify(0);
    }

    public static void main(String[] args) {
        MinHeap heap = new MinHeap(10);
        heap.push(3);
        heap.push(1);
        heap.push(6);
        heap.push(5);
        heap.push(2);
        heap.push(4);

        System.out.println("Top of heap: " + heap.top());
        heap.pop();
        System.out.println("Top of heap after pop: " + heap.top());
    }
}

