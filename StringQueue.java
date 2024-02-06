public class StringQueue {

    String[] q;
    int length;


    StringQueue (int size){
        q = new String[size];
        length = 0;
    }

    public void enqueue(String s){
        //2 3 5
        if(length >= q.length){
            System.out.println("The queue is full");
            return;
        }
        q[length] = s;
        length++;

    }

    public String dequeue(){
        String local = q[0];
        int i;

        for (i = 0; i < length-1; i++){
            q[i] = q[i+1];
        }
        q[i] = "";
        length --;
        return local;
    }


    public void myPrint(){
        int i;
        System.out.printf("[");
        for(i=0; i < length-1; i++){
            System.out.printf(q[i] + ", ");

        }
        System.out.printf(q[i]);
        System.out.printf("]\n");
    }


    public static void main(String[] args){
        StringQueue myQ = new StringQueue(6);
        myQ.enqueue("Aaron");
        myQ.enqueue("Nikolo");
        myQ.enqueue("Ryan");
        myQ.enqueue("Lucas");
        myQ.enqueue("Devin");

        myQ.enqueue("Mustaph");
        myQ.myPrint();
    }
}

//look up circular queue methods