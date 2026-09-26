// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {

//         Set<List<Integer>> set = new HashSet<>();

//         // for (int i = 0; i < nums.length; i++) {

//         //     for (int j = i + 1; j < nums.length; j++) {

//         //         for (int k = j + 1; k < nums.length; k++) {

//         //             if (nums[i] + nums[j] + nums[k] == 0) {

//         //                 List<Integer> temp =
//         //                     Arrays.asList(
//         //                         nums[i],
//         //                         nums[j],
//         //                         nums[k]
//         //                     );

//         //                 Collections.sort(temp);

//         //                 set.add(temp);
//         //             }
//         //         }
//         //     }
//         // }



//         return new ArrayList<>(set);
//     }
// }

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    ans.add(
                        Arrays.asList(
                            nums[i],
                            nums[left],
                            nums[right]
                        )
                    );

                    left++;
                    right--;

                    
                    while (left < right &&
                           nums[left] == nums[left - 1]) {
                        left++;
                    }

                   
                    while (left < right &&
                           nums[right] == nums[right + 1]) {
                        right--;
                    }

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return ans;
    }
}