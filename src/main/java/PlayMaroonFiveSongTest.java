import io.appium.java_client.android.AndroidDriver;
import org.junit.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageobjects.HomePage;
import pageobjects.VideoPage;

public class PlayMaroonFiveSongTest extends BaseTest {
    private static AndroidDriver<WebElement> driver;
    private HomePage homePage;
    private VideoPage videoPage;

    public PlayMaroonFiveSongTest() {
        homePage = new HomePage(driver);
        videoPage = new VideoPage(driver);
    }

    @BeforeClass
    public static void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("deviceName", "4ec4bd62");
        capabilities.setCapability("appPackage", "com.google.android.youtube");
        capabilities.setCapability("appActivity", "com.google.android.youtube.HomeActivity");
        driver = new AndroidDriver(getServiceUrl(), capabilities);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void playLastestHit() {
        homePage.searchBySong("maroon five girls like you");
        WebElement video = homePage.waitAndReturnVideo("Maroon 5 - Girls Like You ft. Cardi B - 4 minutes, 31 seconds - play video");
        videoPage.clickVideo(video);
        videoPage.clickLike();
        videoPage.subscribed();
        videoPage.maximizeAndMinimize();
    }
}

