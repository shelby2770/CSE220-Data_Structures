package Lab04_22101820_4;

public class Node{
  public Object element;
  public Node next;
  public Node prev;

  public Node(Object e, Node n, Node p){
    element =e ;
    next = n;
    prev =p;

  }
}