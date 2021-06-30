package com.lavesh.design.patterns.behavioral.iterator;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * User: Lavesh
 * Date: 8/15/18
 * Time: 7:09 PM
 * To change this template use File | Settings | File Templates.
 */

class Node<T>
{
    public T value;
    public Node<T> left, right, parent;

    public Node(T value)
    {
        this.value = value;
    }

    public Node(T value, Node<T> left, Node<T> right)
    {
        this.value = value;
        this.left = left;
        this.right = right;

        left.parent = right.parent = this;
    }
}

class InOrderIterator<T> implements Iterator<T>
{
    private Node<T> current, root;
    private boolean yieldedStart;

    public InOrderIterator(Node<T> root)
    {
        this.root = current = root;

        while (current.left != null)
            current = current.left;
    }

    private boolean hasRightmostParent(Node<T> node)
    {
        if (node.parent == null) return false;
        else {
            return (node == node.parent.left)
                    || hasRightmostParent(node.parent);
        }
    }

    @Override
    public boolean hasNext()
    {
        return current.left != null
                || current.right != null
                || hasRightmostParent(current);
    }

    @Override
    public T next()
    {
        if (!yieldedStart)
        {
            yieldedStart = true;
            return current.value;
        }

        if (current.right != null)
        {
            current = current.right;
            while (current.left != null)
                current = current.left;
            return current.value;
        }
        else
        {
            Node<T> p = current.parent;
            while (p != null && current == p.right)
            {
                current = p;
                p = p.parent;
            }
            current = p;
            return current.value;
        }
    }
}

class BinaryTree<T> implements Iterable<T>
{
    private Node<T> root;

    public BinaryTree(Node<T> root)
    {
        this.root = root;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new InOrderIterator<>(root);
    }

    @Override
    public void forEach(Consumer<? super T> action)
    {
        for (T item : this)
            action.accept(item);
    }

    @Override
    public Spliterator<T> spliterator()
    {
        return null;
    }
}


public class TreeTraversal {
    public static void main(String[] args) {
        Node<Integer> nodes = new Node<>(5, new Node<>(10), new Node<>(6));
        InOrderIterator it = new InOrderIterator(nodes);
        while (it.hasNext()) {
            System.out.print(" " + it.next());
        }
        System.out.println("\n");
        BinaryTree<Integer> tree = new BinaryTree<>(nodes);
        for (int n : tree)
            System.out.print(" " + n );
        System.out.println();

    }
}
