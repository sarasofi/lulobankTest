package com.lulobank.certificacion.tasks;

import static com.lulobank.certificacion.utils.Constants.END_POINT;
import static com.lulobank.certificacion.utils.Constants.NAME;
import static com.lulobank.certificacion.utils.Constants.POST_EMPLOYEES;
import static com.lulobank.certificacion.utils.Constants.STATUS_CODE;

import java.util.Map;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class MakeAPostRequest implements Task {
	private String strEndPoint;
	private Map<String, String> mapData;
	private static final String CONTENT_TYPE = "application/json";

	public MakeAPostRequest(String strEndPoint, Map<String, String> mapData) {
		this.strEndPoint = strEndPoint;
		this.mapData = mapData;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(
				Post.to(END_POINT.concat(strEndPoint)).with(request -> request.contentType(CONTENT_TYPE).body(mapData)),
				SaveAInfo.withData(NAME));
		actor.remember(STATUS_CODE, SerenityRest.lastResponse().getStatusCode());

	}

	public static MakeAPostRequest withData(Map<String, String> mapData) {
		return Tasks.instrumented(MakeAPostRequest.class, POST_EMPLOYEES, mapData);
	}

}
