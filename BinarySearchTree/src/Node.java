/**
 * Class that implements the Abstract Data Type (ADT) Binary Search Tree
 * @author Kaio Henrique
 */
public class Node {
    /**
     * Key attribute
     */
    public Integer value;
    /**
     * Left Pointer
     */
    public Node left_child;
    /**
     * Right Pointer
     */
    public Node right_child;

    public Node(){}
    public Node(Integer value){
        this.value = value;
        left_child = null;
        right_child = null;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
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

}