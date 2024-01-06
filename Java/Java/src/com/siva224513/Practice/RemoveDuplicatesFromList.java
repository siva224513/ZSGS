
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicatesFromList {
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        RemoveDuplicatesFromList r=new RemoveDuplicatesFromList();
        System.out.println("Enter the size of the list");
        int n=scan.nextInt();
        ArrayList<Integer> list =new ArrayList<>(n);
        System.out.println("Enter "+n+" elements");
        for(int i=0;i<n;i++){
            list.add(scan.nextInt());
        }
        System.out.println("Before removing duplicates");
        System.out.println(list);
        System.out.println("After removing duplicates");
        r.removeDuplicate(list);
        
    }

    private void removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> result =new ArrayList<>();
        for(int i:list){
            if(!result.contains(i)){
                result.add(i);
            }
        }
        System.out.println(result);
        System.out.println();
        
    }
}
