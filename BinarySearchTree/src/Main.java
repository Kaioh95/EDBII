import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> treeContent = new ArrayList<Integer>();

        treeContent.add(100); treeContent.add(200); treeContent.add(140);
        treeContent.add(50); treeContent.add(105); treeContent.add(70);
        treeContent.add(80); treeContent.add(30); treeContent.add(400);
        treeContent.add(350); treeContent.add(117); treeContent.add(80);
        treeContent.add(42); treeContent.add(65);

        Node tree = new Node(treeContent.get(0));

        for(int i = 1; i < 14; i++){
            tree.insert(treeContent.get(i), tree);
        }

        tree.preOrder();
        System.out.println("\n*********************************************");
        tree.search(tree, 80);

        Node maior = tree.maxKey(tree);
        Node menor = tree.minKey(tree);
        System.out.println("Max Value: " + maior.getValue() + "\nMin Value: " + menor.getValue());
        tree.remove(100, tree);
        tree.preOrder();
    }
}
