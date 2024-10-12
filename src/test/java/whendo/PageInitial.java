package whendo;

import controlAppium.Button;
import controlAppium.Label;
import controlAppium.TextBox;
import org.openqa.selenium.By;

public class PageInitial {


    public Button addButton = new Button(By.id("com.vrproductiveapps.whendo:id/fab"));
    public Label resultList = new Label(By.id("com.vrproductiveapps.whendo:id/home_list_item_text"));
}
