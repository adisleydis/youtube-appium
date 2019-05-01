package pageobjects;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private AndroidDriver<WebElement> driver;

    @AndroidFindBy(accessibility = "Search")
    private MobileElement searchOption;

    @AndroidFindBy(id = "com.google.android.youtube:id/search_edit_text")
    private MobileElement searchBox;

    public HomePage(AndroidDriver<WebElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        loadPage();
    }

    public void loadPage() {
        searchOption.isDisplayed();
    }

    public void searchBySong(String song) {
        searchOption.click();
        searchBox.sendKeys(song);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public WebElement waitAndReturnVideo(String song) {
        By accessibilityId = MobileBy.AccessibilityId(song);
        WebElement video = new WebDriverWait(driver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(accessibilityId));
        return video;
    }
}
