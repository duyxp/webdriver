package com.seleniumwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SeleniumTarget {

	public static void main(String[] args) throws IOException {

		WebDriver edge = new EdgeDriver();
		edge.get("https://www.target.com");

		WebElement searchBar = edge.findElement(By.id("search"));
		searchBar.sendKeys("iphone");

		WebElement searchButton = edge.findElement(By.cssSelector(".SearchInputButton-gNbUBp"));
		searchButton.click();

		List<WebElement> products = edge.findElements(By.cssSelector(".Col-favj32-0.favAWs"));
		StringBuilder output = new StringBuilder();
		for (WebElement product : products) {
			WebElement descriptionElement = product.findElement(By.cssSelector(".Title-b9fjqw-9.gNznca"));
			WebElement priceElement = product.findElement(By.cssSelector(".Price__StyledPricePromo-btbx9j-1.fiyuqZ"));
			String description = descriptionElement.getText();
			String price = priceElement.getText();
			output.append("Description: ").append(description).append("\n");
			output.append("Price: ").append(price).append("\n\n");

			try {
				FileWriter file = new FileWriter(
						"C:\\Users\\GraceT3\\Documents\\Java Training\\SeleniumWebDriver0423\\textfile\\eBay.txt");
				file.write(output.toString());
				file.close();
				System.out.println(
						"C:\\Users\\GraceT3\\Documents\\Java Training\\SeleniumWebDriver0423\\textfile\\Target.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
