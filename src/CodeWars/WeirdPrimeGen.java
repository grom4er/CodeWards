package CodeWars;

import java.util.ArrayList;
import java.util.TreeSet;


public class WeirdPrimeGen {
    public ArrayList<Integer> createFirstArray(long maxLenght) {
        ArrayList<Integer> firstTempArray = new ArrayList<>();
        firstTempArray.add(7);
        for (int i = 1; i < maxLenght; i++) {
            firstTempArray.add(firstTempArray.get(i - 1) + gcd(i + 1, firstTempArray.get(i - 1)));
        }
        return firstTempArray;
    }

    static int gcd(int fNumb, int sNumb) {
        return (sNumb == 0) ? fNumb : gcd(sNumb, fNumb % sNumb);
    }

    ArrayList<Integer> createSecondArray(long size, ArrayList<Integer> firstArray) {
        ArrayList<Integer> secondTempArray = new ArrayList<>();
        secondTempArray.add(1);
        for (int i = 1; size > i; i++) {
            secondTempArray.add(firstArray.get(i) - firstArray.get(i - 1));
        }
        return secondTempArray;
    }

    public static long countOnes(long n) {
        ArrayList<Integer> firstArray;
        WeirdPrimeGen w = new WeirdPrimeGen();
        firstArray = w.createFirstArray(n);
        ArrayList<Integer> secondArray;
        secondArray = w.createSecondArray(n, firstArray);

        long res = 0;
        for (long tempCheck : secondArray) {
            if (tempCheck == 1) res++;
        }
        return res;
    }

    static int tempCheck(int fNumb, int count) {
        return fNumb + gcd(count + 1, fNumb);
    }


    public static long maxPn(long n) {
        TreeSet<Integer> array = new TreeSet<>();
        int fNumb = 7;
        int count = 1;
        while (array.size() != n) {
            int sNumb = tempCheck(fNumb, count);
            count++;
            int tempRes = sNumb - fNumb;
            if (tempRes > 1) {
                array.add(tempRes);
            }
            fNumb = sNumb;
        }
        return (long) array.last();
    }

    public static int average(ArrayList<Integer> array) {
        int sum = 0;
        for (Integer i : array) {
            sum += i;
        }
        return sum / array.size();
    }

    public static int anOverAverage(long n) {
        ArrayList<Integer> array = new ArrayList<>();
        int fNumb = 7;
        int count = 1;
        while (array.size() != n) {
            int sNumb = tempCheck(fNumb, count);
            count++;
            int tempRes = sNumb - fNumb;
            if (tempRes > 1) {
                array.add(sNumb / count);
            }
            fNumb = sNumb;
        }
        return average(array);
    }
}

// test branch


