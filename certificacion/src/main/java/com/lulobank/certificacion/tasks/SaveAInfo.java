package com.lulobank.certificacion.tasks;

import com.lulobank.certificacion.interactions.ConvertResponseToJson;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SaveAInfo implements Task {
	private String strAttribute;

	public SaveAInfo(String strAttribute) {
		this.strAttribute = strAttribute;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(ConvertResponseToJson.withAtribute(strAttribute));
	}

	public static SaveAInfo withData(String strAttribute) {
		return Tasks.instrumented(SaveAInfo.class, strAttribute);
	}

}
