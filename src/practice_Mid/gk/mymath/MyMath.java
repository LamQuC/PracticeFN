package practice_Mid.gk.mymath;

public class MyMath {
    public static void main(String[] args){

    }
    public static double cos(double x,double terms){
        double result = 1.0;
        double term = 1.0;
        for (int i = 1; i <= terms ; i ++){
            term *= -Math.pow(x,2*i-1)/(2*i-1);
            result += term;
        }
        return result;

    }
    public static int factorial(int x){
        int result = 1;
        for (int i = 1; i <= x ; i ++){
            result *= i;
        }
        return result;
    }

    public static double exp(double x, double terms){
        double result = 1.0;
        double term = 1.0;
        for (int i = 1; i <= terms ; i ++){
            term *= x/i;
            result += term;
        }
        return result;
    }
    public static String decimalTo(String number, int outRadix){
        long result = 0;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            int digit = Character.digit(c, 10);
            result = result * outRadix + digit;
        }
        String res = String.valueOf(result);
        return res;
    }
    public static String toDecimal(String number,int inRadix){
        long result = 0;
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            int digit = Character.digit(c, inRadix);
            result = result * inRadix + digit;
        }
        String res = String.valueOf(result);
        return res;
    }
}
