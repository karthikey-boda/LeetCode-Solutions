class Solution {
    public int smallestIndex(int[] nums) {

        int n=nums.length;
        for(int i=0;i<n;i++){
            int sum=0;
            int x=nums[i];
            while(x>0){
                int digit=x%10;
                sum+=digit;
                x=x/10;
            }
            if(sum==i){
                return i;
            }
        }
        return -1;
    }
}