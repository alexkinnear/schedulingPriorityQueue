
class Node<E extends Comparable<E>> {
    E element;
    int pathToNull;
    Node<E> left;
    Node<E> right;

    public Node(E element) {
        this(element, null, null);
    }

    public Node(E element, Node<E> left, Node<E> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}

public class LeftistHeap<E extends Comparable<E>> {
    private Node root;

    LeftistHeap() {
        root = null;
    }

    public void insert(E node) {
        Node newNode = new Node(node);
        root = merge(newNode, root);
    }

    public E deleteMin() {
        if (root == null) {
            return null;
        }

        E minElement = (E) root.element;
        root = merge(root.left, root.right);
        return minElement;
    }

    private Node merge(Node n1, Node n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        if (n1.element.compareTo(n2.element) < 0) {
            Node temp = n1;
            n1 = n2;
            n2 = temp;
        }

        n1.right = merge(n1.right, n2);

        if (n1 == null) {
            n1.left = n1.right;
            n1.right = null;
        }
        else {
            if (n1.left.pathToNull < n1.right.pathToNull) {
                Node temp = n1.left;
                n1.left = n1.right;
                n1.right = temp;
            }
            n1.pathToNull = n1.right.pathToNull + 1;
        }
        return n1;
    }

}
