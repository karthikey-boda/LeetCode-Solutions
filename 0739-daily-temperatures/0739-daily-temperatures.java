class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st=new Stack<>();
        int n=temperatures.length;
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[i]>temperatures[st.peek()]){
                int curr = st.peek();
                arr[st.pop()]=i-curr;

            }
            st.push(i);
        }
        while(!st.isEmpty()){
                arr[st.pop()]=0;
            }
        return arr;
    }
}