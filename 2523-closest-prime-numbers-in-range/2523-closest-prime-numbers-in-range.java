class Solution {
    public int[] closestPrimes(int left, int right) {

        List<Integer> primes = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }

        // If there are fewer than 2 primes, return [-1, -1]
        if (primes.size() < 2) {
            return new int[]{-1, -1};
        }

        // Variables to store the closest pair
        int num1 = -1, num2 = -1, minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < primes.size() - 1; i++) {
            int diff = primes.get(i + 1) - primes.get(i);
            if (diff < minDiff) {
                minDiff = diff;
                num1 = primes.get(i);
                num2 = primes.get(i + 1);
            }
        }

        return new int[]{num1, num2};
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}