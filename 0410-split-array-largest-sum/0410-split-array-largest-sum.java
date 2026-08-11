class Solution {
    public int splitArray(int[] nums, int k) {
        return findPages(nums,k);
    }
    public int findPages(int[] nums, int m) {
        int max=nums[0];
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(max<nums[i]){
                max=nums[i];
            }
        }
        int low=max;
        int high=sum;
        while(low<=high){
            int mid=low+(high-low)/2;
            int ans=check(nums,mid);
            if(ans>m){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return low;
    }
    public static int check(int nums[],int mid){
        int boys=1;
        int pages=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]+pages<=mid){
                pages+=nums[i];
            }
            else{
                boys++;
                pages=nums[i];
            }
        }
        return boys;
    }
}