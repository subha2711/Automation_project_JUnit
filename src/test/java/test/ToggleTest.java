package test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.TestPage;
import util.BrowserFactory;

public class ToggleTest {

	WebDriver driver;
	TestPage tp;

	@Before
	public void launchBrowser() {
		driver = BrowserFactory.init();
		tp = PageFactory.initElements(driver, TestPage.class);
	}

	@Test
	public void validateToggleAllCheckBoxAndAddBoxIsSelected() {
		tp.selectToggelCkeckBox();
	}

	@Test
	public void validateSeletedListIsRemovedUsingRemoveButton() {
		tp.selectListItemToRemove();
	}
	
	@Test 
	public void validateAllListItemsRemovedWhenToggleIsSelectedAndremovedIsClicked() {
		tp.allListremoved();
	}

	 @After
	public void closeBrowser() {
		BrowserFactory.tearDown();
	}
}
