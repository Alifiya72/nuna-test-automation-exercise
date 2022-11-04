package com.google.translate.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.translate.page.BasePage;

public class HomePage extends BasePage {

	@FindBy(css = "div.akczyd button[aria-label='More source languages']")
	private WebElement sourceLangDrpdwn;
	
	@FindBy(css = "div[class='vSUSRc']")
	private List<WebElement> langDrpdwnOpen;

	@FindBy(css = ".OlSOob > c-wiz[role='main'] .kHGNJd  .bvzp8c > .OoYv6d > .X4hZJc.pEyuac > .MeCBDd.dykxn.j33Gae > .vSUSRc > .F29iQc >.qSb8Pe >.Llmcnf")
	private List<WebElement> sourceLangauages;
	
	@FindBy(css = "div.OoYv6d input[aria-label='Search languages']")
	private WebElement sourceLangauagesSearchBox;
	
	@FindBy(css = "div.akczyd button[aria-label='More target languages']")
	private WebElement translateLangDrpdwn;

	@FindBy(css = ".DlHcnf.bvzp8c > .ykTHSe > .X4hZJc.pEyuac .F29iQc > .qSb8Pe > .Llmcnf")
	private List<WebElement> translateLangauages;
	
	@FindBy(css = "div.ykTHSe input[aria-label='Search languages']")
	private WebElement translateLangauagesSearchBox;

	@FindBy(css = "textarea[aria-label='Source text']")
	private WebElement sourceText;

	@FindBy(css = "textarea[aria-label='Source text']")
	private WebElement sourceTextBox;
	
	@FindBy(css = "span[jsname='W297wb']")
	private WebElement translatedPrimaryOutput;

	@FindBy(css = ".NWlwsb > .WtlSJf")
	private List<WebElement> translatedAlternateValues;

	@FindBy(css = "div[jscontroller='HwavCb'] button")
	private WebElement swapLangButton;

	@FindBy(css = ".VfPpkd-Bz112c-LgbsSe.VfPpkd-Bz112c-LgbsSe-OWXEXe-e5LLRc-SxQuSe.yHy1rc.eT1oJ.mN1ivc.qiN4Vb.GA2I6e")
	private WebElement clearSourceText;

	@FindBy(css = "a:nth-of-type(2) > .ita-kd-arrow.ita-kd-icon-span.ita-kd-img")
	private WebElement selectInputTool;

	@FindBy(xpath = "//*[@id=\"yDmH0d\"]/ul/li[1]/span[3]")
	private WebElement screenKeyboard;

	@FindBy(xpath = "//*[@id='K72']")
	private WebElement screenKeyboardLetterH;

	@FindBy(xpath = "//*[@id='K73']")
	private WebElement screenKeyboardLetterI;

	@FindBy(xpath = "//*[@id='K49']")
	private WebElement screenKeyboardLetterExclamation;

	@FindBy(css = ".vk-btn:nth-of-type(1) .vk-sf-c16")
	private WebElement screenKeyboardToggleCase;

	@FindBy(css = ".swFHJd")
	private WebElement translatedTextInput;
	
	@FindBy(css = "div[class='DNFg3e']")
	private List<WebElement> resultValuesOpen;

	private  String siteUrl = null;

	public HomePage(WebDriver driver, String siteUrl) {
		super(driver);
		this.siteUrl = siteUrl;
	}

	public void load(){
		driver.get(siteUrl);
	}

	public void clickSourceLangDrpdwn(){
		sourceLangDrpdwn.click();

	}

	public void selectSourceLangDrpdwn(String sourceLang) throws InterruptedException{
		for (WebElement element : sourceLangauages) {
			if(element.getText().equalsIgnoreCase(sourceLang)) {
				element.click();
				wait.until(ExpectedConditions.invisibilityOfAllElements(langDrpdwnOpen));
				break;
			}
		}
	}
	
	public void enterSourceLang(String sourceLang) throws InterruptedException{
		//wait.until(ExpectedConditions.invisibilityOfAllElements(sourceLangauagesSearchBox));
		sourceLangauagesSearchBox.sendKeys(sourceLang);
		//wait.until(ExpectedConditions.invisibilityOfAllElements(sourceLangauagesSearchBox));
		sourceLangauagesSearchBox.sendKeys(Keys.ENTER);
	}
	
	public void enterTranslateLang(String targetLang) throws InterruptedException{
		//wait.until(ExpectedConditions.invisibilityOfAllElements(translateLangauagesSearchBox));
		translateLangauagesSearchBox.sendKeys(targetLang);
		//wait.until(ExpectedConditions.invisibilityOfAllElements(translateLangauagesSearchBox));
		translateLangauagesSearchBox.sendKeys(Keys.ENTER);
	}

	public void clickTranslateLangDrpdwn(){
		translateLangDrpdwn.click();

	}

	public WebElement getTranslatedOutputElement(){
		return translatedPrimaryOutput;

	}
	
	public List<WebElement> resultValuesOpen(){
		return resultValuesOpen;

	}

	public List<WebElement> getTranslatedAlternateValues(){
		return translatedAlternateValues;

	}

	public void selectTranslateLangDrpdwn(String translateLang) throws InterruptedException {
		for (WebElement element : translateLangauages) {
			if(element.getText().equalsIgnoreCase(translateLang)) {
				element.click();
				wait.until(ExpectedConditions.invisibilityOfAllElements(langDrpdwnOpen));
				break;
			}
		}
	}

	public void enterInitialText(String initialText) throws InterruptedException{
		sourceText.sendKeys(initialText);

	}

	public void clickswapLangButton() throws InterruptedException{
		swapLangButton.click();
		Thread.sleep(2000); //todo: need to update with driver wait

	}

	public void enterUsingScreenKeyboard() throws InterruptedException{

		clearSourceText.click();
		selectInputTool.click();
		screenKeyboard.click();
		screenKeyboardToggleCase.click();
		screenKeyboardLetterH.click();
		screenKeyboardLetterI.click();
		screenKeyboardToggleCase.click();
		screenKeyboardLetterExclamation.click();

	}


}
