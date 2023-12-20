import org.w3c.dom.Node;

public class BinarySearchTree<T extends Comparable<T>>{
    private NodeGeneric<T> root;

    public BinarySearchTree(NodeGeneric<T> root){
        this.root = root;
    }

    public NodeGeneric<T> getRoot(){
        return this.root;
    }

    public T getLeftMost(NodeGeneric<T> node){
        if (node.getLeft() == null){
            return node.getData();
        }
        else{
            return getLeftMost(node.getLeft());
        }
    }

    public T getRightMost(NodeGeneric<T> node){
        if (node.getRight() == null){
            return node.getData();
        }
        else{
            return getRightMost(node.getRight());
        }
    }
    
    public void addElement(T value){
        boolean done = false;
        NodeGeneric<T> pointer = this.root; // traversal pointer
        while (!done){
            if (value.compareTo(pointer.getData()) <= 0){ // if value is smaller then or equal to pointers datas
                if (pointer.getLeft() == null){ // if there exists no left node, add the value to the left in a new node
                    pointer.setLeft(new NodeGeneric<T>(value));
                    done = true; // variable updates to end loop
                }
                else{ // else check the left node by changing the pointer
                    pointer = pointer.getLeft();
                }
            }
            else{ // if value is larger then pointers data
                if (pointer.getRight() == null){ // if there exists no right node, add value to the right in a new node
                    pointer.setRight(new NodeGeneric<T>(value));
                    done = true; // varibale updates to end loop
                }
                else{ // else check the right node by changing the pointer
                    pointer = pointer.getRight();
                }
            }
        }
    }


    // TRAVERSAL METHODS:
    // these currently just print out the elements in the order of the traversals, but could be used to access all elements in anyway needed
    public void postOrder(NodeGeneric<T> currentRoot){
        if (currentRoot != null){ 
            postOrder(currentRoot.getLeft()); // call method on left branch
            postOrder(currentRoot.getRight()); // call metohd on right branch
            System.out.println(currentRoot.getData()); // print roots data
        }
    }

    public void preOrder(NodeGeneric<T> currentRoot){
        if (currentRoot != null){
            System.out.println(currentRoot.getData()); // print roots data
            this.preOrder(currentRoot.getLeft()); // call method on left branch
            preOrder(currentRoot.getRight()); // call method on right branch
        }
    }

    public void inOrder(NodeGeneric<T> currentRoot){
        if (currentRoot != null){
            this.inOrder(currentRoot.getLeft()); // call method on left branch
            System.out.println(currentRoot.getData()); // print roots data
            this.inOrder(currentRoot.getRight()); // call method on right branch
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>(new NodeGeneric<Integer>(50));
        tree.addElement(30);
        tree.addElement(60);
        tree.addElement(25);
        tree.addElement(55);
        tree.addElement(40);
        tree.addElement(70);
        System.out.println(tree.getRightMost(tree.getRoot()));
        tree.inOrder(tree.getRoot());
    }
}

