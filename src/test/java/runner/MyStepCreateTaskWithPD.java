package runner;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import whendo.AddTask;
import whendo.PageInitial;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MyStepCreateTaskWithPD {

    AddTask addTask = new AddTask();
    PageInitial pageInitial = new PageInitial();


    @Given("tengo acceso a whenDoApp")
    public void tengoAccesoAWhenDoApp() throws MalformedURLException {
        pageInitial.addButton.click();
    }

    @When("creo una nueva tarea con titulo {word} y descripcion {word}")
    public void creoUnaNuevaTarea(String titulo, String descripcion) {

        addTask.titleTxtBox.setText(titulo);
        addTask.noteTxtBox.setText(descripcion);
        addTask.saveButton.click();


    }

    @Then("la tarea {word} deberia ser creada")
    public void laTareaDeberiaSerCreada(String expectedResult) {
        String actualResult = pageInitial.resultList.getText();

        Assertions.assertEquals(expectedResult, actualResult, "Error! la tarea no se creo");
    }
}
