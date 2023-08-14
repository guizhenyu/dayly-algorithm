package com.gzy.algo.day20230812;

public class IntegerToRoman {

    /**
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     *
     *
     * Constraints:
     *
     * 1 <= num <= 3999
     * @param num
     * @return
     */
    public String intToRoman(int num) {
        StringBuffer sb = new StringBuffer();

        int pow = 3;

        while (pow >= 0){
            int numeral = (int)(num / Math.pow(10, pow));

            if (numeral > 0){
                transform(sb, pow, numeral);
            }

            num = (int)(num % Math.pow(10, pow));
            pow--;
        }
        return sb.toString();

    }


    public void transform(StringBuffer sb, int pow, int numeral){
        switch (pow){
            case 3:
                for (int i = 0; i < numeral; i++){
                    sb.append("M");
                }
                break;
            case 2:
                appendRole(sb, numeral, 'C', 'D', 'M');
                break;
            case 1:
                appendRole(sb, numeral, 'X', 'L', 'C');
                break;
            case 0:
                appendRole(sb, numeral, 'I', 'V', 'X');
                break;
        }
    }

    public void appendRole(StringBuffer sb, int numeral, char basic, char mid, char next){
        if (numeral == 9){
            sb.append(basic);
            sb.append(next);
        }else if(numeral >= 5 && numeral <= 8){
            sb.append(mid);
            for (int i = 5; i < numeral; i++){
                sb.append(basic);
            }
        }else if(numeral == 4){
            sb.append(basic);
            sb.append(mid);
        }else {
            for (int i = 0; i < numeral; i++){
                sb.append(basic);
            }
        }
    }


    public static void main(String[] args) {
        IntegerToRoman it = new IntegerToRoman();
        System.out.println(it.intToRoman(1994));


    }
}
