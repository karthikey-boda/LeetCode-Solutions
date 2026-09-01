class Solution {
    public int numberOfSubstrings(String s) {
        int lastScene[]=new int[3];
        int count=0;
        for(int i=0;i<3;i++){
            lastScene[i]=-1;
        }
        for(int i=0;i<s.length();i++){
            lastScene[s.charAt(i)-'a']=i;
            if((lastScene[0]!=-1 && lastScene[1]!=-1) && (lastScene[2]!=-1)){
                count=count + 1 + Math.min(lastScene[0],Math.min(lastScene[1],lastScene[2]));
            }
        }
        return count;
    }
}    