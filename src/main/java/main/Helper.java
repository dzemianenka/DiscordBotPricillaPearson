package main;

public class Helper {
    //    Склонение сущиствительных с числительными
    public int plurality(int n) {
        n = n % 100;
        if (n == 0 || n > 10 && n < 20) return 0;
        int n1 = n % 10;
        if (n1 == 1) return 1;
        if (n1 > 1 && n1 < 5) return 2;
        return 0;
    }
}
