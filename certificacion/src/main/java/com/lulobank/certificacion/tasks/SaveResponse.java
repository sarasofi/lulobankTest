package com.lulobank.certificacion.tasks;

import static com.lulobank.certificacion.utils.Constants.ID;
import static com.lulobank.certificacion.utils.Constants.STATUS;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SaveResponse implements Task {
	
	private String strName;
	private String strAttribute;

	public SaveResponse(String strName, String strAttribute) {
		this.strName = strName;
		this.strAttribute = strAttribute;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.remember(strName, SerenityRest.lastResponse().getBody().jsonPath().get(strAttribute).toString());
	}

	public static SaveResponse id() {
		return Tasks.instrumented(SaveResponse.class,ID,"data");
	}
	
	public static SaveResponse status() {
		return Tasks.instrumented(SaveResponse.class,STATUS,STATUS);
	}

}
