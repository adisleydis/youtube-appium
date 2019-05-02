package pageobjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VideoPage {

    @AndroidFindBy(accessibility = "Minimize")
    public MobileElement minimizeOption;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.View")
    public MobileElement videoXpath;
    private AndroidDriver<WebElement> driver;
    @AndroidFindBy(id = "com.google.android.youtube:id/button_icon")
    private MobileElement likeOption;
    @AndroidFindBy(id = "com.google.android.youtube:id/subscribe_button")
    private MobileElement subscribeOption;
    @AndroidFindBy(accessibility = "Enter fullscreen")
    private MobileElement maximize;

    public VideoPage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public VideoPage clickVideo(WebElement video) {
        video.click();
        return new VideoPage(driver);
    }

    public VideoPage clickLike() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(likeOption));
        likeOption.click();
        return this;
    }

    public VideoPage subscribed() {
        if (subscribeOption.getText().equals("SUBSCRIBE"))
            subscribeOption.click();
        return this;
    }

    public VideoPage maximizeAndMinimize() {
        videoXpath.click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(maximize));
        maximize.click();
        videoXpath.click();
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(minimizeOption));
        minimizeOption.click();
        return this;
    }


}
