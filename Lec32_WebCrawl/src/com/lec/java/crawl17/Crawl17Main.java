package com.lec.java.crawl17;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * Selenium 라이브러리 다운로드 (Java 버젼으로!)
 * 	https://www.seleniumhq.org/download/
 * 
 *  BuildPath 추가
 *  
 * 브라우저 드라이버 다운로드 
 *  http://chromedriver.chromium.org/downloads
 *  
 *  
 */

public class Crawl17Main {

	// WebDriver
	private WebDriver driver;
	private WebElement element;
	private String url;
	
	private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	private static final String WEB_DRIVER_PATH = "D:/JavaApp1/download/chromedriver.exe";
	
	public static void main(String[] args) {
		System.out.println("Selenium 사용");
		
		Crawl17Main app = new Crawl17Main();
		app.init();
		//app.naverLogin();
		//app.likeFaceBook();
		
		app.naverRelated("파이썬");
		
		
		
		System.out.println("\n프로그램 종료");

	} // end main()

	public void init() {
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		
		// Driver setup
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		driver = new ChromeDriver(options); //제어되는 브라우저 가동!
		// driver를 통해서 브라우저 제어
		
	} // end init()
	
	// Naver 로그인
	public void naverLogin() {
		String url = "https://nid.naver.com/nidlogin.login";
		driver.get(url); //url주소로 이동
		
		
		// 아이디 입력
		element = driver.findElement(By.id("id"));
		//System.out.println(element.getSize());
		element.sendKeys("??"); //키보드 타이핑 입력
		
		//패스워드 입력
		element = driver.findElement(By.id("pw"));
		element.sendKeys("123");
		
		// 로그인 버튼 클릭
		element =driver.findElement(By.className("btn_global"));
		element.click();
		
	} // end naverLogin()
	
	// Facebook  로그인 & 좋아요 클릭
	public void likeFaceBook() {
		String url = "https://ko-kr.facebook.com/";
		driver.get(url);
		
		driver.findElement(By.id("email")).sendKeys("아이디");
		driver.findElement(By.id("pass")).sendKeys("비번");
		driver.findElement(By.id("pass")).sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		url = "페북 특정 게시물 url";
		driver.get(url); //게시물 이동
		
		// 종아요 element 찾기
		
		// 좋아요 element 클릭하기
		
	} // end likeFaceBook()

	public void naverRelated(String keyword) {
		driver.get("https://www.naver.com");
		driver.findElement(By.id("query")).sendKeys(keyword);;
		driver.findElement(By.id("query")).sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		List<WebElement> list = driver.findElements(By.cssSelector(".lst_relate ul li"));
		System.out.println(list.size()+"개");
		
		for(WebElement e: list) {
			System.out.println(e.findElement(By.tagName("a")).getText().trim());
		} // end for
		
	} // end naverRalated()
	
} // end class