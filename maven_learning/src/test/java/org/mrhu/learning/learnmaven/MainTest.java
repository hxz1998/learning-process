package org.mrhu.learning.learnmaven;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void getInteger() {
        Main main = new Main();
        int result = main.getInteger();
        assertEquals(result, 1);
    }
}
