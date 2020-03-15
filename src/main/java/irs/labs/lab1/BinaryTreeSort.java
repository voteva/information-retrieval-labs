package irs.labs.lab1;

import irs.labs.lab1.model.SortResult;

import javax.annotation.Nonnull;

public class BinaryTreeSort implements Sorting {

    private int comparisons = 0;
    private int permutations = 0;

    @Nonnull
    @Override
    public SortResult sort(@Nonnull Integer[] items) {

        BinaryTree tree = new BinaryTree();
        tree.insert(items);
        tree.inorderRec(tree.root);

        return new SortResult()
                .setSortedItems(items)
                .setComparisons(comparisons)
                .setPermutations(permutations);
    }

    private class BinaryTree {
        class Node {
            int key;
            Node left, right;

            public Node(int item) {
                key = item;
                left = right = null;
            }
        }

        Node root;

        BinaryTree() {
            root = null;
        }

        Node insertRec(Node root, int key) {
            if (root == null) {
                root = new Node(key);
                return root;
            }

            comparisons++;
            if (key < root.key) {
                root.left = insertRec(root.left, key);

            } else if (key > root.key) {
                root.right = insertRec(root.right, key);
            }

            return root;
        }

        void inorderRec(Node root) {
            if (root != null) {
                inorderRec(root.left);
                //System.out.print(root.key + " ");
                inorderRec(root.right);
            }
        }

        void insert(Integer[] arr) {
            for (int value : arr) {
                root = insertRec(root, value);
            }
        }
    }
}
