public class AVLTree<T extends Comparable<T>> implements EstructuraArbol<T> {

    private Node<T> root;

    @Override
    public void add(T value) {
        root = insert(root, value);
    }

    @Override
    public T get(T key) {
        Node<T> node = search(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public T remove(T key) {
        Node<T> node = delete(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public int count() {
        return count(root);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        int cmp = value.compareTo(node.value);
        if (cmp < 0) {
            node.left = insert(node.left, value);
        } else if (cmp > 0) {
            node.right = insert(node.right, value);
        } else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && value.compareTo(node.left.value) < 0) {
            return rotateRight(node);
        }

        if (balance < -1 && value.compareTo(node.right.value) > 0) {
            return rotateLeft(node);
        }

        if (balance > 1 && value.compareTo(node.left.value) > 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && value.compareTo(node.right.value) < 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private Node<T> delete(Node<T> node, T key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.value);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = node.left == null ? node.right : node.left;
            } else {
                Node<T> minNode = findMin(node.right);
                node.value = minNode.value;
                node.right = delete(node.right, minNode.value);
            }
        }

        if (node == null) {
            return null;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }

        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private Node<T> search(Node<T> node, T key) {
        if (node == null) {
        int cmp = key.compareTo(node.value);
        if (cmp == 0) {
            return node;
        } else if (cmp < 0) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }
        return node;
    }

    private int count(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return 1 + count(node.left) + count(node.right);
    }

    private Node<T> findMin(Node<T> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> child = node.right;
        Node<T> grandChild = child.left;

        child.left = node;
        node.right = grandChild;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        child.height = 1 + Math.max(height(child.left), height(child.right));

        return child;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> child = node.left;
        Node<T> grandChild = child.right;

        child.right = node;
        node.left = grandChild;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        child.height = 1 + Math.max(height(child.left), height(child.right));

        return child;
    }

    private int height(Node<T> node) {
        return node == null ? -1 : node.height;
    }

    private int getBalance(Node<T> node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;
        int height;

        Node(T value) {
            this.value = value;
            height = 0;
        }
    }
}
