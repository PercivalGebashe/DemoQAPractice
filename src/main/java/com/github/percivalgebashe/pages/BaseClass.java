package com.github.percivalgebashe.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static Properties properties;


    public void setUpDriver(){
        loadProperties();
        String browser = getProperties("browser");
        String headless = getProperties("headless").toLowerCase();

        switch (browser.toLowerCase()){
            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments(headless);
                driver = new EdgeDriver(edgeOptions);
                break;
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(headless);
                driver = new ChromeDriver(chromeOptions);
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(
                Integer.parseInt(getProperties("implicitWait"))));
        wait = new WebDriverWait(driver,Duration.ofSeconds(
                Integer.parseInt(getProperties("explicitWait"))));
    }

    public void tearDown(){
        if(getDriver() != null){
            driver.quit();
        }
    }

    private static void loadProperties(){
        properties = new Properties();
        File fIle = new File("./configuration/config.properties");
        try {
            FileInputStream fis = new FileInputStream(fIle);
            properties.load(fis);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperties(String property){
        return properties.getProperty(property);
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriverWait getWait(){
        return wait;
    }
}
