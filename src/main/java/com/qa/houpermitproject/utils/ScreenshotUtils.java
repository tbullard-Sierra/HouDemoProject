package com.qa.houpermitproject.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.qa.houpermitproject.base.BasePage;

public class ScreenshotUtils extends BasePage{

	public static File captureElementScreenshot(WebElement element) throws IOException {
        // Capture the screenshot of the entire page
        File screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

        // Calculate the dimensions of the element
        int elementWidth = element.getSize().getWidth();
        int elementHeight = element.getSize().getHeight();

        // Create a rectangle around the element on the screenshot
        BufferedImage fullImg = ImageIO.read(screenshot);
        BufferedImage elementScreenshot = fullImg.getSubimage(element.getLocation().getX(), element.getLocation().getY(), elementWidth, elementHeight);

        // Write the element screenshot to a file
        ImageIO.write(elementScreenshot, "png", screenshot);

        return screenshot;
    }
}
