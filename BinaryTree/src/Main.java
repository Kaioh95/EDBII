public class Main {
    public static void main(String[] args) {
        Node root = new Node("/");
        Node subTree1 = new Node("+");
        Node subTree2 = new Node("*");
        Node subTree3 = new Node("A");
        Node subTree4 = new Node("*");
        Node subTree5 = new Node("+");
        Node subTree6 = new Node("C");
        Node subTree7 = new Node("B");
        Node subTree8 = new Node("C");
        Node subTree9 = new Node("A");
        Node subTree10 = new Node("B");

        subTree4.setLeft_child(subTree7);
        subTree4.setRight_child(subTree8);

        subTree5.setLeft_child(subTree9);
        subTree5.setRight_child(subTree10);

        subTree1.setLeft_child(subTree3);
        subTree1.setRight_child(subTree4);

        subTree2.setLeft_child(subTree5);
        subTree2.setRight_child(subTree6);

        root.setLeft_child(subTree1);
        root.setRight_child(subTree2);

        System.out.println("Pre-order");
        root.preOrder();
        System.out.println("\n*******************************************");

        System.out.println("In-order");
        root.inOrder();
        System.out.println("\n*******************************************");

        System.out.println("Post-order");
        root.postOrder();
        System.out.println("\n*******************************************");

        System.out.println("The Height of the Tree is: " + root.height(root));
    }
}
