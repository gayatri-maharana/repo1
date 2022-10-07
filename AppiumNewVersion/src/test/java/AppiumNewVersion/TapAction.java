package AppiumNewVersion;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class TapAction {
	static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
		dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
		dc.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		dc.setCapability("appActivity", ".Calculator");
		URL url = new URL("http://localhost:4723/wd/hub");
		driver=new AndroidDriver(url, dc);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	public void dragandDrop(int x, int y, WebElement element)
	{
		TouchAction touch = new TouchAction(driver);
		touch.longPress(LongPressOptions.longPressOptions()
				.withPosition(PointOption.point(x, y))
				.withDuration(Duration.ofSeconds(10)))
		.moveTo(PointOption.point(x, y)).release().perform();
		
		touch.longPress(LongPressOptions.longPressOptions()
				.withElement(ElementOption.element(element))
				.withDuration(Duration.ofMillis(5000)))
		.moveTo(PointOption.point(x, y))
		.release().perform();
	
	
	}
	
	public void tapaction(WebElement element)
	{
		TouchAction touch = new TouchAction(driver);
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(element)));
		
	}
	
	public void tapaction(WebElement element,int x,int y)
	{
		TouchAction touch=new TouchAction(driver);
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(element, x, y)));
	}
	
	

}
