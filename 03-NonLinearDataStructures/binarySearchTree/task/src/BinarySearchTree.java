import java.lang.Comparable;
import java.util.function.Consumer;

public class BinarySearchTree<K extends Comparable<K>, V> {
    BinaryTreeNode<K, V> root = null;

    // empty constructor
    public BinarySearchTree() {}

    // DO NOT TOUCH - An alias to a private method
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private BinaryTreeNode<K, V> add(BinaryTreeNode<K, V> t, K key,V value/* TODO: takes a value here */) {
        /* TODO: implement BST inserting here */
        if (t==null)
        {
            t = new BinaryTreeNode<K, V>();
            t.key=key;
            t.value=value;
        } else if (t.key.compareTo(key)>0)
        {
            t.left=add(t.left,key,value);
        }
     else if (t.key.compareTo(key)<0)
        {
            t.right=add(t.right,key,value);
        }
     return t;
    }

    public V get(K key) {
        /* TODO: call the search() and return its value */
        BinaryTreeNode<K, V> node;
        node = search(root,key);
        return node.value;

    }

    private BinaryTreeNode<K, V> search(BinaryTreeNode<K, V> t, K key) {
        /* TODO: implement the BST searching algorithm */
        if(t.key.compareTo(key)==0)
        {return t;}
        else if (t.key.compareTo(key)>0) {
            return search(t.left,key);
        }
        else if (t.key.compareTo(key)<0) {
            return search(t.right,key);
        }

        throw new IndexOutOfBoundsException(String.valueOf(key) + " not found");
    }

    // DO NOT TOUCH - An alias to a private method
    public void preorder(Consumer<K> processor) {
        preorder(root, processor);
    }

    // DO NOT TOUCH - An alias to a private method
    public void inorder(Consumer<K> processor) {
        inorder(root, processor);
    }

    // DO NOT TOUCH - An alias to a private method
    public void postorder(Consumer<K> processor) {
        postorder(root, processor);
    }

    private void preorder(BinaryTreeNode<K, V> t, Consumer<K> processor) {
        /* TODO: implement the preorder traversal */
        if(t!=null)
        {
            processor.accept(t.key);
            preorder(t.left,processor);
            preorder(t.right,processor);
        }
    }

    private void inorder(BinaryTreeNode<K, V> t, Consumer<K> processor) {
        /* TODO: implement the inorder traversal */
        if(t!=null)
        {
            inorder(t.left,processor);
            processor.accept(t.key);
            inorder(t.right,processor);
        }
    }

    private void postorder(BinaryTreeNode<K, V> t, Consumer<K> processor) {
        /* TODO: implement the postorder traversal */
        if(t!=null)
        {
            postorder(t.left,processor);
            postorder(t.right,processor);
            processor.accept(t.key);
        }
    }

    private static class BinaryTreeNode<K, V> {
        /* TODO: implement a binary tree node */
        K key;
        V value;
        BinaryTreeNode<K, V> left;
        BinaryTreeNode<K, V> right;

    }
}