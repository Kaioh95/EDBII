public class Main {

    public static void main(String[] args) {
        HeapTree heapTest = new HeapTree();

        heapTest.addNode(5, "EE");
        heapTest.addNode(3, "CC");
        heapTest.addNode(8, "HH");
        heapTest.addNode(7, "GG");
        heapTest.addNode(1, "AA");
        heapTest.addNode(4, "DD");
        heapTest.addNode(2, "BB");
        heapTest.addNode(6, "FF");
        heapTest.addNode(9, "II");

        System.out.println(heapTest.toString());
        heapTest.heapSort();
        System.out.println(heapTest.toString());

    }
}
