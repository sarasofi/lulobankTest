package com.lulobank.certificacion.stepdefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import com.lulobank.certificacion.tasks.MakeADeleteRequest;

import io.cucumber.java.Before;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class DeleteAnEmployee {

	@Before
	public void setup() {
		setTheStage(new OnlineCast());
	}

	@When("I make a resquest to delete an employee with id {string}")
	public void iMakeARequestToDeeleteAnEmployeeWithId(String strId) {
		theActorInTheSpotlight().wasAbleTo(MakeADeleteRequest.toDeleteEmployeeWithId(strId));
	}

}
