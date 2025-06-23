package top.panson.top100like.dp;

/**
 * @author Panson
 * @create 2025-06-23
 */
public class L845 {

    class Solution {
        public int longestMountain(int[] arr) {
            int n = arr.length;
            int maxLength = 0;
            for(int i = 1; i < n - 1; i++) {
                int left = i;
                int right = i;
                int curLength = 0;
                if(arr[left] > arr[left - 1] && arr[right] > arr[right + 1]) {
                    curLength = 1;
                    while(left - 1 >= 0 && arr[left] > arr[left - 1] ) {
                        left--;
                        curLength++;
                    }
                    while(right + 1 < n && arr[right] > arr[right + 1]) {
                        right++;
                        curLength++;
                    }
                }
                maxLength = Math.max(maxLength, curLength);
            }
            return maxLength;
        }
    }
}
