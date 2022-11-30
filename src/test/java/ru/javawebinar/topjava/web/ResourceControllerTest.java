package ru.javawebinar.topjava.web;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ResourceControllerTest {

	private static HttpURLConnection con;

	@BeforeAll
	static void connection() throws IOException {
		URL url = new URL("http://localhost:8080/topjava/resources/css/style.css");
		con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.connect();
	}

	@Test
	void checkStatus() throws IOException {
		Assertions.assertEquals(con.getResponseCode(), 200);
	}

	@Test
	void checkContentType() {
		Assertions.assertEquals(con.getContentType(), "text/css;charset=UTF-8");
	}
}
