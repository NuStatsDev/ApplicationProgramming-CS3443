
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static int kthSmallest(Integer [] arr, int k) {
        // Sort the given array
        Arrays.sort(arr);
        // Return k'th element in
        // the sorted array
        return arr[k-1];
    }

    public static int kthLargest(Integer [] arr, int k) {
        // Sort the given array
        Arrays.sort(arr);
        // Return k'th element in
        // the sorted array
        return arr[(arr.length )-k ];
    }

    public static void main(String[] args){
        String[] words = {  "A","yes", "lint", "code",
                            "yes", "code", "baby",
                            "you", "baby", "chrome",
                            "safari", "B","lint", "code",
                            "body", "lint", "code","A","A","B","D","D","E" };

        kMost sortStringArry = new kMost();
        Integer arr[] = new Integer[]{12,3,5,16,12,14,1,22,13,10,9,19};
        int k =6;
        String kthName ="";



        if(k%10==1 && k !=11){
            kthName = k+"'st'";
        }
        else if(k%10==2 && k != 12){
           kthName = k+"'nd";
        }
        else if(k%10==3 && k != 13){
            kthName = k+"'rd";
        }
       else {
            kthName = k+"'th";
        }



       System.out.println( kthName+" smallest Integer:" + kthSmallest(arr, k));
        System.out.println( kthName+" largest Integer: " + kthLargest(arr, k) );
        System.out.print("\n"+ kthName+ " most occurring String: ");
        System.out.println(sortStringArry.topKFrequent(words,k));


    }

}
