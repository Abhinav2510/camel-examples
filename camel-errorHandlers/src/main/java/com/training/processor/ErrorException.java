package com.training.processor;

import java.io.IOException;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ErrorException implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		System.out.println("Custom processior");
		throw new IOException();
	}

}
