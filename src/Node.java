/**
 * Generic version of the Node class.
 *
 * @param <T> the type of the value
 */
public class Node<T> {
    T info;
    /**
     * The next node
     */
    Node<T> next;

    /**
     * Default constructor
     */
    public Node() {}

    /**
     * Constructor with info and next node
     *
     * @param info The info of this node
     * @param next The next Node of this node
     */
    public Node(T info, Node<T> next) {
        this.info = info;
        this.next = next;
    }

    public Node(T info) {
        this.info = info;
    }
}
