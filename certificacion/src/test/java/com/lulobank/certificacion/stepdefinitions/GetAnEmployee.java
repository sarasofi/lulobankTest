package com.lulobank.certificacion.stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.lulobank.certificacion.tasks.MakeAGetRequest;
import com.lulobank.certificacion.tasks.SaveResponse;

import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class GetAnEmployee {

	@Before
	public void setup() {
		setTheStage(new OnlineCast());
	}

	@When("I make a resquest to get an employee with id {string}")
	public void iMakeARequestToGetAnEmployeeWithId(String strId) {
		theActorInTheSpotlight().wasAbleTo(MakeAGetRequest.forTheEmployeeWithId(strId), SaveResponse.status());
	}

}
