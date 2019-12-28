/**
 * Class that implements the Abstract Data Type (ADT) Binary Search Tree
 * @author Kaio Henrique
 */
public class BST {
    private Node root;

    public BST(){}

    public BST(Integer value){
        this.root = new Node(value);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    /**
     * Method that traversal the tree in pre-order
     */
    public void preOrder(Node n){
        System.out.print(n.getValue() + " ");

        if(n.getLeft_child() != null)
            preOrder(n.getLeft_child());

        if(n.getRight_child() != null)
            preOrder(n.getRight_child());

    }

    /**
     * Method that traversal the tree in in-order
     */
    public void inOrder(Node n){
        if(n.getLeft_child() != null)
            inOrder(n.getLeft_child());

        System.out.print(n.getValue() + " ");

        if(n.getRight_child() != null)
            inOrder(n.getRight_child());
    }

    /**
     * Method that traversal the tree in post-order
     */
    public void postOrder(Node n){
        if(n.getLeft_child() != null)
            postOrder(n.getLeft_child());

        if(n.getRight_child() != null)
            postOrder(n.getRight_child());

        System.out.print(n.getValue() + " ");
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
        if(n.left_child.left_child == null){
            Integer x = n.getLeft_child().getValue();
            n.left_child = n.left_child.right_child;
            return x;
        }
        else
            return removeMin(n.getLeft_child());
    }

    public boolean remove(int id){
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while(current.value != id){
            parent = current;
            if(current.value > id){
                isLeftChild = true;
                current = current.left_child;
            }else{
                isLeftChild = false;
                current = current.right_child;
            }
            if(current ==null){
                return false;
            }
        }
        //if i am here that means we have found the node
        //Case 1: if node to be deleted has no children
        if(current.left_child == null && current.right_child == null){
            if(current==root){
                root = null;
            }
            if(isLeftChild ==true){
                parent.left_child = null;
            }else{
                parent.right_child = null;
            }
        }
        //Case 2 : if node to be deleted has only one child
        else if(current.right_child == null){
            if(current == root){
                root = current.left_child;
            }else if(isLeftChild){
                parent.left_child = current.left_child;
            }else{
                parent.right_child = current.left_child;
            }
        }
        else if(current.left_child == null){
            if(current == root){
                root = current.right_child;
            }else if(isLeftChild){
                parent.left_child = current.right_child;
            }else{
                parent.right_child = current.right_child;
            }
        }
        else if(current.left_child != null && current.right_child != null){

            //now we have to found the minimum element in the right sub tree
            Node successor	= getSuccessor(current);
            if(current == root){
                root = successor;
            }else if(isLeftChild){
                parent.left_child = successor;
            }else{
                parent.right_child = successor;
            }
            successor.left_child = current.left_child;
        }
        return true;
    }

    /**
     * Method that found the minimum element in the right sub tree
     * and remove the found element.
     * @param deleleNode
     * @return successor
     */
    public Node getSuccessor(Node deleleNode){
        Node successsor = null;
        Node successsorParent = null;
        Node current = deleleNode.right_child;
        while(current != null){
            successsorParent = successsor;
            successsor = current;
            current = current.left_child;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if(successsor != deleleNode.right_child){
            successsorParent.left_child = successsor.right_child;
            successsor.right_child = deleleNode.right_child;
        }
        return successsor;
    }

}
