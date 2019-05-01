package pageobjects;

import cucumber.api.java.cs.A;
import cucumber.api.java.en.And;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VideoPage {

    private AndroidDriver<WebElement> driver;

    @AndroidFindBy(id = "com.google.android.youtube:id/button_icon")
    private MobileElement likeOption;

    @AndroidFindBy(id = "com.google.android.youtube:id/subscribe_button")
    private MobileElement subscribeOption;

    @AndroidFindBy(accessibility = "Enter fullscreen")
    private MobileElement maximize;

    @AndroidFindBy(accessibility = "Minimize")
    public MobileElement minimizeOption;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.View")
    public MobileElement videoXpath;

    public VideoPage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickVideo(WebElement video) {
        video.click();
    }

    public void clickLike() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(likeOption));
        likeOption.click();
    }

    public void subscribed() {
        if(subscribeOption.getText().equals("SUBSCRIBE"))
            subscribeOption.click();
    }

    public void maximizeAndMinimize() {
        videoXpath.click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(maximize));
        maximize.click();
        videoXpath.click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(minimizeOption));
        minimizeOption.click();
    }



}
