package com.lulobank.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseHasStringInfo implements Question<String> {

	private String attribute;

	public ResponseHasStringInfo(String attribute) {
		this.attribute = attribute;
	}

	@Override
	public String answeredBy(Actor actor) {
		return actor.recall(attribute);
	}

	public static ResponseHasStringInfo the(String attribute) {
		return new ResponseHasStringInfo(attribute);
	}

}
