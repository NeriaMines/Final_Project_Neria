import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Helper {

    public static final String CHROMEKEY = "webdriver.chrome.driver";
    public static final String CHROMEPATH = "res\\chromedriver.exe";



    public static final String STIPSURL = "https://stips.co.il/";
    public static final String YOUTUBEURL = "https://www.youtube.com/";
    public static final String GITHUBURL = "https://github.com/";
    public static final String WIKIURL = "https://en.wikipedia.org/wiki/Wiki";
    public static final String GOOGLEURL = "https://www.google.co.il/?hl=iw";






    public static final String FILE1 = "C:\\Users\\user\\Desktop\\file1\\";
    public static final String FILE2 = "C:\\Users\\user\\Desktop\\file2\\";
    public static final String FILE3 = "C:\\Users\\user\\Desktop\\file3\\";
    public static final String FOLDER1 = "C:\\Users\\user\\Desktop\\Screenshot\\";
    public static final String JPG = ".jpg";
    public static final String TXT = ".txt";









    public static final String PARAGRAPHXPATH = "//*[@id=\"mw-content-text\"]/div[1]/p[8]";
    public static final String PRODUCTIONID = "Production";
    public static final String WIKISEARCHINPUTID = "searchInput";
    public static final String WIKICLICKBUTTONID = "searchButton";





    public static final String STIPSBUTTUNXPATH = "//*[@id=\"app-component\"]/div/app-homepage/app-navbar/div/mat-toolbar/div/div[1]/div/a[1]/span";
    public static final String STIPSSIGNUPURL = "https://stips.co.il/signup";





    public static final String ONEPIECE = "one piece";



    public static final String ARGUMENTS = "arguments[0].scrollIntoView();";
    public static final String WINDOWSCROLLSUPERDOWN = "window.scrollBy(0,document.body.scrollHeight)";
    public static final String WINDOWSCROLLUP = "window.scrollBy(0,-10000)";
    public static final String WINDOWSCROLLDOWN = "window.scrollBy(0,4000)";




    public static final String BASICCALCURL = "https://testsheepnz.github.io/BasicCalculator.html";
    public static final String NUMBER1FIELDID = "number1Field";
    public static final String NUMBER2FIELDID = "number2Field";
    public static final String DROPDOWNID = "selectOperationDropdown";
    public static final String CLICKBUTTONID = "calculateButton";
    public static final String MYRESULTFIELDID = "numberAnswerField";




    public static final String HEROCHECKBOXURL = "https://the-internet.herokuapp.com/checkboxes";
    public static final String CHECKBOX1XPATH = "//*[@id=\"checkboxes\"]/input[1]";
    public static final String HEROTEXTXPATH = "//*[@id=\"page-footer\"]/div/div";




    public static final String ALERTURL = "https://demoqa.com/alerts";
    public static final String ALERTBUTTUNID = "alertButton";
    public static final String BUTTONURL = "https://demoqa.com/buttons";
    public static final String DOUBLECLICKID = "doubleClickBtn";











    public static ChromeDriver setProperty(){
        System.setProperty(CHROMEKEY,CHROMEPATH);
        return new ChromeDriver();
    }
}
