import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.net.URL;

public abstract class BaseTest {

    private static AppiumDriverLocalService service;

    @BeforeClass
    public static void globalSetup() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
    }

    @AfterClass
    public static void globalTearDown() {
        service.stop();
    }

    public static URL getServiceUrl() {
        return service.getUrl();
    }

}