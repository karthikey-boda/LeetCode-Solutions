class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // int prefix=0;
        // int count=0;
        // HashMap<Integer,Integer> map=new HashMap<>();
        // map.put(0,1);
        // for(int i=0;i<nums.length;i++){
        //     prefix+=nums[i];
        //     if(map.containsKey(prefix-goal)){
        //         count+=map.get(prefix-goal);
        //     }
        //     map.put(prefix,map.getOrDefault(prefix,0)+1); 
        // }
        // return count;
        return lessThanOrEqual(nums,goal)-lessThanOrEqual(nums,goal-1);

    }
    public int lessThanOrEqual(int nums[],int goal){
        int left=0,right=0,cnt=0,sum=0;
        if(goal<0){
            return 0;
        }
        while(right<=nums.length-1){
            sum+=nums[right];
            while(sum>goal){
                sum-=nums[left];
                left++;
            }
            cnt+=right-left+1;
            right++;
        }
        return cnt;
    }
}