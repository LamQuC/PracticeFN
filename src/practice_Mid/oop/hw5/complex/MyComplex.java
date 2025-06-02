package practice_Mid.oop.hw5.complex;

public class MyComplex {
    private double real = 0.0;
    private double imag = 0.0;

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }
    public void setValue(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        if (this.imag < 0){
            imag = imag * -1;
            return real - imag + "i";
        }
        return real + imag + "i";
    }
    public boolean isReal(){
        if (this.imag == 0){
            return true;
        }
        return false;
    }
    public boolean isImaginary(){
        if (this.real == 0){
            return true;
        }
        return false;

    }
    public boolean equals(double real, double imag){
        if (this.real == real && this.imag == imag){
            return true;

        }
        return false;
    }
    public boolean equals(MyComplex another){
        if ( this.real == another.real && this.imag == another.imag){
            return true;
        }
        return false;
    }
    public double magnitude(){
        return Math.sqrt(real*real + imag * imag);
    }
    public MyComplex addInto(MyComplex right){
        this.real = right.real + real;
        this.imag = right.imag + imag;
        return this;
    }
}