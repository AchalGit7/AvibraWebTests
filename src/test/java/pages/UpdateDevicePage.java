package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class UpdateDevicePage {

    @FindBy(xpath = "//button[contains(text(), 'Update Your Device')]")
    private WebElementFacade updateDeviceButton;

    public void setUpdateDeviceButton() {
        updateDeviceButton.click();
    }
}
