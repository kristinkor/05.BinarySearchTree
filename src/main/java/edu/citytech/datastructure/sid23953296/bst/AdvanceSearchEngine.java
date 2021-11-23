package edu.citytech.datastructure.sid23953296.bst;

import com.jbbwebsolutions.bst.EnumComparison;
import com.jbbwebsolutions.bst.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

import static edu.citytech.datastructure.sid23953296.bst.TreeHelper.*;

public class AdvanceSearchEngine<T extends Comparable<T>> extends CustomSearchEngine<T> {
    @Override
    public List<T> findAll(Node<T> node, T value, Predicate<EnumComparison> predicate, BiConsumer<T, Long> biConsumer) {

        boolean greaterThan = predicate.test(EnumComparison.GREATER_THAN);
        boolean equalTo = predicate.test(EnumComparison.EQUAL);
        boolean lessThan = predicate.test(EnumComparison.LESS_THAN);
        boolean greaterThanOrEqual = predicate.test(EnumComparison.GREATER_THAN) || predicate.test(EnumComparison.EQUAL);
        List<T> result = new ArrayList<>();

        if (equalTo & !greaterThan) {
            result.add(equalTo(node, value, biConsumer));
            return result;
        }

        if (greaterThan && !equalTo) {
            greaterThan(node, value, biConsumer, result);
            return result;
        }
        if (greaterThanOrEqual) {
            greaterThanOrEqual(node, value, biConsumer, result);
            return result;
        }
        if (lessThan) {
            lessThan(node, value, biConsumer, result);
            return result;
        }

        return result;

    }


    private T equalTo(Node<T> node, T value, BiConsumer<T, Long> biConsumer) {
        biConsumer.accept(node.value, 1L);
        if (isEqual(node.value, value)) {
            return node.value;
        } else if (isLessThan(value, node.value)) {
            return equalTo(node.leftChild, value, biConsumer);

        } else if (isGreaterThan(value, node.value)) {
            return equalTo(node.rightChild, value, biConsumer);
        }
        return null;
    }

    private void greaterThan(Node<T> node, T value, BiConsumer<T, Long> biConsumer, List<T> list) {
        if (node == null) {
            return;
        }
        biConsumer.accept(node.value, 1L);
        if (isLessThan(value, node.value)) {
            list.add(node.value);
            findAllRight(node.rightChild, list, value);
            greaterThan(node.leftChild, value, biConsumer, list);
        } else {
            greaterThan(node.rightChild, value, biConsumer, list);
        }
    }

    private void greaterThanOrEqual(Node<T> node, T value, BiConsumer<T, Long> biConsumer, List<T> list) {
        if (node == null) {
            return;
        }
        biConsumer.accept(node.value, 1L);
        if (isEqual(node.value, value)) {
            list.add(node.value);

        }
        if (isLessThan(value, node.value)) {
            list.add(node.value);
            findAllRight(node.rightChild, list, value);
            greaterThanOrEqual(node.leftChild, value, biConsumer, list);
        } else {
            greaterThanOrEqual(node.rightChild, value, biConsumer, list);

        }

    }

    private void lessThan(Node<T> node, T value, BiConsumer<T, Long> biConsumer, List<T> list) {
        if (node == null) {
            return;
        }
        biConsumer.accept(node.value, 1L);
        if (isGreaterThan(value, node.value)) {
            findAllLeft(node.leftChild, list, value);
            lessThan(node.leftChild, value, biConsumer, list);
        }

    }

    public void findAllRight(Node<T> node, List<T> list, T value) {
        if (node != null) {
            list.add(node.value);
            findAllRight(node.leftChild, list, value);
            findAllRight(node.rightChild, list, value);
        }
    }

    public void findAllLeft(Node<T> node, List<T> list, T value) {
        if (node != null) {
            list.add(node.value);
            findAllLeft(node.leftChild, list, value);
            findAllLeft(node.rightChild, list, value);
        }
    }
}
