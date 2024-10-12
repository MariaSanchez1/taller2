package whendo;

import controlAppium.Button;
import controlAppium.Label;
import controlAppium.TextBox;
import org.openqa.selenium.By;

public class AddTask {

    public TextBox titleTxtBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public TextBox noteTxtBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));

    public Button saveButton = new Button(By.xpath("//android.widget.TextView[@content-desc='Save']"));

}
