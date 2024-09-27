package com.automation.steps;

import com.automation.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

import javax.swing.plaf.PanelUI;

public class Hooks {
    @Before
    public void setUp(){
        ConfigReader.initConfig();
        RestAssured.baseURI="https://freefakeapi.io/api";
    }

}
