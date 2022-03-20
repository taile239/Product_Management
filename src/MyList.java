/**
 * Generic version of the LinkedList class.
 *
 * @param <T> the type of the value
 */
public class MyList<T> {
    /**
     * Head node, default is null
     */
    Node<T> head;


    /**
     * Tail node, default is null
     */
    Node<T> tail;


    /**
     * Default constructor
     */
    public MyList() {
        head = tail = null;
    }


    /**
     * Constructor with head and tail
     *
     * @param head Head node of this list
     * @param tail Tail node of this list
     */
    public MyList(Node<T> head, Node<T> tail) {
        this.head = head;
        this.tail = tail;
    }


    /**
     * Checking if this list is empty
     *
     * @return true if list is empty
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * Insert an item to the head of this list
     *
     * @param item The item to be inserted
     */
    public void insertToHead(T item) {
        Node<T> newNode = new Node<>(item);
        if(newNode == null) {
            System.out.println("Heap overflow");
            return;
        }
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * Insert an item to the tail of this list
     *
     * @param item The item to be inserted
     */
    public void insertToTail(T item) {
        Node<T> newNode = new Node<>(item);
        if(newNode == null) {
            OperationToProduct.writeLine("Heap overflow");
            return;
        }
        if(head == null) {
            head = tail = newNode;
        } else {
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
        }
    }

    /**
     * Deleting all items in the list
     */
    public void clear() {
        head = null;
    }

}
