package com.example.intenttask;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Random;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    Operations op = new Operations();
    Random rn = new Random();

    final int MIN = 1, MAX = 100;

    @Test
    public void sum() {
        try {
            int int_random_one = this.getRandomNumber();
            int int_random_two = this.getRandomNumber();

            int cal = int_random_one + int_random_two;

            int res = this.op.suma(int_random_one, int_random_two);

            assertEquals(cal, res);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("A number were null");
        }
    }

    @Test
    public void subtraction() {
        try {
            int int_random_one = this.getRandomNumber();
            int int_random_two = this.getRandomNumber();

            int cal = int_random_one - int_random_two;

            int res = this.op.resta(int_random_one, int_random_two);

            assertEquals(cal, res);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("A number were null");
        }
    }

    @Test
    public void divide() {
        Integer int_random_one = this.getRandomNumber();
        Integer int_random_two = this.getRandomNumber();

        float cal = int_random_one.floatValue() / int_random_two.floatValue();

        float res = this.op.division(int_random_one.floatValue(), int_random_two.floatValue());

        assertEquals(cal, res, 0.00005);
    }

    @Test
    public void divisionByZero() {
        Integer int_random_one = this.getRandomNumber();
        Integer int_random_two = this.getRandomNumber();

        try {
            if(int_random_two == 0) {
                throw new ArithmeticException("Division by 0");
            } else {
                float res = int_random_one.floatValue() / int_random_two.floatValue();
                float methodRes = this.op.division(int_random_one.floatValue(), int_random_two.floatValue());

                assertEquals(res, methodRes, 0.00005);
            }
        } catch (ArithmeticException e) {
                throw new ArithmeticException("Division by 0");
        }
    }

    @Test
    public void multiplication() {
        try {
            int int_random_one = this.getRandomNumber();
            int int_random_two = this.getRandomNumber();

            int cal = int_random_one * int_random_two;

            int res = this.op.multiplicacion(int_random_one, int_random_two);

            assertEquals(cal, res);
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Multiply by 0");
        }
    }

    public int getRandomNumber() {
        return  this.rn.nextInt(this.MAX - this.MIN + 1) + this.MIN;
    }
}