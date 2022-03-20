/**
 * Generic version of the Queue class.
 *
 * @param <T> the type of the value
 */
public class MyQueue<T> {
    /**
     * Head node contains front node in the queue
     */
    Node<T> head;


    /**
     * Tail node contains last node in the queue
     */
    Node<T> tail;

    public MyQueue () {
        head = tail = null;
    }

    /**
     * Adds new item to the tail of queue
     * @param item: item to be added
     */
    public void enqueue(T item) {
        Node<T> newNode = new Node<>(item);
        if(newNode == null) {
            OperationToProduct.writeLine("Heap overflow");

            return;
        }
        if(head == null) {
            head = tail = newNode;
        }
        tail.next = newNode;
        tail = newNode;
    }

    /**
     * Clear the queue
     */
    public void clear() {
        head = tail = null;
    }
}
