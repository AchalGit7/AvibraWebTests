package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.UpdateDevicePage;

public class UpdateDeviceSteps extends ScenarioSteps {

    UpdateDevicePage updateDevicePage;


    @Step
    public void clickOnUpdateDeviceBtn(){
        updateDevicePage.setUpdateDeviceButton();
    }

}
