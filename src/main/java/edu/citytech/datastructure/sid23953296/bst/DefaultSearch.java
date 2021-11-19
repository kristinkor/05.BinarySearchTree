package edu.citytech.datastructure.sid23953296.bst;

import com.jbbwebsolutions.bst.AbstractSearchEngine;
import com.jbbwebsolutions.bst.Node;

import java.util.function.Consumer;

public class DefaultSearch<T extends Comparable<T>> extends AbstractSearchEngine<T> {

    @Override
    public T find(Node<T> root, T value, Consumer<T> consumer) {
        T t = null;
        var current = root;
        while (!TreeHelper.isEmpty(current)) {

            consumer.accept(current.value);

            if (TreeHelper.isLessThan(value, current.value)) {
                current = current.leftChild;
            } else if (TreeHelper.isGreaterThan(value, current.value)) {
                current = current.rightChild;
            } else {
                return current.value;
            }
        }
        return null;
    }

    @Override
    public T min(Node<T> node) {
        while (!TreeHelper.isEmpty(node)) {
            if(node.leftChild != null)
                node = node.leftChild;
            else
                return node.value;
        }
        return null;
    }


    @Override
    public T max(Node<T> node) {
        while (!TreeHelper.isEmpty(node)) {
            if(node.rightChild != null)
                node = node.rightChild;
            else
                return node.value;
        }
        return null;
    }
}
