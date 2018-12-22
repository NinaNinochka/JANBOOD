package com.syntax.stepDefinitions;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.syntax.pages.VacancyPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class VacanciesSteps extends BaseClass {
  String   JobTitleManager  ;
  VacancyPage vac;

@Given("^I log in to HRM with credentials \"([^\"]*)\" and \"([^\"]*)\"$")
public void i_log_in_to_HRM_with_credentials_and(String name, String pwd) throws Throwable {
	 driver.findElement(By.id("txtUsername")).sendKeys(name);
	 driver.findElement(By.id("txtPassword")).sendKeys(pwd);
	 driver.findElement(By.id("btnLogin")).click();
}
  

 	
     @Given("^I click Recruitment Module and click Vacancies$")
	public void i_click_Recruitment_Module_and_click_Vacancies() throws Throwable {
		 Thread.sleep(2000);
    	 vac= new VacancyPage();
         vac.GoToVacancies();
     }
  
    @When("^Click Add$")
	public void click_Add() throws Throwable {
    	CommonMethods.click(vac.btnAdd);
	}

    @When("^Select  Job Title to any job Title \"([^\"]*)\"$")
    public void select_Job_Title_to_any_job_Title(String JobTitleManager) throws Throwable {
    	this.JobTitleManager=JobTitleManager;
       CommonMethods.DropDown(vac.AddJobTitle, JobTitleManager);
    }
   
    @When("^Enter  Vacancy Name \"([^\"]*)\"$")
    public void enter_Vacancy_Name(String vacancy) throws Throwable {
    	 CommonMethods.enterValue(vac.VacancyName, vacancy);
    }

    @When("^Enter  Hiring Manager to \"([^\"]*)\"$")
    public void enter_Hiring_Manager_to(String HiringManager) throws Throwable {
    	 CommonMethods.enterValue(vac.hiringManager, HiringManager);
    }

    @When("^Enter  Number Of Positions \"([^\"]*)\"$")
    public void enter_Number_Of_Positions(String position) throws Throwable {
    	CommonMethods.enterValue(vac.numbPosition, position);
    }

    @When("^Enter  Description \"([^\"]*)\"$")
    public void enter_Description(String discription) throws Throwable {
    	CommonMethods.enterValue(vac.Discription, discription);
    }
   
	@When("^I Click Save$")
	public void i_Click_Save() throws Throwable {
		Thread.sleep(2000);
		CommonMethods.click(vac.btnSave);
		CommonMethods.click(vac.bntBack);
	}

	@Then("^I see vacancy details are displayed$")
	public void i_see_vacancy_details_are_displayed() throws Throwable {
		      List <WebElement> row =vac.table.findElements(By.tagName("tr"));
		   for (WebElement webElement : row) {
			String positionName=webElement.getText();
			if(positionName.contains(JobTitleManager)) {
				System.out.println(webElement.isDisplayed());

			}
		}
	}

 	// 2 Scenario

	@When("^I enter following values and click save$")
	public void i_enter_following_values_and_click_save(DataTable Table1) throws Throwable {
		Thread.sleep(3000);
	Table1.asMap(String.class, String.class);
	Map<String, String> map = Table1.asMap(String.class, String.class)  ; 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        CommonMethods.DropDown(vac.jobTitle, map.get("JobTitleManager"));
        CommonMethods.DropDown(vac.jobVacancy, map.get("JobVacancy"));
        CommonMethods.DropDown(vac.Manager, map.get("Manager"));
        CommonMethods.DropDown(vac.status, map.get("Status"));
        CommonMethods.click(vac.Search);
	}

	@Then("^I see Vacancy appears$")
	public void i_see_Vacancy_appears() throws Throwable {
		List<WebElement> row =  vac.table.findElements(By.tagName("tr"));
	     for (WebElement webElement : row) {
			String positionName =webElement.getText();
			if(positionName.contains(JobTitleManager)) {  
			   System.out.println(webElement.isDisplayed());
			      
			}
		}

	}

	// 3 Scenario 

	@When("^Validate Vacancy appears and click on check box and delete$")
	public void validate_Vacancy_appears() throws Throwable {
		List<WebElement> row =  vac.table.findElements(By.tagName("tr"));
	     for (WebElement webElement : row) {
			String positionName =webElement.getText();
			if(positionName.contains(JobTitleManager)) { 
			vac.CheckBox.click();
			CommonMethods.click(vac.Delete);

		}

	}}

}
