package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TestPage {

	WebDriver driver;

	public TestPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(name = "allbox")
	WebElement togglebox;
	@FindBy(name = "todo[0]")
	WebElement addBox;
	@FindBy(how = How.XPATH, using = "//form//ul//li[1]/input[1]")
	WebElement listToRemove;
	@FindBy(how = How.CSS, using = "input[type ='checkbox']")
	List<WebElement> allList;
	@FindBy(how = How.CSS, using = "input[name='submit'][value='Remove']")
	WebElement removeButton;

	//// form/ul/li/input/following::li[contains(text(),'add123')]
	public void selectToggelCkeckBox() {
		togglebox.click();
		boolean value = false;
		List<WebElement> cb = allList;
		for (WebElement e : cb) {
			value = e.isSelected();
		}
		Assert.assertEquals("All the lists are selected", true, value);
	}

	public void selectListItemToRemove() {
		boolean bs = listToRemove.isDisplayed();
		String beforDeleteText = listToRemove.getAttribute("name");
		listToRemove.click();
		removeButton.click();
		String afterDeleteText = listToRemove.getAttribute("name");
		System.out.println("ad------" + afterDeleteText);
		if (beforDeleteText.equals(afterDeleteText)) {
			Assert.assertTrue("List is not deleted", false);
		} else {
			Assert.assertTrue("List is deleted", true);
		}
	}

	public void allListremoved() {
		togglebox.click();
		boolean toggleSelected = togglebox.isSelected();
		if (toggleSelected == true) {
			removeButton.click();
			}
		boolean status = false;
		for (WebElement e : allList) {
			status = e.isSelected();
		}
		Assert.assertEquals("All the list items are deleted", false, status);
	}
}
