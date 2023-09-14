package Lab03_22101820_4;
public class Node {
    public Object element; //Current Element
    public Node next; //Next Node's Reference

    public Node(Object e, Node n) {
        this.element = e;
        this.next = n;
    }
}
