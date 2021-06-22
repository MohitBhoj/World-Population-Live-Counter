package livecounter;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LiveCounter {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String xpath_current_pop= "//div[text()='Today' or text()='This year']//parent::div//span[@class='rts-counter']";
		String xpath_today_this_year_pop="//div[text()='Today' or text()='This year']//parent::div//span[@class='rts-counter']";
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.worldometers.info/world-population/");
        
		int count=1;
		while(count<=20) {
			
			System.out.println(count + "seconds");
			if(count==21) break;
		
		System.out.println("---------------------Current Population Count---------------------");
		printPopulationData(xpath_current_pop);
		System.out.println("---------------------Today and This Year Population Count---------------------");
		printPopulationData(xpath_today_this_year_pop);
		
		System.out.println("==========================");
		Thread.sleep(1000);
		count++;
		}
		driver.close();
	}
	public static void printPopulationData(String Locator) throws InterruptedException{

		   
			//List<WebElement> popList = driver.findElements(By.xpath(Locator));
		    //for(WebElement e : popList) {
		   //System.out.println(e.getText());
		
		driver.findElements(By.xpath(Locator))
			.stream().forEach(e -> System.out.println(e.getText()));
	
					
	}

}

