package edu.citytech.datastructure.sid23953296.bst;

import com.jbbwebsolutions.bst.EnumComparison;
import com.jbbwebsolutions.bst.Node;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import static edu.citytech.datastructure.sid23953296.bst.TreeHelper.isLessThan;

public class AdvanceSearchEngine<T extends Comparable<T>> extends CustomSearchEngine<T>{
    @Override
    public List<T> findAll(Node<T> node, T value, Predicate<EnumComparison> predicate, BiConsumer<T, Long> biConsumer) {
        boolean greaterThan = predicate.test(EnumComparison.GREATER_THAN);
        boolean equalTo = predicate.test(EnumComparison.EQUAL);
        boolean lessThan = predicate.test(EnumComparison.LESS_THAN);

        System.out.println(greaterThan);
        System.out.println(equalTo);
        System.out.println(lessThan);
        // actual value it is going to return , actual comparison count
        if(isLessThan(value, node.value)){
            biConsumer.accept(null,1L);
        }



        return super.findAll(node, value, predicate, biConsumer);
    }


}
