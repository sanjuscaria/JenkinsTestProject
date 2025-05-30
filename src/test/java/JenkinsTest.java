import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JenkinsTest {

	//Adding a comment from git
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("file:///C:/test/pagination.html");
		
	}
	@Test
	public void test1()
	{
		WebElement datatable = driver.findElement(By.xpath("//table[@id='dataTable']"));
		List<WebElement> rows = datatable.findElements(By.xpath(".//tbody/tr"));
		System.out.println("rowcount : "+rows.size());
		for(int i = 0; i< rows.size(); i++)
		{
			WebElement row = rows.get(i);
			String email = row.findElement(By.xpath(".//td[3]")).getText();
			System.out.println("email only : "+email);
		}
		
		

	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
