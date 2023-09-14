package Lab03_22101820_4;
public class LinkedList {
    public Node head;

    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the Node that contains the element from a[0]
     */
    public LinkedList(Object[] a) {
        head = new Node(a[0], null);
        Node shelby = head;
        for (int i = 1; i < a.length; ++i) {
            shelby.next = new Node(a[i], null);
            shelby= shelby.next;
        }
    }

    //Traverse elements in the list.
    //This method is done for you. Do not change this method.
    void traverseList(){
        String s= "";
        Node temp= head;
        while (temp!= null){
            if (temp.next!= null) System.out.print(temp.element+ " ");
            else System.out.println(temp.element);
            temp= temp.next;
        }
    }

    //Count the number of nodes in the list and return the total number
    int countNode() {
        int counter= 0;
        for (Node shelby = head; shelby!= null; shelby= shelby.next) counter++;
        return counter;
    }


    // returns the reference of the Node at the given index. For invalid index return null.
    Node nodeAt(int idx) {
        if (idx < 0 || idx >= countNode()) return null;
        int pointer= 0;
        Node shelby = head;
        for (;shelby!= null; shelby= shelby.next) {
            if (pointer == idx) return shelby;
            pointer++;
        }
        return shelby;
    }

    // returns the element of the Node at the given index. For invalid idx return null.
    Object get(int idx) {
        return nodeAt(idx).element;
    }

    /* updates the element of the Node at the given index.
     * Returns the old element that was replaced. For invalid index return null.
     * parameter: index, new element
     */
    Object set(int idx, int elem) {
        if (idx < 0 || idx >= countNode()) return null;
        Object val= head.element;

        if (idx== 0){
            Node temp= head;
            head= new Node(elem, temp);
        }
        else{
            val= nodeAt(idx).element;
            Node val_node= nodeAt(idx-1);
            val_node.next= new Node(elem, nodeAt(idx).next);
        }
        return val;
    }

    /* returns the index of the Node containing the given element.
     * if the element does not exist in the List, return -1.
     */
    int indexOf(Object elem) {
        int i = 0;
        for (Node shelby = head; shelby!= null; shelby= shelby.next){
            if (shelby.element== elem) {return i;}
            i++;
        }
        return -1;
    }

    // returns true if the element exists in the List, return false otherwise.
    boolean contains(Object elem) {
        return indexOf(elem)!=-1;
    }

    // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
    Object[] copyList() {
        int length= countNode();
        Object[] new_list= new Object[length];
        Node temp= head;
        int idx= 0;
        while (temp.next!= null){
            new_list[idx]= temp.element;
            idx++;
            temp= temp.next;
        }
        new_list[length-1]= temp.element;
        return new_list;
    }

    // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
    Object[] reverseList() {
        int length= countNode();
        Object[] new_list= new Object[length];
        Node temp= head;
        int idx= length-1;
        while (temp.next!= null){
            new_list[idx]= temp.element;
            idx--;
            temp= temp.next;
        }
        new_list[0]= temp.element;
        return new_list;
    }

    /* inserts Node containing the given element at the given index
     * Check validity of index.
     */
    void insert(int elem, int idx) {
        if (idx < 0 || idx > countNode()) System.out.println("Invalid Index");
        else {
            if (idx == 0) {Node temp= head; head= new Node(elem, temp);}
            else {
                nodeAt(idx-1).next= new Node(elem, nodeAt(idx));
            }
        }
    }

    /* removes Node at the given index. returns element of the removed node.
   * Check validity of index. return null if index is invalid.
     */
    Object remove(int idx) {
        if (idx < 0 || idx > countNode()) return null;
        Object rem_val= head.element;
        if (idx == 0)  head = head.next;
        else {
            rem_val= nodeAt(idx).element;
            Node temp= nodeAt(idx-1);
            temp.next= temp.next.next;
        }
        return rem_val;
    }

    // Rotates the list to the left by 1 position.
    void rotateLeft() {
        int length= countNode();
        if (length>1){
            Object temp= head.element;
            head= head.next;
            nodeAt(length-2).next= new Node(temp, null);
        }
    }

    // Rotates the list to the right by 1 position.
    void rotateRight() {
        int length= countNode();
        if (length>1){
            Node temp1= nodeAt(length-2), temp2= temp1.next;
            temp1.next= null;
            temp2.next= head;
            head= temp2;
        }
    }
}