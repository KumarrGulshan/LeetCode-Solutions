import java.util.HashSet;

class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        
        return n == 1;
    }
    private int getNext(int num) {
        int totalSum = 0;
        while (num > 0) {
            int digit = num % 10; 
            totalSum += digit * digit; 
            num = num / 10;        
        }
        return totalSum;
    }
}