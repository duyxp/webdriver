package com.seleniumwebdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SeleniumeBay {

	public static void main(String[] args) throws IOException {

		WebDriver edge = new EdgeDriver();
		edge.get("https://www.ebay.com");

		WebElement searchBar = edge.findElement(By.id("gh-ac"));
		searchBar.sendKeys("iphone");

		WebElement searchButton = edge.findElement(By.id("gh-btn"));
		searchButton.click();

		List<WebElement> products = edge.findElements(By.xpath("//li[contains(@class, 's-item')]"));
		StringBuilder output = new StringBuilder();
		for (WebElement product : products) {
			WebElement descriptionElement = product.findElement(By.xpath(".//h3"));
			WebElement priceElement = product.findElement(By.xpath(".//span[contains(@class, 's-item__price')]"));
			String description = descriptionElement.getText();
			String price = priceElement.getText();
			output.append("Description: ").append(description).append("\n");
			output.append("Price: ").append(price).append("\n\n");

			try {
				FileWriter file = new FileWriter("C:\\Users\\GraceT3\\Documents\\Java Training\\SeleniumWebDriver0423\\textfile\\eBay.txt");
				file.write(output.toString());
				file.close();
				System.out.println("C:\\Users\\GraceT3\\Documents\\Java Training\\SeleniumWebDriver0423\\textfile\\eBay.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
