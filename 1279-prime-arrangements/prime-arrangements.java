class Solution {
    private static final int MOD = 1000000007;

    public int numPrimeArrangements(int n) {
        int primeCount = countPrimes(n);
        int nonPrimeCount = n - primeCount;
        long result = (factorial(primeCount) * factorial(nonPrimeCount)) % MOD;
        return (int) result;
    }

    
    private int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    
    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Modular factorial
    private long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res = (res * i) % MOD;
        }
        return res;
    }
}
