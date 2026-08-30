class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        int s1=source[0],s2=source[1];
        int t1=target[0],t2=target[1];
        if(s1==t1 && s2==t2){
            return 0;
        }
        if((s1+s2)%2!=(t1+t2)%2){
            return -1;
        }
        if((s1-s2 == t1-t2) || (s1+s2 == t1+t2)){
            return 1;
        }
        return 2;
    }
}