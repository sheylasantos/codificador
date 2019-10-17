

import java.util.Arrays;

public class Heap {
    private Node[] nodes;
    private int size;//quantos elementos tem
    private int capacity;//quantos elementos cabem

    public Heap() {
        this(10);
    }

    public Heap(int capacity) {
        nodes = new Node[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public Node[] getNodes(){
        return nodes;
    }


    public void insert(Node node) {
        ensureCapacity();
        nodes[getSize()] = node;
        heapifyUp(getSize());
        size++;

    }

//    public void orderAscHeap(Node[] array){
//            for (int i=0;i<getSize()/2;++i){
//               heapifyDown(i);
//            }
//        //int[] retorno = new int[getSize()];
//
//        while (getSize()>0){
//            rootToEnd();
//        }
//    }
//    public void rootToEnd() {
//        Node root = nodes[0];
//        nodes[0]=nodes[getSize()-1];
//        nodes[getSize()-1]=root;
//        heapifyDown(0);
//        size--;
//        //heapifyDown(0);
//    }

    private void heapifyUp(int index) {
        if (!hasParent(index)){
            return;
        }

        int parentIndex = getParentIndex(index);

        if (parentIndex < 0) {
            return;
        }

        Node pai    = nodes[parentIndex];
        Node node = nodes[index];

        if (node.getValue() < pai.getValue()) {
            nodes[index]   = pai;
            nodes[parentIndex] = node;
            heapifyUp(parentIndex);
        }
        //heapifyDown(index);

    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0 && getParentIndex(index) < size;
    }


    public int getParentIndex(int index) {
        return (int) Math.floor((index - 1) / 2);
    }

    private void ensureCapacity() {
        if (size == capacity) {
            nodes = Arrays.copyOf(nodes, capacity * 2);
            capacity = capacity * 2;
        }
    }

    public int getSize() {
        return size;
    }

    public Node peek() {
        if (getSize() == 0) {
            return null;
        }
        return nodes[0];
    }

    public void remove() {
        nodes[0] = nodes[getSize() - 1];
        nodes[getSize() - 1] = null;
        size--;
        heapifyDown(0);
    }

    private void heapifyDown(int index) {
        int leftChild = index * 2 + 1;
        int rightChild = index * 2 + 2;

        int childIndex = -1;
        if (leftChild < getSize()) {
            childIndex = leftChild;
        }

        if (childIndex == -1) {
            return;
        }

        if (rightChild < getSize()) {
            if (nodes[rightChild].getValue() < nodes[leftChild].getValue()) {
                childIndex = rightChild;
            }
        }

        if (nodes[index].getValue() > nodes[childIndex].getValue()) {
            Node tmp          = nodes[index];
            nodes[index]      = nodes[childIndex];
            nodes[childIndex] = tmp;
            heapifyDown(childIndex);
        }
    }
}


















































