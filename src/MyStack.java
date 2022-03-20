/**
 * Generic version of the Stack class.
 *
 * @param <T> the type of the value
 */
public class MyStack<T> {
    /**
     * Head node contains front node in the stack
     */
    Node<T> head;

    /**
     * Default constructor
     */
    public MyStack() {
        head = null;
    }

    /**
     * Adds new item to stack
     * @param item: item to be added
     */
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        if(newNode == null) {
            OperationToProduct.writeLine("Heap overflow");
        }
        newNode.next = head;
        head = newNode;
    }

    /**
     * Clear the stack
     */
    public void clear() {
        head = null;
    }
}




