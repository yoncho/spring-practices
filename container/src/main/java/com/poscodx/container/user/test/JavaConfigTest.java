package com.poscodx.container.user.test;

public class JavaConfigTest {
	public static void main(String[] args) {
		testJavaConfigTest();
	}

	private static void testJavaConfigTest() {
		new AnnotationConfigApplicationContext(AppConfig.class);
	}
}
