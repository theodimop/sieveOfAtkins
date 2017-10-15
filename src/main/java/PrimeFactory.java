import java.util.ArrayList;
import java.util.List;

/**
 * Created by theo dimopoulos on 14/10/2017.
 * dimopoulosth.td@gmail.com
 */
class PrimeFactory {

    /**
     * Find primes with Sieve of Atkins algorithm.
     * Complexity of (N / (log log N))
     *
     * @param
     * @return List with primes inside [0,arrayLength]
     */
    public static List<Integer> findPrimes(int numberOfPrimes) {
        if(numberOfPrimes < 2)
            return new ArrayList<>();

        int arrayLength = getNumberInterval(numberOfPrimes);
        boolean[] isPrime = new boolean[arrayLength + 1];
        double sqrt = Math.sqrt(arrayLength);

        for (int x = 1; x <= sqrt; x++) {
            for (int y = 1; y <= sqrt; y++) {
                int n = 4 * x * x + y * y;
                if (n <= arrayLength && (n % 12 == 1 || n % 12 == 5)) {
                    isPrime[n] = !isPrime[n];
                }

                n = 3 * x * x + y * y;
                if (n <= arrayLength && (n % 12 == 7)) {
                    isPrime[n] = !isPrime[n];
                }

                n = 3 * x * x - y * y;
                if (x > y && (n <= arrayLength) && (n % 12 == 11)) {
                    isPrime[n] = !isPrime[n];
                }
            }
        }
        for (int n = 5; n <= sqrt; n++) {
            if (isPrime[n]) {
                int s = n * n;
                for (int k = s; k <= arrayLength; k += s) {
                    isPrime[k] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();

        if (arrayLength > 2)
            primes.add(2);


        if (arrayLength > 3)
            primes.add(3);

        //Java 8 streams are 1000ms slower (no step)  for arrayLength = 2^28
        //Java 9 supports step but keep java8 for compatibility
        int n = 5;
        do {
            if (isPrime[n])
                primes.add(n);
            n += 2;
        } while (n <= arrayLength && primes.size() < numberOfPrimes);

        return primes;
    }

    private static int getNumberInterval(int n) {
        if (n < 168) {
            return 1000;
        } else if (n < 1229) {
            return 10000;
        } else if (n < 9592) {
            return 100000;
        } else if (n < 78498) {
            return 1000000;
        } else if (n < 664579) {
            return 10000000;
        } else if (n < 5761455)
            return 100000000;
        else if (n < 53326267)
            return 1000000000;
        else
            return 1024*1024*1024;
    }
}

