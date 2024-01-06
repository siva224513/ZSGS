class A extends Thread{
    A(String name){
        super(name);
    }
   public  void run(){
       for(int i=1;i<=3;i++){
        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.print(e);
        }
        System.out.println(i+" ");
       }
    }
}
public class ThreadJoin{
    public static void main(String args[]) throws InterruptedException{
        A t1 = new A("one");
        A t2 = new A("two");
        A t3 = new A("three");
        t1.start();  
        t1.join(500);
        t2.start();
        // t2.join();
        t3.start();
       
    }
}