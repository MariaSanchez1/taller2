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
        config.setCapability("appium:deviceName","JBGroup9");
        config.setCapability("appium:platformVersion","9.0");
        config.setCapability("appium:appPackage","com.vrproductiveapps.whendo");
        config.setCapability("appium:appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
        config.setCapability("platformName","Android");
        config.setCapability("appium:automationName","uiautomator2");
        AppiumDriver android = null;
        try {
            android = new AndroidDriver(new URL("http://192.168.1.19:4723/wd/hub"),config);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        android.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
         return android;
    }
}
