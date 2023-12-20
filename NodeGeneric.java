// Written by Ibraheem Fannoun
public class NodeGeneric <T extends Comparable<T>>{
    // generic node class for a binary tree are comparable objects
    // global variables
    private T data;
    private NodeGeneric<T> left;
    private NodeGeneric<T> right;
    //

    //constuctor
    public NodeGeneric(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public NodeGeneric(T data, NodeGeneric<T> left, NodeGeneric right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    // getters for all instance variables
    public T getData() {
        return this.data;
    }

    public NodeGeneric<T> getLeft() {
        return this.left;
    }
    public NodeGeneric<T> getRight() {
        return this.right;
    }
    // setters for all instance variables
    public void setData(T dat) {
        this.data = dat;
    }
    public void setLeft(NodeGeneric<T> l) {
        this.left = l;
    }
    public void setRight(NodeGeneric<T> r) {
        this.right = r;
    }
}
