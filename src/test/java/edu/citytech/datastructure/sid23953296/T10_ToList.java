package edu.citytech.datastructure.sid23953296;

import com.jbbwebsolutions.bst.BSTFacade;
import com.jbbwebsolutions.bst.EnumComparison;
import edu.citytech.datastructure.sid23953296.bst.AVLTreeInsertion;
import edu.citytech.datastructure.sid23953296.bst.AdvanceSearchEngine;
import edu.citytech.datastructure.sid23953296.bst.BinarySearchTree;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("FindAll")
class T10_ToList {

    static Long[] data = {
            4000L, 3000L, 5000L, 2000L, 3700L, 4200L, 6000L, 1000L, 2500L, 3600L, 3800L, 4100L, 4300L, 5600L, 7000L};


    @Test
    @DisplayName("Equal to 1000")
    void equalTo() {
        BSTFacade<Long> bst = new BinarySearchTree<>(new AdvanceSearchEngine<>(), new AVLTreeInsertion<>());
        bst.insert(data);
        Predicate<EnumComparison> predicate = e -> EnumComparison.EQUAL == e;

        //biConsumer
        var list = bst.findAll(1000L, predicate, (Long value, Long rowCount) -> {
            System.out.println(value + " - " + rowCount);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 1;

        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Equal to 5600")
    void equalTo5600() {
        BSTFacade<Long> bst = new BinarySearchTree<>(new AdvanceSearchEngine<>(), new AVLTreeInsertion<>());
        bst.insert(data);
        Predicate<EnumComparison> predicate = e -> EnumComparison.EQUAL == e;

        //biConsumer
        var list = bst.findAll(5600L, predicate, (Long value, Long rowCount) -> {
            System.out.println(value + " - " + rowCount);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 1;

        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Greater Than 5600")
    void greaterThan5600() {
        BSTFacade<Long> bst = new BinarySearchTree<>(new AdvanceSearchEngine<>(), new AVLTreeInsertion<>());
        bst.insert(data);
        Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;


        //biConsumer
        var list = bst.findAll(5600L, predicate, (Long value, Long rowCount) -> {
            System.out.println(value + " - " + rowCount);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Greater Than 3700")
    void greaterThan3700() {
        BSTFacade<Long> bst = new BinarySearchTree<>(new AdvanceSearchEngine<>(), new AVLTreeInsertion<>());
        bst.insert(data);
        Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;


        //biConsumer
        var list = bst.findAll(3700L, predicate, (Long value, Long rowCount) -> {
            System.out.println(value + " - " + rowCount);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 9;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Greater Than 100")
    void greaterThan100() {
        BSTFacade<Long> bst = new BinarySearchTree<>(new AdvanceSearchEngine<>(), new AVLTreeInsertion<>());
        bst.insert(data);
        Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;


        //biConsumer
        var list = bst.findAll(100L, predicate, (Long value, Long rowCount) -> {
            System.out.println(value + " - " + rowCount);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 15;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Less Than 5600")
    void lessThan() {
        BSTFacade<Long> bst = new BinarySearchTree<>(new AdvanceSearchEngine<>(), new AVLTreeInsertion<>());
        bst.insert(data);
        Predicate<EnumComparison> predicate = e -> EnumComparison.LESS_THAN == e;


        //biConsumer
        var list = bst.findAll(5600L, predicate, (Long value, Long rowCount) -> {
            System.out.println(value + " - " + rowCount);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 11;

        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Greater Than or Equal to 2000")
    void greaterThanOrEqual() {
        BSTFacade<Long> bst = new BinarySearchTree<>(new AdvanceSearchEngine<>(), new AVLTreeInsertion<>());
        bst.insert(data);
        Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;
        predicate = predicate.or(e -> EnumComparison.EQUAL == e);


        //biConsumer
        var list = bst.findAll(2000L, predicate, (Long value, Long rowCount) -> {
            System.out.println(value + " - " + rowCount);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 14;

        assertEquals(expected, actual);


    }

    @Test
    @DisplayName("Greater Than or Equal 600")
    void greaterThanOrEqual600() {
        BSTFacade<Long> bst = new BinarySearchTree<>(new AdvanceSearchEngine<>(), new AVLTreeInsertion<>());
        bst.insert(data);
        Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;
        predicate = predicate.or(e -> EnumComparison.EQUAL == e);


        //biConsumer
        var list = bst.findAll(600L, predicate, (Long value, Long rowCount) -> System.out.println(value + " - " + rowCount));

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 15;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Greater Than or Equal 600")
    void greaterThanOrEqual5600() {
        BSTFacade<Long> bst = new BinarySearchTree<>(new AdvanceSearchEngine<>(), new AVLTreeInsertion<>());
        bst.insert(data);
        Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;
        predicate = predicate.or(e -> EnumComparison.EQUAL == e);


        //biConsumer
        var list = bst.findAll(5600L, predicate, (Long value, Long rowCount) -> System.out.println(value + " - " + rowCount));

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Greater Than or Equal 7000")
    void greaterThanOrEqual7000() {
        BSTFacade<Long> bst = new BinarySearchTree<>(new AdvanceSearchEngine<>(), new AVLTreeInsertion<>());
        bst.insert(data);
        Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;
        predicate = predicate.or(e -> EnumComparison.EQUAL == e);


        //biConsumer
        var list = bst.findAll(7000L, predicate, (Long value, Long rowCount) -> {
            System.out.println(value + " - " + rowCount);
        });

        System.out.println("List: " + list + " size: " + list.size());

        var actual = list.size();
        var expected = 1;

        assertEquals(expected, actual);
    }
}
