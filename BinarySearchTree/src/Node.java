/**
 * Class that implements the Abstract Data Type (ADT) Binary Search Tree
 * @author Kaio Henrique
 */
public class Node {
    /**
     * Key attribute
     */
    private Integer value;
    /**
     * Left Pointer
     */
    private Node left_child;
    /**
     * Right Pointer
     */
    private Node right_child;

    public Node(){}
    public Node(Integer value){
        this.value = value;
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

    /**
     * Method that do the binary search iteratively
     * @param n
     * @param key
     * @return Node
     */
    public Node search(Node n, Integer key){
        while(n != null && n.getValue() != key){

            if(n.getValue() > key)
                if(n.left_child == null)
                    return null;
                else
                    n = n.getLeft_child();

            else{
                if(n.right_child == null)
                    return null;
                else
                    n = n.getRight_child();
            }
        }
        System.out.println("The key is in the Tree, " + n.getValue());
        return n;
    }

    /**
     * Method to insert a new node
     * @param key
     * @param n
     */
    public void insert(Integer key, Node n){
        if(key < n.getValue())
            if(n.left_child == null)
                n.left_child = new Node(key);
            else
                insert(key, n.getLeft_child());

        if(key > n.getValue())
            if(n.right_child == null)
                n.right_child = new Node(key);
            else
                insert(key, n.getRight_child());
    }

    public Node maxKey(Node n){
        if(n.right_child == null)
            return n;

        return maxKey(n.getRight_child());
    }

    public Node minKey(Node n){
        if(n.left_child == null)
            return n;

        return minKey(n.getLeft_child());
    }

    public Integer removeMin(Node n){
        if(n.getLeft_child() == null){
            Integer x = n.getValue();
            n = n.getRight_child();
            return x;
        }
        else
            return removeMin(n.getLeft_child());
    }

    public void remove(Integer key, Node n){
        if(n != null){
            if(key < n.getValue())
                remove(key, n.left_child);
            else if(key > n.getValue())
                remove(key, n.right_child);
            else{
                if(n.left_child == null)
                    n = n.getRight_child();
                else if(n.right_child == null)
                    n = n.getLeft_child();
                else
                    n.setValue(removeMin(n.right_child));
            }
        }
    }

}