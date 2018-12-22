package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

public class VacancyPage extends BaseClass {

	
	@FindBy(id="menu_recruitment_viewRecruitmentModule")
	public WebElement RecruitmentBnt;
	
	@FindBy(id="menu_recruitment_viewJobVacancy")
	public WebElement VacanciesBnt;
	
	@FindBy(id="btnAdd")
	public WebElement btnAdd;
	
	@FindBy(id="addJobVacancy_jobTitle")
	public WebElement AddJobTitle;
	
	@FindBy(id="addJobVacancy_name")
	public WebElement VacancyName;
	
	@FindBy(id="addJobVacancy_hiringManager")
	public WebElement hiringManager;
	
	@FindBy(id="addJobVacancy_noOfPositions")
	public WebElement numbPosition;
	
	@FindBy(id="addJobVacancy_description")
	public WebElement Discription;
	
	@FindBy(id="btnSave")
	public WebElement btnSave;
	
	@FindBy(id="btnBack")
	public WebElement bntBack;
	
//***********************************************************Vacancies page 2 nd
	
	@FindBy(id="vacancySearch_jobTitle")
	public WebElement jobTitle;
	
	@FindBy(id="vacancySearch_jobVacancy")
	public WebElement jobVacancy;
	
	@FindBy(id="vacancySearch_hiringManager")
	public WebElement Manager;
	
	@FindBy(id="vacancySearch_status")
	public WebElement status;
	
	@FindBy(id="btnSrch")
	public WebElement Search;
	
	@FindBy(xpath="//table[@class='table hover']//tbody")
	public WebElement table;
	
	@FindBy(id="ohrmList_chkSelectRecord_3")
	public WebElement CheckBox;
	
	@FindBy(id="btnDelete")
	public WebElement Delete;

	

	 public VacancyPage() {
		  PageFactory.initElements(driver, this);
	 }
	
	
	 public void GoToVacancies() {
		CommonMethods.click(RecruitmentBnt); 
		CommonMethods.click(VacanciesBnt);
		 
		}
	 
}

