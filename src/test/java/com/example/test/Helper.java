package com.example.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.RandomStringUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Helper {

	private final String username;
	private final String userId;
	WebResource webResourcePost;

	public Helper(String username, String userId) {
		this.username = username;
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public String getUserId() {
		return userId;
	}

	public static Helper getInfo() {

		String username = "testuser" + RandomStringUtils.randomAlphabetic(4);
		String userId = "";

		Client client = Client.create();
		WebResource webResourcePost = client.resource("https://app.klipfolio.com/api/1/users");
		WebResource.Builder postBuilder = webResourcePost.accept(MediaType.APPLICATION_JSON);
		postBuilder.type(MediaType.APPLICATION_JSON_TYPE);
		postBuilder.header("kf-api-key", "75d015295fc8e278552a4b150deec07e85cf8dc7");
		String postInput = "{'first_name': '" + username + "', 'last_name': '2','email': '" + username
				+ "@klipfolio.com', 'roles': ['26a3d3fb4cd6bf23d35b4126be26e5f3'],'password': 'password'}";
		ClientResponse postResponse = postBuilder.post(ClientResponse.class, postInput);
		if (postResponse.getStatus() == 201) {
			userId = postResponse.getEntity(String.class).substring(56, 88);
		}

		return new Helper(username, userId);

		// WebResource webResourceGet =
		// client.resource("https://app.klipfolio.com/api/1/roles");
		// WebResource.Builder getBuilder =
		// webResourceGet.accept(MediaType.APPLICATION_JSON);
		// getBuilder.type(MediaType.APPLICATION_JSON_TYPE);
		// getBuilder.header("kf-api-key",
		// "75d015295fc8e278552a4b150deec07e85cf8dc7");
		//
		// ClientResponse getResponse = getBuilder.get(ClientResponse.class);
		// System.out.println("Get Response is " + getResponse.getStatus());
		// String getOutput = getResponse.getEntity(String.class);
		//
		//
		//
		//
		// System.out.println(getOutput);
	}

	public static void deleteUser(String userId) {

		System.out.println("new message" + userId);

		Client client = Client.create();
		WebResource webResourceDel;

		try {
			webResourceDel = client
					.resource("https://app.klipfolio.com/api/1/users/" + URLEncoder.encode(userId, "UTF-8"));

			WebResource.Builder delBuilder = webResourceDel.accept(MediaType.APPLICATION_JSON);
			delBuilder.type(MediaType.APPLICATION_JSON_TYPE);
			delBuilder.header("kf-api-key", "75d015295fc8e278552a4b150deec07e85cf8dc7");
			ClientResponse delResponse = delBuilder.delete(ClientResponse.class);
			System.out.println(delResponse);
			if (delResponse.getStatus() == 200) {
				System.out.println("User has been deleted ");
			}
		}

		catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// WebResource webResourceDel =
		// client.resource("https://app.klipfolio.com/api/1/users/" + userId);

	}

}
