package com.Ecommerce.TestCases;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ecommerce.Base.Base;
import com.Ecommerce.PageObject.CartPage;
import com.Ecommerce.PageObject.HomePage;
import com.Ecommerce.PageObject.ProductPage;
import com.Ecommerce.Utilities.ExcelUtils;

public class ECommerceTest extends Base{


	    @DataProvider(name = "productData")
	    public Object[][] getProductData() {
	        List<String[]> data = ExcelUtils.readExcel("src/main/resources/products.xlsx", "Sheet1");
	        return data.toArray(new Object[0][]);
	    }

	    @Test(dataProvider = "productData")
	    public void searchAndAddProductToCart(String productName, String brand) throws IOException, InterruptedException {
	        HomePage homePage = new HomePage(driver);
	        ProductPage productPage = new ProductPage(driver);
	        CartPage cartPage = new CartPage(driver);

	        homePage.openHomePage("https://www.amazon.in/");
	        homePage.searchProduct(productName);
	        productPage.applyBrandFilter(brand);
//	        productPage.selectFirstProduct();
	        Thread.sleep(3000);
	        cartPage.addToCart();
	        Thread.sleep(3000);
	        cartPage.verifyProductInCart();
	    }
	}


