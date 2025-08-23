
import java.util.Stack;



public class Arrays {

    public static int BinarySearch(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end ) / 2;
            if (arr[mid] == key) {
                return mid; // Key found
            }else if (arr[mid] < key) {
                start = mid + 1; // Search in the right half
            } else {
                end = mid - 1; // Search in the left half
            }
        }
        return -1; // Key not found
    }

    public static void reverseArray(int arr[]) {
        int first = 0;
        int last = arr.length - 1;

        while(first < last) {
            
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;       

            first++;
            last--;
        }
    }

    public static void printPairs(int arr[]) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                System.out.println(arr[i] + ", " + arr[j]);
            }
        }
    }

    public static void maxSubArraySum(int arr[]){

        int curr = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[arr.length];

        prefix[0] = arr[0];

        for(int i=1; i<arr.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        for( int i =0; i< arr.length; i++) {
            int start = i;
            for(int j = i; j < arr.length; j++) {
                int end = j;
                curr = start == 0 ? prefix[end] : prefix[end]-prefix[start-1];
                if(maxSum < curr) {
                    maxSum = curr;
                }
            }
        }
        System.out.println("Max sum = "+ maxSum);
    }

    public static void Kadanes(int arr[]) {
    int ms = arr[0];   // max sum so far
    int cs = arr[0];   // current sum

    for (int i = 1; i < arr.length; i++) {
        cs = Math.max(arr[i], cs + arr[i]); 
        ms = Math.max(ms, cs);
    }

    System.out.println("Our max subarray sum is : " + ms);
    }

    public static int trappedRainwater(int height[])  {
        int n= height.length;
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];

        for(int i=1; i<n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }

        int rightMax[] = new int[n];
        rightMax[n-1] = height[n-1];

        for(int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int trappedWater = 0;
        for(int i=0; i<n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += waterLevel - height[i];
        }

        return trappedWater;
        
    }
     
    public static int buySellStocks( int prices[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i<prices.length; i++) {
            if(buyPrice < prices[i]) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = prices[i];
            }
        }
        return maxProfit;
    }

    public int search(int[] A, int tar) {
        int st = 0, end = A.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (A[mid] == tar) {
                return mid;
            }

            // Left side is sorted
            if (A[st] <= A[mid]) {
                if (A[st] <= tar && tar < A[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }
            }
            // Right side is sorted
            else {
                if (A[mid] < tar && tar <= A[end]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static int majorityElement(int nums[]) {
        int freq = 0 , ans = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            if(freq == 0) {
                ans = nums[i];
            }

            if( ans == nums[i]) {
                freq++;
            } else {
                freq--;
            }
        }
        return ans;
    }

    public static int singleValue(int nums[]) {
        int value=0;
        for(int i=0; i<nums.length; i++) {
            value = value^nums[i];
        }
        return value;
    }

    public static double powXN(double x, int n) {
        if(n ==0 ) return 1.0;
        if(x == 0) return 0.0;
        if(x == 1) return 1.0;
        if(x == -1 && n%2 ==0) return 1.0;
        if(x == -1 && n%2 !=0) return -1.0;
        if(n < 0) {
            x = 1/x;
            n = -n;
        }
        double ans =1;
        while( n>0) {
            if(n %2 == 1) {
                ans = ans * x;
                n = n-1;
            }
            n = n/2;
            x = x*x;
        }
        return ans;
    }

    public static int conatinedWater(int height[]) {
        int maxWater = 0;
        int lp = 0, rp = height.length-1;

        while( lp < rp ) {
            int w = rp - lp;
            int ht = Math.min(height[lp], height[rp]);
            int curr = w * ht;
            maxWater = Math.max(maxWater, curr);

           if(height[lp] < height[rp]) {
            lp++;
           }else {
            rp--;
           }
        }
        return maxWater;
         
    }

    public static int largerRectangle(int height[]) {
        int ans = 0;
        int n = height.length;
        Stack<Integer> s = new Stack<>();

        int rSmaller[] = new int[n];
        for(int i = n-1; i>= 0; i--) {
            while(!s.isEmpty() && height[s.peek()]>=height[i]){
                s.pop();
            }

            rSmaller[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }
        int lSmaller[] = new int[n];
        for(int i = 0; i<n-1; i++) {
            while(!s.isEmpty() && height[s.peek()]>=height[i]){
                s.pop();
            }

            lSmaller[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        for(int i =0; i<n-1; i++) {
            int currArea = height[i] * (rSmaller[i] - lSmaller[i] -1);
            ans = Math.max(ans, currArea);
        }
        return ans;
    } 

    
    public static void main(String[] args) {
       int height[] = {2,1,5,6,2,3};
       System.out.println(largerRectangle(height));
    }
}