package com.dephillipsdesign.logomatic;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class LogOMaticTest {

    @Test
    public void getLoggerShouldReturnAValidLoggerOnSunJdk() {
        assertThat(LogOMatic.getLogger(LogOMaticTest.class), isA(Logger.class));
    }

}
