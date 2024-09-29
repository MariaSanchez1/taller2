package basicAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

public class JavaBasic {
    AppiumDriver android;

    @BeforeEach
    public void setup() throws MalformedURLException {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("platformName","Android");
        config.setCapability("appium:platformVersion","14");
        config.setCapability("appium:deviceName","Pixel 8a API 34");
        config.setCapability("appium:app","/Users/pc-tomas/Downloads/Todo.apk");
        config.setCapability("appium:automationName","uiautomator2");
        android = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), config);
        android.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void verifyCreateTasks() throws InterruptedException {

        for (int i = 0; i < 20; i++) {
            android.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
            android.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys("Title " + (i+1));
            android.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys("Note " + (i+1));
            android.findElement(By.xpath("//android.widget.TextView[@content-desc='Save']")).click();
            String expectedResult ="Title " + (i+1);
            String actualResult = android.findElement(By.id("com.vrproductiveapps.whendo:id/home_list_item_text")).getText();

            Assertions.assertEquals(expectedResult, actualResult, "Error! la tarea no se creo");


        }

        doSwipe();


    }


    public void doSwipe() throws InterruptedException {


        Point firstPoint = android.findElement(By.xpath("//android.widget.TextView[@text='Title 11']")).getLocation();
        Point secondPoint = android.findElement(By.xpath("//android.widget.TextView[@text='Title 14']")).getLocation();

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

// Define el punto de inicio (x1, y1) y el punto final (x2, y2) del swipe
        int startX = firstPoint.getX(); // Coordenada X de inicio
        int startY = firstPoint.getY(); // Coordenada Y de inicio
        int endX = secondPoint.getX();   // Coordenada X de final
        int endY = secondPoint.getY();   // Coordenada Y de final

        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        android.perform(Arrays.asList(swipe));

        Thread.sleep(5000);



    }
    @AfterEach
    public void closeApp(){
        android.quit();
    }
}
