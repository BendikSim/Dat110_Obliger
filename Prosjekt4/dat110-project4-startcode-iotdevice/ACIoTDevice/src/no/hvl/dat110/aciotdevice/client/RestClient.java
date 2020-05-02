package no.hvl.dat110.aciotdevice.client;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;


public class RestClient {

	public RestClient() {
	}

	public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	private static String logpath = "/accessdevice/log";

	public void doPostAccessEntry(String message) {

		// TODO: implement a HTTP POST on the service to post the message
		OkHttpClient client = new OkHttpClient();
		Gson gson = new Gson();
		AccessMessage msg = new AccessMessage(message);
		RequestBody body = RequestBody.create(JSON, gson.toJson(msg));

		// construct the Get request
		Request request = new Request.Builder()
				.url("http://localhost:8080/accessdevice/log/")
				.post(body)
				.build();

		System.out.println(request);

		try (Response response = client.newCall(request).execute()) {
			System.out.println(response.body().string());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static String codepath = "/accessdevice/code";
	
	public AccessCode doGetAccessCode() {

		AccessCode code = null;
		
		// TODO: implement a HTTP GET on the service to get current access code
		OkHttpClient client = new OkHttpClient();
		Gson gson = new Gson();

		// construct the HTTP request
		Request request = new Request.Builder()
				.url("http://localhost:8080/accessdevice/code")
				.get()
				.build();

		System.out.println(request);

		try (Response response = client.newCall(request).execute()) {
			String body = response.body().string();
			System.out.println(body);
			code = gson.fromJson(body, AccessCode.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return code;
	}
}
