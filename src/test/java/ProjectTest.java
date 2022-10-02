import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

public class ProjectTest {
    public static WebDriver driver = null;

    @Test
     void testNavigate() throws InterruptedException {
        driver = Helper.setProperty();
        driver.get(Helper.STIPSURL);
        driver.navigate().to(Helper.YOUTUBEURL);
        String windowOne = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(Helper.GITHUBURL);
        String windowTwo = driver.getWindowHandle();
        driver.switchTo().window(windowOne);
        driver.navigate().to(Helper.YOUTUBEURL);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(Helper.GOOGLEURL);
        driver.switchTo().window(windowTwo);
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.navigate().to(Helper.STIPSURL);
        driver.navigate().back();
        driver.quit();
    }

    @Test
    void testWindow() throws IOException, InterruptedException {
        driver = Helper.setProperty();
        driver.get(Helper.WIKIURL);
        driver.manage().window().maximize();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript(Helper.WINDOWSCROLLSUPERDOWN);
        File file1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Thread.sleep(3000);

        driver.manage().window().minimize();
        javascriptExecutor.executeScript(Helper.WINDOWSCROLLUP);
        File file2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Thread.sleep(3000);

        driver.manage().window().fullscreen();
        javascriptExecutor.executeScript(Helper.WINDOWSCROLLDOWN);
        File file3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Thread.sleep(3000);

        File file4 = new File(Helper.FILE1  + Helper.JPG);
        File file5 = new File(Helper.FILE2 + Helper.JPG);
        File file6 = new File(Helper.FILE3 + Helper.JPG);

        FileUtils.copyFile(file1,file4);
        FileUtils.copyFile(file2,file5);
        FileUtils.copyFile(file3,file6);

        driver.quit();
    }

    @Test
    void elements() throws InterruptedException {
        driver = Helper.setProperty();
        driver.get(Helper.BASICCALCURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.NUMBER1FIELDID))).sendKeys("8");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.NUMBER2FIELDID))).sendKeys("4");

        Select dropdown = new Select(driver.findElement(By.id(Helper.DROPDOWNID)));
        dropdown.selectByIndex(2);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.CLICKBUTTONID))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.MYRESULTFIELDID)));

        driver.get(Helper.HEROCHECKBOXURL);
        WebElement checkbox1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.CHECKBOX1XPATH)));
        checkbox1.click();
        System.out.println("checkbox1 is selected = " + checkbox1.isSelected());
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.xpath(Helper.HEROTEXTXPATH)).getText());

        driver.get(Helper.ALERTURL);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.ALERTBUTTUNID))).click();
        driver.switchTo().alert().accept();

        driver.get(Helper.BUTTONURL);
        Actions actions = new Actions(driver);
        actions.doubleClick(wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.DOUBLECLICKID)))).perform();
        driver.quit();
    }

    @Test
    void myAssert() throws InterruptedException {
        driver = Helper.setProperty();
        driver.get(Helper.GOOGLEURL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to(Helper.STIPSURL);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Helper.STIPSBUTTUNXPATH))).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(),Helper.STIPSSIGNUPURL);
        driver.quit();
    }

    @Test
    void copyParagraph() throws IOException {
        driver = Helper.setProperty();
        driver.get(Helper.WIKIURL);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.WIKISEARCHINPUTID))).sendKeys(Helper.ONEPIECE);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.WIKICLICKBUTTONID))).click();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        WebElement production = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(Helper.PRODUCTIONID)));
        javascriptExecutor.executeScript(Helper.ARGUMENTS,production);

        File Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File path2 = new File(Helper.FOLDER1 + Helper.JPG);
        FileUtils.copyFile(Screenshot,path2);

        String text = driver.findElement(By.xpath(Helper.PARAGRAPHXPATH)).getText();
        File file = new File(Helper.FOLDER1 + "new_file" + Helper.TXT);

        FileWriter writer = new FileWriter(file);
        writer.write(text);
        writer.close();
        driver.quit();
    }











}
