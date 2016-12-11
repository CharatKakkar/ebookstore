package utilities;

import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.RandomStringUtils;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class Helper {

	private final String username;
	private final String userId;
	private static WebResource webResource;
	private static ClientResponse response;
	private static Client client;

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

	public static Helper createUser() {

		String username = "testuser" + RandomStringUtils.randomAlphabetic(4).toLowerCase();
		String userId = "";
		client = Client.create();
		webResource = client.resource(Constants.apiURLUsers);
		WebResource.Builder postBuilder = webResource.accept(MediaType.APPLICATION_JSON);
		postBuilder.type(MediaType.APPLICATION_JSON_TYPE);
		postBuilder.header("kf-api-key", Constants.apiKey);
		String postInput = "{'first_name': '" + username + "', 'last_name': '2','email': '" + username
				+ "@klipfolio.com', 'roles': ['26a3d3fb4cd6bf23d35b4126be26e5f3'],'password': 'password'}";
		response = postBuilder.post(ClientResponse.class, postInput);
		if (response.getStatus() == 201) {
			userId = response.getEntity(String.class).substring(56, 88);
		}
		return new Helper(username, userId);
	}

	public static void deleteUser(String userId) {
		client = Client.create();
		webResource = client.resource(Constants.apiURLUsers + "/" + userId);
		WebResource.Builder delBuilder = webResource.accept(MediaType.APPLICATION_JSON);
		delBuilder.type(MediaType.APPLICATION_JSON_TYPE);
		delBuilder.header("kf-api-key", "75d015295fc8e278552a4b150deec07e85cf8dc7");
		response = delBuilder.delete(ClientResponse.class);
		if (response.getStatus() == 200) {
			System.out.println("User has been deleted ");
		}

	}

}
