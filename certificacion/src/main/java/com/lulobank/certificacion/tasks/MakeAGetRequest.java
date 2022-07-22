package com.lulobank.certificacion.tasks;

import static com.lulobank.certificacion.utils.Constants.END_POINT;
import static com.lulobank.certificacion.utils.Constants.GET_EMPLOYEE;
import static com.lulobank.certificacion.utils.Constants.GET_EMPLOYEES;
import static com.lulobank.certificacion.utils.Constants.STATUS_CODE;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class MakeAGetRequest implements Task {
	private String strEndPoint;

	public MakeAGetRequest(String strEndPoint) {
		this.strEndPoint = strEndPoint;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(Get.resource(END_POINT.concat(strEndPoint)));
		actor.remember(STATUS_CODE, SerenityRest.lastResponse().getStatusCode());
		System.out.println(actor.recall(STATUS_CODE).toString());
	}

	public static MakeAGetRequest forEmployees() {
		return Tasks.instrumented(MakeAGetRequest.class, GET_EMPLOYEES);
	}

	public static MakeAGetRequest forTheEmployeeWithId(String strId) {
		return Tasks.instrumented(MakeAGetRequest.class, GET_EMPLOYEE.concat(strId));
	}

}
