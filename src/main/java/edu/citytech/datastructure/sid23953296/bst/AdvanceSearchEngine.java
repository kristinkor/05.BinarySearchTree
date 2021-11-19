package edu.citytech.datastructure.sid23953296.bst;

import com.jbbwebsolutions.bst.EnumComparison;
import com.jbbwebsolutions.bst.Node;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import static edu.citytech.datastructure.sid23953296.bst.TreeHelper.isGreaterThan;
import static edu.citytech.datastructure.sid23953296.bst.TreeHelper.isLessThan;

public class AdvanceSearchEngine<T extends Comparable<T>> extends CustomSearchEngine<T> {
    @Override
    public List<T> findAll(Node<T> node, T value, Predicate<EnumComparison> predicate, BiConsumer<T, Long> biConsumer) {

        boolean greaterThan = predicate.test(EnumComparison.GREATER_THAN);
        boolean equalTo = predicate.test(EnumComparison.EQUAL);
        boolean lessThan = predicate.test(EnumComparison.LESS_THAN);

        System.out.println(greaterThan);
        System.out.println(equalTo);
        System.out.println(lessThan);

        // actual value it is going to return , actual comparison count
        //biConsumer.accept(null,1L);

//        if (TreeHelper.isEqual(node.value, value)) {
//            biConsumer.accept(node.value,1L);
//            //return node.value;
//
//        } else if (TreeHelper.isLessThan(value, node.value)) {
//            biConsumer.accept(node.value,1L);
//            findAll(node.leftChild, value, predicate, biConsumer);
//
//        } else if (TreeHelper.isGreaterThan(value, node.value)) {
//            findAll(node.rightChild, value, predicate, biConsumer);
//        }

        return super.findAll(node.rightChild, value, predicate, biConsumer);
    }


}
