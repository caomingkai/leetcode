


class Solution {
    
    

    
    public int mySqrt(int x) {
        long r = x;
        while ( r*r > x )
            r = (r + x/r) / 2;
        return (int) r;
    }

    
    /*
    // version 1: Binary Search
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {       // no need for long type, using "mid>x/mid"  instead of "mid*mid>x"
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
    */
    
    
    /*
    // version 2:  bit manipulation
    public int mySqrt(int x) {
        long ans = 0;
        long bit = 1l << 16;
        while(bit > 0) {
            ans |= bit;           // 使用当前bit位
            if (ans * ans > x) {
                ans ^= bit;       // 如果使用了当前bit位之后，结果大于0， 那么用异或将刚才加入的bit位消去
            }
            bit >>= 1;
        }
        return (int)ans;
    }   
    */
    

    /*
    // version 2.1 : no need for long, int is ok
    public int mySqrt(int x) {
        int ans = 0; // no need to define as "long"
        int bit = 1 << 15; // no need to define as "long"
        while (bit > 0) {
            ans |= bit;
            if (ans > x / ans) {
                ans ^= bit; 
            }
            bit >>= 1;
        }
        return ans;
    }
    
    */
    
    
    
    
    /*
    target : 8
    half : 4
    
      1      2       3       4
    1^2=1   2^2=4   3^2=9   4^2=16
    
    find the first number whose square is <= target
    
    num[m]^2 <= target  l = m     // 不会错过目标值
    num[m]^2 > target   r = m-1
    
    while( l < r ){               // 最后还剩两个元素时候挑出
    
        m = l + ( r-l+1)/2        // 向右取整，跳出极端情况
    }
    
    return l;                     // return left
    
    */
    /*    
    private int bs(int l, int r, int target ){
        while( l < r ){
            int m = l +(r-l+1)/2;
            int square = m*m;
            if( square <= target )
                l = m;
            else 
                r = m-1;
        }
        return l;
    }
    
    
    */
}




