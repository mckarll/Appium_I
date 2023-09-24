package utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
public class BaseClass {
    public static AndroidDriver driver;
    private static AppiumDriverLocalService service;
    @BeforeTest
        public static void setUp() throws MalformedURLException {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        if (service == null || !service.isRunning()) {
           throw new AppiumServerHasNotBeenStartedLocallyException("An appium server node is not started!");
        }
            ConfigReaders.readProperties(Constants.CONFIGURATION_FILE_PATH);
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("appium:platformVersion", "8.1.0");
            desiredCapabilities.setCapability("appium:deviceName", "LG Stylo4");
            desiredCapabilities.setCapability("appium:automationName", "UiAutomator2");
            desiredCapabilities.setCapability("appium:app", Constants.APP_FILE_PATH+"/"+ConfigReaders.getProperty("app"));
            desiredCapabilities.setCapability("appium:uiautomator2ServerInstallTimeout", "80000");
            desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
            desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
            desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
            desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);
            driver = new AndroidDriver(service.getUrl(), desiredCapabilities);
        }
        @AfterTest
        public static void tearDown() throws Exception {
            if (driver != null) {
                driver.quit();
            }
            if (service != null) {
                service.stop();
            }
        }
}




