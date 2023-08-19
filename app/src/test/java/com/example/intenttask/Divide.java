package com.example.intenttask;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class Divide {
    private Operations op;
    private Random rn;

    final int MIN = 1, MAX = 100;

    @Before
    public void setUp(){
        op = new Operations();
        rn = new Random();
    };

    @Test
    public void operationNotNull() {
        assertNotNull(op);
        assertNotNull(rn);
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

    public int getRandomNumber() {
        return  this.rn.nextInt(this.MAX - this.MIN + 1) + this.MIN;
    }
}
