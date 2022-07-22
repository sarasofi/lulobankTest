package com.lulobank.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseHas implements Question<Integer> {

	private String attribute;

	public ResponseHas(String attribute) {
		this.attribute = attribute;
	}

	@Override
	public Integer answeredBy(Actor actor) {
		return actor.recall(attribute);
	}

	public static ResponseHas the(String attribute) {
		return new ResponseHas(attribute);
	}

}
