package com.fourstay.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtilities {

	public static void waitForPageLoad() {
		WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.se-pre-con")));
		try {
			Thread.sleep(1111);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void switchTab(String url) {
		String defaultTab = Driver.getInstance().getWindowHandle();
		for (String windowhandle : Driver.getInstance().getWindowHandles()) {
			Driver.getInstance().switchTo().window(windowhandle);
			if (Driver.getInstance().getCurrentUrl().contains(url)) {
				return;
			}
		}
		Driver.getInstance().switchTo().window(defaultTab);
	}
}
