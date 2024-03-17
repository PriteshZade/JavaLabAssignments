public class SY2022BIT035 {
    public static void main(String args[]) {
        String Numbers[] = new String[10000]; // Store as strings
        SY2022BIT035 m= new SY2022BIT035();
        m.generateRandomRegNo(Numbers);
        m.countPrimeNumber(Numbers);
        
    }
    
    public void generateRandomRegNo(String[] Numbers) {
        for (int i = 0; i < Numbers.length; i++) {
            Numbers[i] = generatenumber();
        }
    }
    
    public String generatenumber() {
        long time = System.nanoTime();
        return String.format("%07d", (time % 9999999) + 1);
    }
    
    public int countPrimeNumber(String[] Numbers) {
        int count = 0;
        for (int i = 0; i < Numbers.length; i++) {
            if (isPrime(Long.parseLong(Numbers[i]))) {
                count++;
            }
        }
        return count;
    }
    
    public boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
