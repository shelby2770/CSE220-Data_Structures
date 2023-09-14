package Lab04_22101820_4;
public class DoublyList{
    Node head;
    /* First Constructor:
    * Creates a linked list using the values from the given array. head will refer
    * to the Node that contains the element from a[0]
    */
    DoublyList(Object[] a){
        head = new Node(a[0], null, null);
        Node shelby= head;
        for(int i= 1; i<a.length; ++i){
            Node new_node = new Node(a[i], null, null);
            Node temp= shelby;
            shelby.next= new_node;
            shelby= new_node;
            shelby.prev= temp;
        }
        shelby.next=head;
        head.prev=shelby;
    }


    /* Counts the number of Nodes in the list */
    int countNode(){
        Node temp = head;
        int count = 1;
        while(temp.next!=head){
            temp = temp.next;
            count++;
        }
        return count;
    }

    /* prints the elements in the list */
    void forwardprint() {
        Node temp;
        for (temp = head; temp.next != head; temp= temp.next) {
            System.out.print(temp.element + ", ");
        }
        System.out.println(temp.element);
    }

    void backwardprint(){
        Node temp = head;
        for(temp = head.prev; temp!=head; temp= temp.prev){
            System.out.print(temp.element+", ");
        }
        System.out.println(temp.element);
    }



    // returns the reference of the Node at the given index. For invalid index return null.
    Node nodeAt(int idx){
        if (idx < 0 || idx >= countNode()){
            return new Node("Invalid idx", null, null); //if I return None, then for any invalid index, myNode.element will show an error.
        }
        int pointer= 0;
        Node shelby = head;
        for (;shelby!= null; shelby= shelby.next) {
            if (pointer == idx) return shelby;
            pointer++;
        }
        return shelby;
    }



    /* returns the index of the Node containing the given element.
    if the element does not exist in the List, return -1.
    */
    int indexOf(Object elem){
        int length= countNode();
        Node temp= head;
        int idx= 0;
        while (temp.element!= elem){
            temp= temp.next;
            idx++;
            if (idx== length) return -1;
        }
        return idx;
    }


    /* inserts Node containing the given element at the given index
    * Check validity of index.
    */
    void insert(Object elem, int idx){
        int length= countNode();
        if (idx<0 || idx> length) System.out.println("Invalid index");
        else{
            Node new_node= new Node(elem, null, null);
            Node temp_1= idx== 0?nodeAt(length-1):nodeAt(idx-1);
            Node temp_2= temp_1.next;
            temp_1.next= new_node;
            new_node.next= temp_2;
            new_node.prev= temp_1;
            temp_2.prev= new_node;
            if (idx== 0) head= new_node;
        }
    }


    /* removes Node at the given index. returns element of the removed node.
    * Check validity of index. return null if index is invalid.
    */
    Object remove(int idx){
        int length= countNode();
        if (idx<0 || idx> length) return null;

        Node rem_node= nodeAt(idx);
        Object rem_val= rem_node.element;
        Node temp_1= rem_node.prev, temp_2= rem_node.next;
        rem_node.prev= null;
        rem_node= null;
        temp_1.next= temp_2;
        temp_2.prev= temp_1;
        if (idx== 0) head=  temp_2;
        return rem_val;
    }
}
