package com.lulobank.certificacion.stepdefinitions;

import static com.lulobank.certificacion.utils.Constants.NAME;
import static com.lulobank.certificacion.utils.Constants.STATUS_CODE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.Map;

import org.hamcrest.core.IsEqual;

import com.lulobank.certificacion.exceptions.SomethingWhentWrong;
import com.lulobank.certificacion.questions.ResponseHas;
import com.lulobank.certificacion.questions.ResponseHasStringInfo;
import com.lulobank.certificacion.tasks.MakeAPostRequest;
import com.lulobank.certificacion.tasks.SaveResponse;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class PostRequest {
	String strName;

	@Before
	public void setup() {
		setTheStage(new OnlineCast());
	}

	@When("I make a post request to create a employee")
	public void iMakeAPostRequestToCreateAEmployee(DataTable dataTable) {
		Map<String, String> mapData = dataTable.asMap(String.class, String.class);
		strName = mapData.get(NAME);
		theActorInTheSpotlight().wasAbleTo(MakeAPostRequest.withData(mapData), SaveResponse.status());
	}

	@Then("I validate the response of the post request and the status code {int}")
	public void iValidateTheResponseOfThePostRequestAndTheStatusCode(int intCode) {
		theActorInTheSpotlight().should(
				seeThat(ResponseHas.the(STATUS_CODE), IsEqual.equalTo(intCode))
						.orComplainWith(SomethingWhentWrong.class, "Unexpected response"),
				seeThat(ResponseHasStringInfo.the(NAME), IsEqual.equalTo(strName))
						.orComplainWith(SomethingWhentWrong.class, "Unexpected name"));
	}

}
