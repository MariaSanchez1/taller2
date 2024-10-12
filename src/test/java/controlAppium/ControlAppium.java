package controlAppium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import singletonSession.Session;

public class ControlAppium {
    protected By locator;
    protected WebElement control;

    public ControlAppium(By locator){
        this.locator = locator;
    }

    public void find(){
        this.control = Session.getInstance().getDriver().findElement(this.locator);
    }

    public void click(){
        this.find();
        this.control.click();
    }

    public boolean isControlDisplayed(){
        try {
            this.find();
            return this.control.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    public String getText(){
        this.find();
        return this.control.getText();
    }

}
