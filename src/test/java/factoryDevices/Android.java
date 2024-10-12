package factoryDevices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Android implements IDevices{
    @Override
    public AppiumDriver create() {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("appium:deviceName","Pixel 8a API 34");
        config.setCapability("appium:platformVersion","14.0");
        //config.setCapability("appium:appPackage","com.android.contacts");
        //config.setCapability("appium:appActivity","com.android.contacts.activities.PeopleActivity");
        config.setCapability("appium:app","/Users/pc-tomas/Downloads/Todo.apk");
        config.setCapability("platformName","Android");
        config.setCapability("appium:automationName","uiautomator2");
        AppiumDriver android = null;
        try {
            android = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),config);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        android.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
         return android;
    }
}
