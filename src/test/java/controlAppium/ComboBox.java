package controlAppium;

import org.openqa.selenium.By;

public class ComboBox extends ControlAppium{
    private String locatorOption;
    public ComboBox(By locator, String locatorOption) {
        super(locator);
        this.locatorOption = locatorOption;
    }
    public void select(String option){
        Label optionToSelect = new Label(By.xpath(String.format(locatorOption,option)));
        this.find();
        this.control.click();
        optionToSelect.click();
    }
}
