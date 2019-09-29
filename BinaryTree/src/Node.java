/**
 * Class that implements the Abstract Data Type (ADT) Binary Tree
 * @author Kaio Henrique
 */
public class Node {
    /**
     * Key attribute
     */
    private String value;
    /**
     * Left Pointer
     */
    private Node left_child;
    /**
     * Right Pointer
     */
    private Node right_child;

    public Node(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft_child() {
        return left_child;
    }

    public void setLeft_child(Node left_child) {
        this.left_child = left_child;
    }

    public Node getRight_child() {
        return right_child;
    }

    public void setRight_child(Node right_child) {
        this.right_child = right_child;
    }

    /**
     * Method that traversal the tree in pre-order
     */
    public void preOrder(){
        System.out.print(this.value + " ");

        if(this.left_child != null)
            this.left_child.preOrder();

        if(this.right_child != null)
            this.right_child.preOrder();

    }

    /**
     * Method that traversal the tree in in-order
     */
    public void inOrder(){
        if(this.left_child != null)
            this.left_child.inOrder();

        System.out.print(this.value + " ");

        if(this.right_child != null)
            this.right_child.inOrder();
    }

    /**
     * Method that traversal the tree in post-order
     */
    public void postOrder(){
        if(this.left_child != null)
            this.left_child.postOrder();

        if(this.right_child != null)
            this.right_child.postOrder();

        System.out.print(this.value + " ");
    }

    /**
     * Method that return the tree height
     * @param n
     * @return int
     */
    public int height(Node n){
        if(n == null)
            return -1;
        return Math.max(height(n.left_child), height(n.right_child)) + 1;
    }
}
