package girlstock;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

public class DatingSim {
    public static void main(String[] args) {
        int method = 0;
        int numGirl = 0;
        System.out.println("input sorting method 0 = start time, 1 = end time, 2 = time spend");
        Scanner in = new Scanner(System.in);
        method = in.nextInt();
        System.out.println("input number of girls");
        numGirl = in.nextInt();
        System.out.println("input time table");
        SelectGirl stock = new SelectGirl(inputGirlList(numGirl));
        ArrayList<Girl> girl;
        System.out.println(stock);
        stock.sortGirl(method);
        System.out.println(stock);
        girl = stock.scheduling(method);
        for(Girl g : girl){
            System.out.println(g);
        }
        System.out.println("You can date a total of "+SelectGirl.count+" girl(s)");
    }
    
    public static ArrayList<Girl> inputGirlList(int numberOfGirl){
        Scanner in = new Scanner(System.in);
        ArrayList<Girl> stock = new ArrayList<Girl>();
        while(numberOfGirl-- > 0){
            String arr[] = in.nextLine().split(" ");
            stock.add(new Girl(Integer.parseInt(arr[0]), Time.valueOf(arr[1]+":00"), Time.valueOf(arr[2]+":00")));
        }
        return stock;
    }
}
