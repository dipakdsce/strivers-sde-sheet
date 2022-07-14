package com.company.random;

import com.company.utility.Node;

import java.util.HashMap;

public class BuildFromPreAndInOrder {
    static int preIndex = 0;
    static HashMap<Integer, Integer> indexMap = new HashMap<>();

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
//        Node tree = buildTree(inorder, preorder, 0, preorder.length - 1);

        populateIndexMap(inorder);
        Node tree = buildTree1(inorder, preorder, 0, preorder.length -1);
        printInOrder(tree);
    }

    private static void printInOrder(Node tree) {
        if(tree == null) {
            return;
        }

        printInOrder(tree.left);
        System.out.print(tree.data + " ");
        printInOrder(tree.right);
    }

    /*
    Time Complexity is O(N^2)
     */
    private static Node buildTree(int[] inorder, int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        Node tree = new Node(preorder[preIndex++]);

        if(start == end) {
            return tree;
        }

        int inIndex = search(inorder, start, end, tree.data);

        tree.left = buildTree(inorder, preorder, start, inIndex - 1);
        tree.right = buildTree(inorder, preorder, inIndex+1, end);
        return tree;
    }

    private static int search(int[] inorder, int start, int end, int value) {
        int i;
        for (i = start; i <= end; i++) {
            if(inorder[i] == value) {
                return i;
            }
        }
        return i;
    }

    private static void populateIndexMap(int[] inorder) {
        for(int i=0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
    }

    private static Node buildTree1(int[] inorder, int[] preorder, int start, int end) {
        if(start > end) {
            return null;
        }

        Node tree = new Node(preorder[preIndex++]);

        if(start == end) {
            return tree;
        }

        int inIndex = indexMap.get(tree.data);

        tree.left = buildTree1(inorder, preorder, start, inIndex - 1);
        tree.right = buildTree1(inorder, preorder, inIndex + 1, end);
        return tree;
    }
}
