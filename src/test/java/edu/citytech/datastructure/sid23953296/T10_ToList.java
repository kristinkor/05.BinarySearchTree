package edu.citytech.datastructure.sid23953296;

import com.jbbwebsolutions.bst.BSTFacade;
import com.jbbwebsolutions.bst.EnumComparison;
import edu.citytech.datastructure.sid23953296.bst.AVLTreeInsertion;
import edu.citytech.datastructure.sid23953296.bst.AdvanceSearchEngine;
import edu.citytech.datastructure.sid23953296.bst.BinarySearchTree;
import edu.citytech.datastructure.sid23953296.model.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("To List")
public class T10_ToList {
    static Product[] products;
    static double sum = 0;

    static {

        Product[] aProducts = {new Product("p1", 700f), new Product("p2", 600f), new Product("p2b", 500f)
                , new Product("p3", 400f), new Product("p4", 609f)
                , new Product("p5", 605f), new Product("p6", 625f), new Product("p4", 1000), new Product("p7", 1200f),
                 new Product("p7", 800f), new Product("p7", 950f), new Product("p7", 1100f)
                , new Product("p7", 1300f)};

        products = Arrays.stream(aProducts).

                toArray(Product[]::new);

        sum = Arrays.stream(aProducts).

                mapToDouble(Product::getPrice).

                sum();

    }

    @Test
    @DisplayName("Greater Than")
    void greaterThan() {
        BSTFacade<Product> bst = new BinarySearchTree<Product>(new AdvanceSearchEngine<>(), new AVLTreeInsertion<>());
        bst.insert(products);
        Predicate<EnumComparison> predicate = e -> EnumComparison.GREATER_THAN == e;
        predicate = predicate.or(e -> EnumComparison.EQUAL == e);


        //biConsumer
        var list = bst.findAll(new Product(500), predicate, (Product e1, Long e2) -> {
            System.out.println(e1 + " - " + e2);
        });
        var actual = bst.toList().size();
        var expected = products.length;

        assertEquals(expected, actual);


    }
    @Test
    @DisplayName("Less Than")
    void lessThan() {
        BSTFacade<Product> bst = new BinarySearchTree<Product>(new AdvanceSearchEngine<>(), new AVLTreeInsertion<>());
        bst.insert(products);
        Predicate<EnumComparison> predicate = e -> EnumComparison.LESS_THAN == e;
        predicate = predicate.or(e -> EnumComparison.EQUAL == e);


        //biConsumer
        var list = bst.findAll(new Product(500), predicate, (Product e1, Long e2) -> {
            System.out.println(e1 + " - " + e2);
        });
        var actual = bst.toList().size();
        var expected = products.length;

        assertEquals(expected, actual);


    }


}
