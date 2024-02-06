import java.util.Arrays;

public class MyHeap {
    private int size;
    private int capacity = 10;

    int[] items = new int[capacity];

    private int getLeftChildIndex (int index){ return index * 2 + 1; }

    private int getRightChildIndex (int index){ return index * 2 + 2; }

    private int getParentIndex (int index){ return (index-1)/2; }

    private boolean hasLeftChild (int index){ return getLeftChildIndex(index) < size; }

    private boolean hasRightChild (int index){ return getRightChildIndex(index) < size; }

    private boolean hasParent (int index){ return getParentIndex(index) >= 0; }
//        return index > 0;

    private int leftChild(int index){ return items[getLeftChildIndex(index)]; }

    private int rightChild(int index){ return items[getRightChildIndex(index)]; }

    private int parent(int index){ return items[getParentIndex(index)]; }

    private void swap(int indexLeft, int indexRight){
        int temp = items[indexLeft];
        items[indexRight] = items[indexLeft];
        items[indexLeft] = temp;
    }

    private void enoughSpace(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity*2);
            capacity *= 2;
        }
    }

    public int peek(){
        if (size == 0){
            throw new IllegalStateException();
        }
        return items[0];
    }

    public void add(int newValue){
        enoughSpace();
        items[size] = newValue;
        size++;
        heapifyUp();
    }

    public void heapifyUp(){
        int index = size-1;
        while (hasParent(index) && parent(index) < items[index]){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public int poll(){
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        heapifyDown();
        return item;
    }

    private void heapifyDown(){
        int index = 0;
        while(hasLeftChild(index)){
            int greaterChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) > leftChild(index)){
                greaterChildIndex = getRightChildIndex(index);
            }
            if(items[index] > items[greaterChildIndex]){
                break;
            }else{
                swap(index, greaterChildIndex);
            }
            index = greaterChildIndex;
        }
    }

    public static void main(String[] args){
        MyHeap myHeap = new MyHeap();

        myHeap.add(16);
        myHeap.add(9);
        myHeap.add(14);
        myHeap.add(8);
        myHeap.add(7);
        myHeap.add(10);
        myHeap.add(3);
        myHeap.add(2);
        myHeap.add(4);
        myHeap.add(1);
        myHeap.add(6);
    }
}
