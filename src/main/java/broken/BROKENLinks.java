package broken;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class BROKENLinks {
	
	public WebDriver driver;
	
	public void validation() throws IOException {
		driver =new ChromeDriver();
		driver.get("https://www.coderstool.com/key-event-viewer");
		
		File file=new File("C:/Users/hp/eclipse-workspace/BrokenLinksWithBuffered/target"+"/broken.txt");
		BufferedWriter writer=new BufferedWriter(new FileWriter(file));
		
		try {
			
			List<WebElement> url=driver.findElements(By.tagName("a"));
			
			for(WebElement links:url) {
				String link=links.getAttribute("href");
				
				URL u = new URL(link);
	            HttpURLConnection http = (HttpURLConnection) u.openConnection();
	            http.setConnectTimeout(5000);
	            http.connect();

	            int statusCode = http.getResponseCode();
	            String message = http.getResponseMessage();

	            if (statusCode >= 400) {
	                System.out.println("❌ Broken Link: " + link + " --> " + statusCode + " " + message);
	                writer.write("Broken Link: " + link + " --> " + statusCode + " " + message + "\n");
	            } else {
	                System.out.println("✅ Valid Link: " + links.getText() + " --> " + statusCode + " " + message);
	                writer.write("Broken Link: " + link + " --> " + statusCode + " " + message + "\n");
	            }
				
			}
			
		}catch(Exception e) {
			e.getMessage();
		}finally {
            writer.close();
            driver.quit();
        }
		

	}

}
