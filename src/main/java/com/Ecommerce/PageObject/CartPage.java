package com.Ecommerce.PageObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CartPage {

	private WebDriver driver;

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addToCart() {

		WebElement addToCartButton = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(By.id("a-autoid-1-announce")));
		addToCartButton.click();
	}

	public void verifyProductInCart() throws IOException {
		WebElement cartCountElement = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-cart-count")));
		int cartCount = Integer.parseInt(cartCountElement.getText());
		if (cartCount > 0) {
			cartCountElement.click();
			String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file,
					new File(System.getProperty("user.dir") + "//Screenshots//Screenshot" + timeStamp + ".png"));
		} else {
			Assert.fail("item not added to cart");
		}
	}
}
