/**
 * Created by dj_di_000 on 15/10/2017.
 */

import org.junit.Test;
import java.util.List;
import java.util.stream.IntStream;


import static org.junit.Assert.*;

public class PrimesTest {

    @Test
    public void numberOfPrimesTest() {
        int requestedPrimes = 10;
        List<Integer> primes = PrimeFactory.findPrimes(requestedPrimes);

        assertEquals(primes.size(), requestedPrimes);
    }

    @Test
    public void negativeNumberOfPrimesTest() {
        int requestedPrimes = -1;
        List<Integer> primes = PrimeFactory.findPrimes(requestedPrimes);

        assertTrue(primes.isEmpty());
    }

    @Test
    public void firstTenPrimesTest() {
        List<Integer> primes = PrimeFactory.findPrimes(10);
        Integer[] firstTenPrimes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        IntStream.range(0, 10).forEach(i -> {
            assertEquals(primes.get(i), firstTenPrimes[i]);
        });
    }

    @Test
    public void checkIfPrimesTest() {
        int N = 1024*128;
        List<Integer> primes = PrimeFactory.findPrimes(N);

        IntStream.range(0, N).forEach(i -> {
            assertTrue(isPrime(primes.get(i)));
        });

    }

    //Not efficient check keep parameter low ...
    private boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }


}
