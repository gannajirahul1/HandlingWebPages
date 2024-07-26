package testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleWebPages {

	public static void main(String[] args) throws InterruptedException {
		// Handling multiple webpages through getWindowHandles()
		ChromeDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	    driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		//we can specify the xpath of linked text
		//driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		Set<String>WinIds=driver.getWindowHandles();
		//approach 1
		List<String> WinList=new ArrayList(WinIds);
		String parent =WinList.get(0);
		String child =WinList.get(1);
		System.out.println("Title of child Id:" + driver.getTitle());
		//switching to child
		/*
		driver.switchTo().window(child);
		System.out.println("title of child:"+ driver.getTitle());
		*/
		//switching to parent
		/*
		driver.switchTo().window(parent);
		System.out.println("title of parent:"+ driver.getTitle());
		*/
		
		//if you have many browsers then we use loop 
		//approach 2
		//in this we are finding the current url of the page
		/*
		for(String winId:WinIds)
		{
			String title=driver.switchTo().window(winId).getTitle();
			if(title.equals("OrangeHRM"))
			{
				System.out.println("current url :" + driver.getCurrentUrl());
			}
		}
		*/
		//in this we are finding the current url of child page
		/*
		for(String winId:WinIds)
		{
			String title=driver.switchTo().window(winId).getTitle();
			if(title.equals("Human Resources Management Software | OrangeHRM"))
			{
				System.out.println("current url :" + driver.getCurrentUrl());
			}
		}*/
		//for closing child window 
		/*
		for(String winId:WinIds)
		{
			String title=driver.switchTo().window(winId).getTitle();
			if(title.equals("Human Resources Management Software | OrangeHRM"))
			{
				driver.close();
			}
		}
		*/
		//closing parent window
		/*
		for(String winId:WinIds)
		{
			String title=driver.switchTo().window(winId).getTitle();
			if(title.equals("OrangeHRM"))
			{
				driver.close();
			}
		}
		*/
		
	}

}
