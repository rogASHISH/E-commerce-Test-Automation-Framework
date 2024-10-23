package com.Ecommerce.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {

	private WebDriver driver;

	// Constructor
	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	// Methods to filter and select a product
	public void applyBrandFilter(String brand) {
		String brandFilterXpath = "//span[text()='" + brand + "']";
		WebElement brandFilterElement = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(brandFilterXpath)));
		brandFilterElement.click();
	}

	/*
	 * public String selectFirstProduct() { WebElement productElement = new
	 * WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
	 * .elementToBeClickable(By.
	 * xpath("//span[@class='a-size-medium a-color-base a-text-normal'][1]")));
	 * String productTitle = productElement.getText(); productElement.click();
	 * return productTitle; }
	 */
}
