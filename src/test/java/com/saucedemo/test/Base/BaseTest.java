package com.saucedemo.test.Base;

import com.saucedemo.test.util.General;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    private Properties properties;
    public static WebDriver driver;

    public BaseTest() {
        try {
            properties = new Properties();
            String filePath = System.getProperty("user.dir")
                    + "\\src\\test\\resources\\config.properties";
            FileInputStream inputStream = null;

            inputStream = new FileInputStream(filePath);
            properties.load(inputStream);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setUpBrowser() {
        String browserName = properties.getProperty("browserName");

        if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("headless")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.setHeadless(true);
            driver = new FirefoxDriver(firefoxOptions);
        } else {
            System.out.println("Please provide browser name");
        }

//        link load and browser maximization
        driver.get(properties.getProperty("baseUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(General.PAGE_LOAD));
    }

    public String getUserName() {
        return properties.getProperty("userName");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getFirstName() {
        return properties.getProperty("firstName");
    }

    public String getLastName() {
        return properties.getProperty("lastName");
    }

    public String getPostalCode() {
        return properties.getProperty("postalCode");
    }
}
