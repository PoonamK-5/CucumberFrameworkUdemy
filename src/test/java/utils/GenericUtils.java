package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver=driver;
	}
	
	public void SwitchWindowToChild()
	{
		String firstWindow = driver.getWindowHandle();
		System.out.println(firstWindow);
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> windowsIterator = allWindows.iterator();
		String parentWindow = windowsIterator.next();
		String childWindow = windowsIterator.next();
		driver.switchTo().window(childWindow);
	}
}
