package com.example.intenttask;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

public class Addition {
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
    public void addition() {
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

    public int getRandomNumber() {
        return  this.rn.nextInt(this.MAX - this.MIN + 1) + this.MIN;
    }
}
