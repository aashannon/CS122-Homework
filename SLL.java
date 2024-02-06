public class SLL {
    Node head;
    Node tail;
    int size;


    SLL(){
        head = new Node(-100);
        tail = new Node(-100);
        head.next = tail;
    }

    void addToFront(int i){
        Node n = new Node(i);
        n.next = head.next;
        head.next = n;
        size++;
    }

    void addToBack(int i){
        Node cur = head;
        Node n = new Node(i);
        n.next = tail;
        while(cur.next != tail){
            cur = cur.next;
        }

        cur.next = n;
        size++;

    }

    int findX(int x){
        int curPosition = 0;
        Node cur = head; //references the beginning of the list
        while (cur.next != null){
            if(cur.data == x){
                return curPosition;
            }

            cur = cur.next;
            curPosition++;
        }
        return -1;
    }

    public static void main(String[] args){
        SLL myList = new SLL();
        myList.addToFront(2);
        myList.addToFront(5);
        myList.addToFront(4);
        myList.addToFront(3);
        myList.addToFront(8);

        System.out.println(myList.findX(2));
    }
}
