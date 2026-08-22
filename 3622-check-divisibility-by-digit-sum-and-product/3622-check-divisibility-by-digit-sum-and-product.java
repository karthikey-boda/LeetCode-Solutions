class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int mul=1;
        int m=n;
        while(n!=0){
            int digit=n%10;
            sum+=digit;
            mul*=digit;
            n=n/10;
        }
        if(m%(sum+mul)==0){
            return true;
        }
        return false;
    }
}