package edu.citytech.datastructure.sid23953296;

import edu.citytech.datastructure.sid23953296.bst.BinarySearchTree;

public class V1_ForBinarySearch {
    public static void main(String[] args) {
        var bst = new BinarySearchTree();
        bst.insert(75);
        bst.insert(40);
        bst.insert(10);
        bst.insert(65);

        System.out.println(bst);
        var bstABC = new BinarySearchTree();
        bstABC.insert("Z");
        bstABC.insert("b");
        bstABC.insert("c");

        System.out.println(bstABC);
    }
}
