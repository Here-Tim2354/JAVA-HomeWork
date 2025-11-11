package Experiment.Experiment5.task2.util;



public class ArrayQueue<T> {
    private Object[] elements;
    private int front;
    private int rear;
    private int capacity;

    public ArrayQueue(){
        this(16);
    }

    public ArrayQueue(int capacity) {
        if(capacity<1){
            throw new IllegalArgumentException("容量必须大于0");
        }
        this.capacity = capacity;
        elements = new Object[capacity];
        front = 0;
        rear = -1;
    }

    public boolean isEmpty(){
        return front > rear;
    }

    public boolean isFull(){
        return rear - front + 1 == capacity;
    }

    public void add(T element){
        if (isFull()) {
            throw new IllegalArgumentException("队列已满，无法添加元素");
        }
        elements[++rear] = element;
    }

    public T remove(){
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空，无法移除元素");
        }
        @SuppressWarnings("unchecked")
        T element = (T) elements[front];
        elements[front++] = null;
        return element;
    }




}
