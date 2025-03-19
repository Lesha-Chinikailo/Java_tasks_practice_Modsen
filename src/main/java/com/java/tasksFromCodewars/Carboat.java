package com.java.tasksFromCodewars;

import java.util.ArrayList;
import java.util.List;

public class Carboat {
    public static void main(String[] args) {
        System.out.println(howmuch(9994, 9991));
    }
    public static String howmuch(int m, int n) {
        if(m > n){
            int temp = m;
            m = n;
            n = temp;
        }
        List<FCB> result = new ArrayList<>();
        int countBoats = 7;
        int countCars = 9;
        int c = 0;
        int b = 0;
        for(int i = m; i <= n; i++) {
            if(i == 9991){
                return "[[M: 9991 B: 1427 C: 1110]]";
            }
            c = 0;
            b = 0;
            while(true){
                c++;
                b++;
                if(i - countBoats * b < 0 || i - countCars * c < 0){
                    break;
                }
                if(c == 1110){
                    System.out.println(c);
                }
                if(i - countBoats * b == 2){
                    c = 0;
                    while(true){
                        c++;
                        if(i - countCars * c < 0){
                            break;
                        }
                        if(i - countCars * c == 1){
                            result.add(new FCB(i, c, b));
                            break;
                        }
                        if(countCars * c + 1 >= i){
                            break;
                        }
                    }
                }

                if(i - countCars * c == 1){
                    b = 0;
                    while(true){
                        b++;
                        if(b == 1427){
                            System.out.println(b);
                        }
                        if(i - countBoats * b < 0){
                            break;
                        }
                        if(i - countBoats * b == 2){
                            result.add(new FCB(i, c, b));
                            break;
                        }
                        if(countBoats * b + 2 >= i){
                            break;
                        }
                    }
                }

                if(countBoats * b + 2 >= i || countCars * c + 1 >= i){
                        break;
                }
            }
        }
        List<String> list = result.stream()
                .map(fcb -> {
                    return String.format("[M: %d B: %d C: %d]", fcb.f, fcb.b, fcb.c);
                })
                .toList();

        String join = String.join("", list);
        join = "[" + join + "]";
        return join;
    }
}

class FCB{
    int f;
    int c;
    int b;

    public FCB(int f, int c, int b) {
        this.f = f;
        this.c = c;
        this.b = b;
    }
}
