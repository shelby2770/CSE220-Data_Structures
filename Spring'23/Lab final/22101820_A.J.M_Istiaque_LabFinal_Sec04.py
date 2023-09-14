class Node:
  def __init__(self, e, n):
    self.element = e
    self.next = n

class LinkedList:

    def __init__(self, a):
        if type(a) == list:
            self.head = Node(a[0], None)
            shelby = self.head
            for i in range(1, len(a)):
                new_node = Node(a[i], None)
                shelby.next, shelby = new_node, new_node
        else:
            self.head = a


def id_Generator(l1, l2, l3):
    res= None
    pointer2= l2.head
    while pointer2.next!= None:
        if res== None:
            res= LinkedList([pointer2.element])
        else:
            temp= pointer2.next
            new_node= Node(pointer2.next.element, None)
            new_node.next= res.head
            res.head= new_node
            pointer2= pointer2.next

    res4l2= None
    pointer3= l3.head
    while pointer3.next!= None:
        if res4l2== None:
            res4l2= LinkedList([pointer3.element])
        else:
            temp= pointer3.next
            new_node= Node(pointer3.next.element, None)
            new_node.next= res4l2.head
            res4l2.head= new_node
            pointer3= pointer3.next


    k= res.head
    while k.next!= None:
        k= k.next

    new_point1= l1.head
    new_point3= res4l2.head

    while new_point1!= None and new_point3!= None:
        calc= (new_point1.element+new_point3.element)%10
        new_node= Node(calc, None)
        k.next= new_node
        k= k.next
        new_point1= new_point1.next
        new_point3= new_point3.next
    return res

#sample input 1
a1= [1,3,2,4] #any random number in between 0-9
a2= [0,3,2,2] #first 4 digits of student id are given in reverse order
a3= [2,0,0,5] #first make this array reverse. Then add ith element with a1ith element. This will give last 4 digits of student id

#sample input 2
# a1= [7,1,2,3]
# a2= [7,5,0,2]
# a3= [6,2,1,4]
l1= LinkedList(a1)
l2= LinkedList(a2)
l3= LinkedList(a3)
merge_res= id_Generator(l1,l2,l3)


#for checking
def traverseList(obj):
    temp = obj.head
    while temp != None:
        print(temp.element)
        temp = temp.next
traverseList(merge_res)
