package com.java.tasksFromCodewars;

public class Circuit {
    public static void main(String[] args) {
        System.out.println();
        String red = "01101000";
        String blue = "00111000";
        System.out.println(ledSeq(red, blue));
    }

    public static String ledSeq(String redSeq, String blueSeq) {
        StringBuilder result = new StringBuilder();
        Character redPrev = redSeq.charAt(0);
        Character bluePrev = blueSeq.charAt(0);
        boolean redChanged = false;
        boolean blueChanged = false;
        if (bluePrev == '1' && redPrev == '0') {
            result.append('B');
        }
        if (redPrev == '1') {
            result.append('R');
        }
        for (int i = 1; i < redSeq.length(); i++) {
            if(redPrev != redSeq.charAt(i)) {
                redChanged = true;
            }
            if(bluePrev != blueSeq.charAt(i)) {
                blueChanged = true;
            }

            if(redChanged && blueChanged) {
                if(redPrev == '0' && bluePrev == '0') {
                    result.append('R');
                }
                if(redPrev == '0' && bluePrev == '1'){
                    result.append('R');
                }
                if(bluePrev == '0' && redPrev == '1'){
                    result.append('B');
                }
            }
            else if(redChanged) {
                if(bluePrev == '1'){
                    if(redPrev == '1'){
                        if(!(i > 2 && blueSeq.charAt(i - 2) == '1')){
                            result.append('B');
                        }
                    }
                }
                else if(bluePrev == '0'){
                    if(redPrev == '0'){
                        result.append('R');
                    }
                }
            }
            else if(blueChanged) {
                if(redPrev == '1'){
                    if(bluePrev == '1'){
                        if(!(i > 2 && redSeq.charAt(i - 2) == '1')){
                            result.append('R');
                        }
                    }
                }
                else if(redPrev == '0'){
                    if(bluePrev == '0'){
                        result.append('B');
                    }
                }

            }

            redPrev = redSeq.charAt(i);
            bluePrev = blueSeq.charAt(i);
            redChanged = false;
            blueChanged = false;
        }
        return result.toString();
    }
}