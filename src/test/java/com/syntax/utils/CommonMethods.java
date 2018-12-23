package com.syntax.utils;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends BaseClass {

	public static void enterValue(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public static WebElement waiting(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void click(WebElement element) {
		WebElement elm = waiting(element);
		elm.click();
	}

	public static void DropDown(WebElement value, String value2) {
		Select obj = new Select(value);
		List<WebElement> elements = obj.getOptions();
		System.out.println("Number of option is dd is --------------"+elements.size());
		for (WebElement element : elements) {
			System.out.println(element.getText());
			if (element.getText().equalsIgnoreCase(value2)) {
				obj.selectByVisibleText(value2);
			}
		}
	}
}
