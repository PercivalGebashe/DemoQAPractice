package com.github.percivalgebashe.hooks;

import com.github.percivalgebashe.pages.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BaseClass {

    @Before
    public void setup(){
        setUpDriver();
    }

    @After
    public void teardown(){
        tearDown();
    }
}
