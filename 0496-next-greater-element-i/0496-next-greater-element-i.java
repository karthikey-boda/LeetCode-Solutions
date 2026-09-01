class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int arr2[] = GE(nums2, m);
        for (int i = 0; i < m; i++) {
            map.put(nums2[i], arr2[i]);
        }
        int arr3[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr3[i] = map.get(nums1[i]);
        }
        return arr3;
    }

    public int[] GE(int[] arr, int n) {
        Stack<Integer> st = new Stack<>();
        int arr2[] = new int[n];
        for (int i = 0; i < n; i++) {  
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                arr2[st.pop()] = arr[i];
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            arr2[st.pop()] = -1;
        }
        return arr2;
    }
}