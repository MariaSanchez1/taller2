package singletonSession;

import factoryDevices.FactoryDevices;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class Session {
    // tener un atributo del mismo de la clase
    private static Session instance = null;
    private AppiumDriver device;

    // tener un constructor privado
    private Session(){
        //todo
        device = FactoryDevices.make("android").create();
    }
    // tener un metod estatico publico de acceso global
    public static Session getInstance(){
        if (instance == null){
            instance = new Session();
        }
        return instance;
    }

    public void closeSession(){
        device.quit();
        instance=null;
    }

    public AppiumDriver getDriver() {
        return device;
    }
}
