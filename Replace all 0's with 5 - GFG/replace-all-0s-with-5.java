//{ Driver Code Starts
import java.util.Scanner;
import java.lang.Math;

class Convert_To_Five {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            System.out.println(new GfG().convertfive(N));
            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
    int convertfive(int num) {
        // Your code here
        
        if(num == 0){
            return 0;
        }
        
        int digit = num % 10;
        if(digit == 0){
            digit = 5;
        }
        
        return digit + (10 * convertfive(num/10));
    }
}