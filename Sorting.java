


public class Sorting {
    public static void printArray(int arr[]) {
        for(int i=0; i<arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }

    public static void bubbleSort(int arr[]) {
        int n = arr.length;

       for(int turn =0; turn<n-1; turn++) {
       int swap = 0;
            for (int j = 0; j < n - 1 - turn; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap++;
                }
            }
            System.out.println( "swap = "  + swap );
            if (swap == 0) {
                return;
            }
       }
    }

    public static void selectionSort(int arr[]) {
        for(int i =0; i<arr.length-1; i++) {
            int minPos = i;
            for(int j = i+1; j<arr.length; j++) {
                if(arr[minPos] > arr[j]) {
                    minPos = j;
                }  
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    public static void insertionSort(int arr[]) {
        for(int i=1; i<arr.length; i++) {
            int curr = arr[i];
            int prev = i-1;

            while(prev >=0 && arr[prev] > curr) {
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }

    public static void countingSort(int arr[]) {
         int largest = Integer.MIN_VALUE;
         for(int i=0; i<arr.length; i++) {
            largest = Math.max(largest, arr[i]);
         }

         int count[] = new int[largest+1];
         for(int i=0; i<arr.length; i++) {
            count[arr[i]]++;
         }

         int j =0;
         for(int i=0; i<count.length; i++ ){
            while(count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
         }
    }

    public static void merge2SortedArrays(int nums1[], int m, int nums2[], int n) {
        int idx = m + n -1 , i = m - 1 , j = n-1;
        while( i >= 0 && j >= 0) {
            if(nums1[i] >= nums2[j]) {
                nums1[idx] = nums1[i];
                idx--;
                i--;
            } else {
                nums1[idx] =  nums2[j];
                idx--;
                j--;
            }
        }
        while(j>=0) {
            nums1[idx] = nums2[j];
            idx--;
            j--;
        }
    }

    public static void sort012(int arr[]) {
        // optimal 
        int count[] = new int[arr.length];
        for(int i =0; i<arr.length; i++) {
            count[arr[i]]++;
        }

        int j =0;
         for(int i=0; i<count.length; i++ ){
            while(count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
         }
    }

    public static void DNF(int arr[]) {
        int mid = 0, high = arr.length-1 , low =0;

        while(mid <= high) {
            if(arr[mid] == 0) {
                int temp = arr[mid];
                arr[mid] = arr[low];
                arr[low] = temp;
                low++;
                mid++;
            } else if( arr[mid] == 1) {
                mid++;
            } else {
                int temp = arr[mid];
                arr[mid] =  arr[high];
                arr[high] = temp;
                high--;
            }
        }
    }

    public static void nextPermutation(int nums[]) {
    int pivot = -1, n = nums.length;

    // Step 1: Find pivot
    for (int i = n - 2; i >= 0; i--) {
        if (nums[i] < nums[i + 1]) {
            pivot = i;
            break;
        }
    }

    // Step 2: If no pivot, reverse the whole array
    if (pivot == -1) {
        reverse(nums, 0, n - 1);
        return;
    }

    // Step 3: Find element just larger than pivot
    for (int k = n - 1; k > pivot; k--) {
        if (nums[k] > nums[pivot]) {
            swap(nums, k, pivot);
            break;
        }
    }

    // Step 4: Reverse suffix (right part after pivot)
    reverse(nums, pivot + 1, n - 1);
}

    private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

    private static void reverse(int[] nums, int i, int j) {
    while (i < j) {
        swap(nums, i, j);
        i++;
        j--;
    }
}

     public static void mergeIntervals(int intervals[][] ) {
   // solve this after
    
}

 public static int[] productExceptSelf(int nums[]) {
    int n = nums.length;
    int ans[] = new int[n];
    
    ans[0] = 1;
    for(int i=1; i<n; i++) {
        ans[i] = ans[i-1] * nums[i-1];
    }

    int suffix=1;
    for(int i=n-2; i>=0; i--) {
        suffix *= nums[i+1];
        ans[i] *= suffix;
    }

    return ans;
 }

    public static double findMedian(int nums1[], int nums2[] ) {
            int n1 = nums1.length , n2 = nums2.length;
            if(n1> n2) return findMedian(nums2, nums1);
            int low = 0 , high = n1;
            int left = (n1 + n2 +1) / 2;
            int n = n1 + n2;
            while(low <= high) {
                int mid1 = (low + high)/2;
                int mid2 = left - mid1;
                int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
                int r1 = Integer.MAX_VALUE , r2 = Integer.MAX_VALUE;
                if(mid1 <n1) r1 = nums1[mid1];
                if(mid2 <n2) r2 = nums2[mid2];
                if(mid1 -1 >=0) l1 = nums1[mid1-1];
                if(mid2 -1 >=0) l2 = nums2[mid2-1];

                if(l1 <= r2 && l2 <=r1) {
                    if(n % 2 ==1) return Math.max(l1, l2);
                    return ( (double)(Math.max(l1, l2) + Math.min(r1, r2)) ) / 2.0;
                } else if(l1 > r2) {
                    high = mid1-1;
                } else {
                    low = mid1 +1;
                }
            }
        return -1;
    }
   
    public static void main(String[] args) {
        int nums1[] = {1,2};
        int nums2[] = {3,4};
       
        System.out.println(findMedian(nums1, nums2));
    }
}
