public class Main {
    private Node root;

    public static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }

        return current;
    }

    public Node getMin() {
        return getMinRecursive(root);
    }

    private Node getMinRecursive(Node current) {
        if (current == null) {
            return null;
        } else if (current.left == null) {
            return current;
        } else {
            return getMinRecursive(current.left);
        }
    }

    public Node getMax() {
        return getMaxRecursive(root);
    }

    private Node getMaxRecursive(Node current) {
        if (current == null) {
            return null;
        } else if (current.right == null) {
            return current;
        } else {
            return getMaxRecursive(current.right);
        }
    }

    public void traverseInOrderDescending() {
        traverseInOrderDescendingRecursive(root);
    }

    private void traverseInOrderDescendingRecursive(Node node) {
        if (node != null) {
            traverseInOrderDescendingRecursive(node.right);
            System.out.print(node.value + " ");
            traverseInOrderDescendingRecursive(node.left);
        }
    }

    public static void main(String[] args) {
        Main bst = new Main();
        bst.add(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);
        bst.add(12);
        bst.add(18);

        System.out.println("Minimum value: " + bst.getMin().value);
        System.out.println("Maximum value: " + bst.getMax().value);

        System.out.print("In-order traversal in descending order: ");
        bst.traverseInOrderDescending();
    }
}
