package edu.citytech.datastructure.sid23953296.bst;

import com.jbbwebsolutions.bst.AbstractSearchEngine;
import com.jbbwebsolutions.bst.INumber;
import com.jbbwebsolutions.bst.Node;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static edu.citytech.datastructure.sid23953296.bst.TreeHelper.isEmpty;

public class CustomSearchEngine<T extends Comparable<T>> extends AbstractSearchEngine<T> {

    private T binarySearch(Node<T> node, T value, Consumer<T> consumer) {
        consumer.accept(node.value);

        if (TreeHelper.isEqual(node.value, value)) {
            return node.value;
        } else if (TreeHelper.isLessThan(value, node.value)) {
            binarySearch(node.leftChild, value, consumer);

        } else if (TreeHelper.isGreaterThan(value, node.value)) {
            binarySearch(node.rightChild, value, consumer);
        }

        return null;
    }

    @Override
    public T find(Node<T> node, T value, Consumer<T> consumer) {
        return this.binarySearch(node, value, consumer);
    }

    @Override
    public T min(Node<T> node) {
        return this.findMin(node.leftChild);
    }

    private T findMin(Node<T> node) {
        if (node.leftChild == null)
            return node.value;
        return findMin(node.leftChild);
    }

    @Override
    public double sum(Node<T> node) {
        AtomicReference<Double> total = new AtomicReference<>(0d);
        this.traversePreOrder(node, data -> {
            if (data instanceof Number) {
                var $123 = ((Number) data).doubleValue() + total.get();
                total.set($123);
            } else if (data instanceof INumber) {
                var $123 = ((INumber) data).getNumber() + total.get();
                total.set($123);
            }
        });
        return total.get();
    }


    @Override
    public T max(Node<T> node) {
        return this.findMax(node.rightChild);
    }


    private T findMax(Node<T> node) {
        if (node.rightChild == null)
            return node.value;
        return findMax(node.rightChild);

    }

    @Override
    public long height(Node<T> node) {

        if (isEmpty(node)) {
            return -1;
        }
        if (isEmpty(node.leftChild) && isEmpty(node.rightChild)) {
            return 0;
        }
        long leftChild = height(node.leftChild);
        long rightChild = height(node.rightChild);
        long max = Math.max(leftChild, rightChild) + 1;

        node.height = max;
        return max;
    }

    @Override
    public T find(Node<T> node, T value, BiConsumer<T, Long> biConsumer) {
        return this.binarySearch(node, value, biConsumer);
    }

    private T binarySearch(Node<T> node, T value, BiConsumer<T,Long> biConsumer) {
        biConsumer.accept(node.value, node.height);

        if (TreeHelper.isEqual(node.value, value)) {
            return node.value;
        } else if (TreeHelper.isLessThan(value, node.value)) {
            binarySearch(node.leftChild, value, biConsumer);

        } else if (TreeHelper.isGreaterThan(value, node.value)) {
            binarySearch(node.rightChild, value, biConsumer);
        }

        return null;
    }

    @Override
    public void traversePreOrder(Node<T> node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }
        consumer.accept(node.value);
        traversePreOrder(node.leftChild, consumer);
        traversePreOrder(node.rightChild, consumer);
    }
}
