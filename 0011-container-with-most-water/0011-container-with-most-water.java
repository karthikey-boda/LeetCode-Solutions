class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int Area=Integer.MIN_VALUE;
        while(i<j){
            int currArea=Math.min(height[i],height[j])*(j-i);
            Area=Math.max(Area,currArea);
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return Area;
    }
}