package runner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Map;

public class MyStepCreateTask {

    AppiumDriver android;
    //@Given("tengo acceso a whenDoApp")
    public void tengoAccesoAWhenDoApp() throws MalformedURLException {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("platformName","Android");
        config.setCapability("appium:platformVersion","14");
        config.setCapability("appium:deviceName","Pixel 8a API 34");
        config.setCapability("appium:app","/Users/pc-tomas/Downloads/Todo.apk");
        config.setCapability("appium:automationName","uiautomator2");

        android = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),config);
        android.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    //@When("creo una nueva tarea con titulo {word} y descripcion {word}")
    public void creoUnaNuevaTarea(String titulo, String descripcion) {
        android.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
        android.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(titulo);
        android.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(descripcion);
        android.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
    }

    //@Then("la tarea {word} deberia ser creada")
    public void laTareaDeberiaSerCreada(String expectedResult) {
        String actualResult = android.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_text")).getText();

        Assertions.assertEquals(expectedResult, actualResult, "Error! la tarea no se creo");
    }
}
