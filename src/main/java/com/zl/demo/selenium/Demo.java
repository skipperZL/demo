package com.zl.demo.selenium;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Demo {

public static void main(String[] args) throws InterruptedException {
	
	for (int i = 0; i < 20; i++) {
		openWebOnlyOpen();
		Thread.sleep(2000);
		
	}
	
	}



	public static void setValueForInput(WebElement we, String value) {
		we.clear();
		we.sendKeys(value);
	}
	
	public static void clickById(WebDriver driver, String id) {
	    WebElement obj = driver.findElement(By.id(id));
	    obj.click();
	}
	
	public static void clickByClass(WebDriver driver, String className) {
	    List<WebElement> obj = driver.findElements(By.className(className));
	    obj.get(0).click();
	}
	
	private static void openWeb() {
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");  
	    
	    //初始化一个chrome浏览器实例，实例名称叫driver  
	    WebDriver driver = new ChromeDriver();  
	    //最大化窗口  
	    //driver.manage().window().maximize();  
	    //设置隐性等待时间  
	    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);  
	      
	    // get()打开一个站点  
	    driver.get("http://168.168.190.238:8900/gdsclsoa/kf");  
	    String mainHandle=driver.getWindowHandle();      //取得登录前的窗口句柄
	    //getTitle()获取当前页面title的值  
	    System.out.println("当前打开页面的标题是： "+ driver.getTitle());  
	      
	    //关闭并退出浏览器  
	    //driver.quit();  
	  /*  System.setProperty("webdriver.ie.driver", ".\\Tools\\IEDriverServer32.exe");    
	    
	    //初始化一个IE浏览器实例，实例名称叫driver    
	    WebDriver driver = new  InternetExplorerDriver();   
	    //最大化窗口    
	    driver.manage().window().maximize();    
	    //设置隐性等待时间    
	    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);    
	        
	    // get()打开一个站点    
	    driver.get("http://168.168.190.98:8080/gdsclsoa");  
	    String mainHandle=driver.getWindowHandle();      //取得登录前的窗口句柄
	    //getTitle()获取当前页面title的值    
	    System.out.println("当前打开页面的标题是： "+ driver.getTitle());  */   
	    //driver.findElement(By.id("kw")).sendKeys("hello Selenium");
	   // driver.findElement(By.id("su")).click();
	    WebElement username = driver.findElement(By.name("username"));
	    WebElement password = driver.findElement(By.name("password"));
	    //setValueForInput(username, "pengshangde");
	   //setValueForInput(username, "lichunyu");
	    setValueForInput(username, "hongping");
	    setValueForInput(password, "87118711");
	    //btnLogin
	    clickByClass(driver, "btnLogin");
	    //登录成功，跳转到首页面
		  Set<String> set = driver.getWindowHandles(); //创建set集合，即句柄数组
		  Iterator<String> handles = set.iterator(); //迭代器取得所有set集合内容
		
			while (handles.hasNext()) { // 是否还存在句柄
				String sonHandle = handles.next(); // 循环取得各个元素值
				if (!sonHandle.equals(mainHandle)) // “登录后的取得的所有句柄”与“登录之前取得的句柄”进行对比，如果不同则执行窗口跳转
				{
					driver.switchTo().window(sonHandle);
					break;
				}
			}
		  driver.switchTo().frame("main_iframe");
	   /* // 公文管理  top_1
		  clickById(driver, "top_1");
		  // mMenuTitle7
		  clickById(driver, "mMenuTitle8");
		  // sonmenu7_1
		  clickById(driver, "sonmenu8_1");
		  
		  driver.switchTo().frame("detail");
		  //setValueForInput(driver.findElement(By.id("title")), "测试" + System.currentTimeMillis());
		 // setValueForInput(driver.findElement(By.id("rs")), "20");
		  String js = "jQuery('input[id=qzsjStartDate]').attr('readonly',false);jQuery('input[id=qzsjEndDate]').attr('readonly',false);jQuery('input[id=cjgzDate]').attr('readonly',false);jQuery('input[id=cjgzsj]').attr('readonly',false)";
		  ((JavascriptExecutor) driver).executeScript(js);
		  setValueForInput(driver.findElement(By.id("cjgzDate")), "2016-12-14 18:14:51");
		  setValueForInput(driver.findElement(By.id("cjgzsj")), "20");
		  setValueForInput(driver.findElement(By.id("qzsjStartDate")), "2016-12-14 18:14:51");
		  setValueForInput(driver.findElement(By.id("qzsjEndDate")), "2017-12-18 18:14:51"); 
		  setValueForInput(driver.findElement(By.id("qjts")), "20");
		  setValueForInput(driver.findElement(By.id("qjly")), "Travelling");
		  
		  clickById(driver, "finishButton");
		  */
		  
	    //关闭并退出浏览器    
		  try {
			Thread.sleep(1000 * 2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  driver.quit();
	}
	
	private static void openWebOnlyOpen() {
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");  
	    
	    //初始化一个chrome浏览器实例，实例名称叫driver  
	    WebDriver driver = new ChromeDriver();  
	    //最大化窗口  
	    //driver.manage().window().maximize();  
	    //设置隐性等待时间  
	    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);  
	      
	    // get()打开一个站点  
	    driver.get("http://168.168.190.238:8900/gdsclsoa/kf");  
	    String mainHandle=driver.getWindowHandle();      //取得登录前的窗口句柄
	    //getTitle()获取当前页面title的值  
	    System.out.println("当前打开页面的标题是： "+ driver.getTitle());  
	 try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		  driver.quit();
	}
}
