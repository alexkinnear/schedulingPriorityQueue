public class LeftistHeap<E extends Comparable<E>> {

    private LeftistNode<E> root;

    public LeftistHeap() {
        root = null;
    }

    public void merge(LeftistHeap<E> rightSubTree) {
        if(this == rightSubTree)
            return;

        root = merge(root, rightSubTree.root);
        rightSubTree.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private LeftistNode<E> merge(LeftistNode<E> tree1, LeftistNode<E> tree2) {
        if(tree1 == null)
            return tree2;
        if(tree2 == null)
            return tree1;
        if(tree1.element.compareTo(tree2.element) < 0)
            return mergeHelper(tree1, tree2);
        else
            return mergeHelper(tree2, tree1);
    }


    private LeftistNode<E> mergeHelper(LeftistNode<E> tree1, LeftistNode<E> tree2) {
        if(tree1.left == null)
            tree1.left = tree2;
        else {
            tree1.right = merge(tree1.right, tree2);
            if(tree1.left.pathToNull < tree1.right.pathToNull)
                swapChildren(tree1);
            tree1.pathToNull = tree1.right.pathToNull + 1;
        }
        return tree1;
    }


    private static <E> void swapChildren(LeftistNode<E> node) {
        LeftistNode<E> temp = node.left;
        node.left = node.right;
        node.right = temp;
    }


    public void insert(E node) {
        LeftistNode<E> newNode = new LeftistNode<E>(node);
        root = merge(newNode, root);
    }


    public E deleteMin( ) {
        if(root == null)
            return null;

        E minElement = root.element;
        root = merge( root.left, root.right);

        return minElement;
    }

    public void printTree() {
        printTree(root, "");
    }
    private void printTree(LeftistNode<E> node, String indent) {
        if (node == null) return;
        printTree(node.right, indent + "    ");
        System.out.println(indent + node.element);
        printTree(node.left, indent + "    ");
    }

    private static class LeftistNode<E> {
        LeftistNode(E element) {
            this(element, null, null);
        }

        LeftistNode(E element, LeftistNode<E> left, LeftistNode<E> right) {
            this.element = element;
            this.left = left;
            this.right = right;
            this.pathToNull = 0;
        }

        E element;
        LeftistNode<E> left;
        LeftistNode<E> right;
        int pathToNull;
    }

    public static void main(String[] args) {
        LeftistHeap<Integer> intHeap = new LeftistHeap<>();
        LeftistHeap<String> stringHeap = new LeftistHeap<>();
        for (int i = 0; i < 300; i += 10) {
            intHeap.insert(i);
        }
        for (int i = 0; i < 50; i++) {
            intHeap.insert(i);
        }
        for (int i = 0; i < 25; i++) {
            System.out.println(intHeap.deleteMin());
        }
        intHeap.printTree();


//        for (int i = 0; i < 300; i += 10) {
//            stringHeap.insert(i+"");
//        }
//        for (int i = 0; i < 50; i++) {
//            stringHeap.insert(i+"");
//        }
//        for (int i = 0; i < 25; i++) {
//            System.out.println(stringHeap.deleteMin());
//        }
//        stringHeap.printTree();

    }

}
