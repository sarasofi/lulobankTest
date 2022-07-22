package com.lulobank.certificacion.stepdefinitions;

import static com.lulobank.certificacion.utils.Constants.API_URL;
import static com.lulobank.certificacion.utils.Constants.STATUS_CODE;
import static com.lulobank.certificacion.utils.Constants.STATUS;
import static com.lulobank.certificacion.utils.Constants.SUCCESS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import org.hamcrest.core.IsEqual;

import com.lulobank.certificacion.exceptions.SomethingWhentWrong;
import com.lulobank.certificacion.questions.ResponseHas;
import com.lulobank.certificacion.questions.ResponseHasStringInfo;
import com.lulobank.certificacion.tasks.MakeAGetRequest;
import com.lulobank.certificacion.tasks.SaveResponse;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class GetRequest {

	@Before
	public void setup() {
		setTheStage(new OnlineCast());
	}

	@Given("I want make a request on dummy API")
	public void iWantMakeARequestOnDummyAPI() {
		theActorCalled("tester").whoCan(CallAnApi.at(API_URL));
	}

	@When("I make a get request")
	public void iMakeAGetRequest() {
		theActorInTheSpotlight().wasAbleTo(MakeAGetRequest.forEmployees(),SaveResponse.status());
	}

	@Then("I validate the body and the status code {int}")
	public void iValidateTheBodyAndTheStatusCode(int intCode) {
		theActorInTheSpotlight().should(seeThat(ResponseHas.the(STATUS_CODE), IsEqual.equalTo(intCode))
				.orComplainWith(SomethingWhentWrong.class, "Unexpected response"),
				seeThat(ResponseHasStringInfo.the(STATUS), IsEqual.equalTo(SUCCESS))
				.orComplainWith(SomethingWhentWrong.class, "Unexpected response"));
	}

}
