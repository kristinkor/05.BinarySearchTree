package edu.citytech.datastructure.sid23953296;

import edu.citytech.datastructure.sid23953296.bst.AVLTreeInsertion;
import edu.citytech.datastructure.sid23953296.bst.BinarySearchTree;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class T9_BSTWithProduct {

    @Test
    @DisplayName("Searching for 1500, 2000, 1750,3000 ")
    void getBasicSearchEngineA(){
        var bst = new BinarySearchTree<Integer>(new AVLTreeInsertion());
        bst.batchInserts(1500,2000,1750,3000);
        var node = bst.rotateLeft();
        System.out.println(node);
    }

    @Test
    @DisplayName("Searching for 1,2,3 ")
    void getBasicSearchEngineB(){
        var bst = new BinarySearchTree<Integer>(new AVLTreeInsertion());
        bst.batchInserts(300,150,200);


        System.out.println("");
    }
}
