package com.lulobank.certificacion.tasks;

import static com.lulobank.certificacion.utils.Constants.DELETE_EMPLOYEE;
import static com.lulobank.certificacion.utils.Constants.STATUS_CODE;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class MakeADeleteRequest implements Task {
	private String strEndPoint;

	public MakeADeleteRequest(String strEndPoint) {
		this.strEndPoint = strEndPoint;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Delete.from(strEndPoint));
		actor.remember(STATUS_CODE, SerenityRest.lastResponse().getStatusCode());
	}

	public static MakeADeleteRequest toDeleteEmployeeWithId(String strId) {
		return Tasks.instrumented(MakeADeleteRequest.class, DELETE_EMPLOYEE.concat(strId));
	}

}
