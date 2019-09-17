package Inheritance;

import java.text.Format;

public class RationalNumber {
    private int numerator, denominator;

    RationalNumber(int num, int den){
        this.denominator = den;
        this.numerator = num;
        this.Simplify();
    }

    private void Simplify(){
        int sign = (int) (Math.signum((double) numerator) * Math.signum((double) denominator));
        int i = (int) (double) Math.min(numerator, denominator);
        System.out.println(i);
        for(; i > 1; i--) {
            System.out.println(numerator % i == 0 && denominator % i == 0);
            if (numerator % i == 0 && denominator % i == 0)
                break;
        }

        numerator = Math.abs(numerator) / i * sign;
        denominator = Math.abs(denominator) / i;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        this.Simplify();
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
        this.Simplify();
    }

    public String toString() {
        if(denominator == 0) {
            return "NaN";
        } else if(denominator == 1){
            return String.format("%d\n", numerator, denominator);
        } else {
            return String.format("%d/%d\n", numerator, denominator);
        }

    }
}
