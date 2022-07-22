package com.lulobank.certificacion.interactions;

import static com.lulobank.certificacion.utils.Constants.COLON;
import static com.lulobank.certificacion.utils.Constants.DATA;
import static com.lulobank.certificacion.utils.Constants.EQUAL;

import org.json.JSONObject;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class ConvertResponseToJson implements Interaction {

	private String strAttribute;

	public ConvertResponseToJson(String strAttribute) {
		this.strAttribute = strAttribute;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		String strJson = SerenityRest.lastResponse().jsonPath().get(DATA).toString();
		strJson = strJson.replace(EQUAL, COLON);
		JSONObject obj = new JSONObject(strJson);
		actor.remember(strAttribute, obj.get(strAttribute));
	}

	public static ConvertResponseToJson withAtribute(String strAttribute) {
		return Tasks.instrumented(ConvertResponseToJson.class, strAttribute);
	}

}
