package edu.citytech.datastructure.sid23953296;

import edu.citytech.datastructure.sid23953296.bst.BinarySearchTree;
import edu.citytech.datastructure.sid23953296.bst.CustomSearchEngine;
import edu.citytech.datastructure.sid23953296.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Min/Max Method for Customer Search")
class T3_MinOrMax {

    static Product[] products;
    static double sum = 0;

    static {

        Product[] aProducts = {new Product("p1", 76f), new Product("p2", 40f), new Product("p2b", 10f)
                , new Product("p3", 96f), new Product("p4", 100f)
                , new Product("p5", 82f), new Product("p6", 88f), new Product("p4", 9)
                , new Product("p7", 105f), new Product("p8", -10f)};

        products = Arrays.stream(aProducts).toArray(Product[]::new);

        sum = Arrays.stream(aProducts).mapToDouble(Product::getPrice).sum();

    }

    @Test
    @DisplayName("Default: Min Method")
    void min() {
        var bst = new BinarySearchTree<Product>();

        bst.insert(products);

        var product = bst.min();
        var actual = product.getName();
        var expected = "p8";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Custom: Min Method")
    void minD() {
        var bst = new BinarySearchTree<Product>(new CustomSearchEngine<>());

        bst.insert(products);

        var product = bst.min();
        var actual = product.getName();
        var expected = "p8";

        assertEquals(actual, expected);
    }


    @Test
    @DisplayName("Default: Max Method")
    void max() {
        var bst = new BinarySearchTree<Product>();

        bst.insert(products);

        var product = bst.max();
        var actual = product.getName();
        var expected = "p7";

        assertEquals(actual, expected);
    }


    @Test
    @DisplayName("Custom: Max Method")
    void maxD() {
        var bst = new BinarySearchTree<Product>(new CustomSearchEngine<>());

        bst.insert(products);

        var product = bst.max();
        var actual = product.getName();
        var expected = "p7";

        assertEquals(actual, expected);
    }


}