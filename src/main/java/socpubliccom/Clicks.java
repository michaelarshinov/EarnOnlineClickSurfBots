package socpubliccom;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Clicks {
	public static void DO(String acc, String pwd) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		synchronized (driver) {
			driver.get("https://socpublic.com/auth_login.html");
			driver.wait(3000);
			WebElement login = driver.findElement(By.name("name"));
				login.sendKeys(acc);
			WebElement passwordw = driver.findElement(By.name("password"));
				passwordw.sendKeys(pwd);
			System.out.println("+++++++++++++++");
			driver.wait(50000);
			
			int iterations = 10000;
			Random random = new Random(2000);
			try{while( iterations > 0 ) {
				driver.get("https://socpublic.com/account/visit.html?type=redirect");
				WebElement a = 
				driver.findElement(By.className("table-responsive"))
				.findElements(By.className("left")).get(0)
				.findElement(By.tagName("a"));
				System.out.println(iterations+"-"+a.getAttribute("href"));
				a.click();
				driver.wait(7000/* + random.nextInt(1500)*/);
			}}catch(IndexOutOfBoundsException | WebDriverException t) {}
			driver.wait(50000);
			driver.quit();
			driver.close();
		}
	}
	static String login = "<YOUR_LOGIN>";
	static String password = "<YOUR_PASSWORD>";
	public static void main(String[] args) throws InterruptedException {
		DO(login, password);
	}

}
