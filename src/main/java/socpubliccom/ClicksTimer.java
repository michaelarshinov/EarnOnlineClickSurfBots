package socpubliccom;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class ClicksTimer {
	static String password = "<YOUR_PASSWORD>";
	static String login = "<YOUR_LOGIN>";
	public static void main(String[] args) throws InterruptedException {
		DO(login , password);
	}
		
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
				
				int tt = 0;
				//int tttt = 0;
				//Random random = new Random(2000);
				try{while( tt < 10993 ) {
					driver.get("https://socpublic.com/account/visit.html?type=frame&page_limit=200");
					WebElement link = driver.findElement(By.className("table-responsive"))
							.findElements(By.className("letter")).get(tt);
					String sec = link.findElements(By.className("bottom")).get(0)
							.getText().replace("Время просмотра ", "").split(" сек.")[0].trim();
					
					System.out.println("-"+sec+"-"+tt+"-"+link.findElements(By.className("left")).get(0)
							.findElement(By.tagName("a")).getAttribute("href"));
					String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
					link.findElements(By.className("left")).get(0).findElement(By.tagName("a"))
						.sendKeys(selectLinkOpeninNewTab);
					
					driver.wait(Integer.valueOf(sec)*1000/* + random.nextInt(1500)*/+3000);
					tt++;
				}}catch(IndexOutOfBoundsException | WebDriverException t) {
					System.err.println(t.getMessage()+"/"+t.getStackTrace()[0]);
				}
				//driver.wait(50000);
				//driver.quit();
				//driver.close();
				System.out.println("+++++");
				while(true) {}
			}
		}
}
