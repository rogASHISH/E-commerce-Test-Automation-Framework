package com.Ecommerce.PageObject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private WebDriver driver;

	// Constructor
	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	// Locators
	private By searchBox = By.id("twotabsearchtextbox");
	private By searchButton = By.id("nav-search-submit-button");

	// Actions
	public void openHomePage(String url) throws IOException {
		driver.get(url);
	}

	public void searchProduct(String productName) {
		driver.findElement(searchBox).sendKeys(productName);
		driver.findElement(searchButton).click();
	}
}
