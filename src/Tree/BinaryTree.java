package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {
    public Node<T> root;
    int numberOfNodes;

    public BinaryTree() {
        this.numberOfNodes = 0;
    }

    public BinaryTree(T value) {
        this.root = new Node<>();
        this.root.value = value;
        this.numberOfNodes = 0;
    }

    public Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        } else {
            if (node.testCompare(value) == 0) {
                node.left = insert(node.left, value);
            } else if (node.testCompare(value) == 2) {
                node.right = insert(node.right, value);
            } else if (node.testCompare(value) == 1) {
                node.count++;
            }
        }
        return node;
    }

//    public Node<T> delete(Node<T> root, T value) {
//        if (root == null) {
//            System.out.println("Element Not exist");
//        } else {
//            if (root.testCompare(value) == 0) {
//                delete(root.left, value);
//            } else if (root.testCompare(value) == 2) {
//                delete(root.right, value);
//            } else if (root.left != null && root.right != null) {
//                Node<T> temp = findLargest(root.left);
//                root.value = temp.value;
//                delete(root.left, temp.value);
//            } else {
//                if (root.left != null) {
//                    root.value = root.left.value;
//                    root.count = root.left.count;
//                    root.left = null;
//                } else if (root.right != null) {
//                    root.value = root.right.value;
//                    root.count = root.right.count;
//                    root.right = null;
//                } else if (root.left == null && root.right == null) {
//                    root = null;
//                }
//            }
//        }

        public void levelOrderTraversal () {
            if (root == null) {
                System.out.println("Tree is empty");
            } else {
                Queue<Node<T>> queue = new LinkedList<>();
                queue.add(root);
                while (!queue.isEmpty()) {
                    Node<T> temp = queue.remove();
                    System.out.println(temp.value + " ");
                    if (temp.left != null) {
                        queue.add(temp.left);
                    }
                    if (temp.right != null) {
                        queue.add(temp.right);
                    }
                }
            }
        }

        public void image (Node <T> root) {
            Node<T> temp;
            if (root != null) {
                image(root.left);
                image(root.right);
                temp = root.left;
                root.left = root.right;
                root.right = temp;
            }
        }

        public void inOrder (Node < T > root) {
            if (root != null) {
                inOrder(root.left);
                System.out.println(root.value);
                inOrder(root.right);
            }
        }

        public void preOrder (Node < T > root) {
            if (root != null) {
                System.out.println(root.value);
                preOrder(root.left);
                preOrder(root.right);
            }
        }

        public void postOrder (Node < T > root) {
            if (root != null) {
                postOrder(root.left);
                postOrder(root.right);
                System.out.println(root.value);
            }
        }

        public Node<T> search (Node < T > root, T value) throws Exception {
            if (root != null) {
                if (root.value == value) {
                    return root;
                } else if (root.testCompare(value) == 0) {
                    return search(root.left, value);
                } else if (root.testCompare(value) == 2) {
                    return search(root.right, value);
                }
            } else {
                throw new Exception("Element not found");

            }
            return root;
        }

        public Node<T> findSmallest (Node < T > root) {
            if (root == null || root.left == null) {
                return root;
            } else {
                return findSmallest(root.left);
            }
        }

        public Node<T> findLargest (Node<T> root) {
            if (root == null || root.right == null) {
                return root;
            } else {
                return findLargest(root.right);
            }
        }
    }
