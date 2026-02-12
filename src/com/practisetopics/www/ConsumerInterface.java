package com.practisetopics.www;

import java.util.function.Consumer;

public class ConsumerInterface {
	public static void main(String[] args) {
		Consumer<String> fullNal=(a)->System.out.println("Hi "+a);;
		
		fullNal.accept("Deepanshu");
	}
}
