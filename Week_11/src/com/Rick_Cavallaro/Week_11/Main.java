package com.Rick_Cavallaro.Week_11;

abstract class Rectangle{
    abstract public double getWidth();
    abstract public double getHeight();

    //static member class
    static class DoubleRectangle extends Rectangle {
        static double width, height;

        DoubleRectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double getWidth() {
            return width;
        }

        @Override
        public double getHeight() {
            return height;
        }
    }

    static class FloatRectangle extends Rectangle {
        static double width, height;

        FloatRectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double getWidth() {
            return width;
        }

        @Override
        public double getHeight() {
            return height;
        }

        private void Rectangle(){}

        double getArea(){
            return getHeight() * getWidth();
        }
    }


}
/*
 * Created by Rick on 11/8/2016.
 */
public class Main {
    public static void main(String[] args) {

    }
}
