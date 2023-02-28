//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    public void swap(int i, int j, int[][] map){
        int[] temp = map[i];
        map[i] = map[j];
        map[j] = temp;
    }
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int[][] map = new int[nums.length][2];
        
        for(int i=0; i<nums.length; i++){
            map[i][0] = nums[i];
            map[i][1] = i;
        }
        
        Arrays.sort(map, new Comparator<int[]>(){
            public int compare(int[] a1, int[] a2){
                return a1[0] - a2[0];
            }
        });
        
        int i = 0;
        int count = 0;
        while(i<nums.length){
            
            if(map[i][1] != i){
                swap(i, map[i][1], map);
                count++;
            }else{
                i++;
            }
            
        }
        
        return count;
        
    }
}