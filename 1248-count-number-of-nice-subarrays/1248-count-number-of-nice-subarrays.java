class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==1){
                nums[i]=1;
            }
            else{
                nums[i]=0;
            }
        }
        return less(nums,k)-less(nums,k-1);
    }
    public int less(int nums[],int k){
        if(k<0){
            return 0;
        }
        int l=0,r=0,sum=0,cnt=0;
        while(r<=nums.length-1){
            sum+=(nums[r]);
            while(sum>k){
                sum-=(nums[l]);
                l++;
            }
            cnt+=r-l+1;
            r++;
        }
        return cnt;
    }
}