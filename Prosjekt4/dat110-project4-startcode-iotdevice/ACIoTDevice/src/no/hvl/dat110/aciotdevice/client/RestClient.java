package no.hvl.dat110.aciotdevice.client;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.Charset;

import com.google.gson.Gson;

import rawhttp.core.RawHttp;
import rawhttp.core.RawHttpRequest;
import rawhttp.core.RawHttpResponse;
import rawhttp.core.body.StringBody;

public class RestClient {

	public RestClient() {
		// TODO Auto-generated constructor stub
	}

	private static String logpath = "/accessdevice/log";

	public void doPostAccessEntry(String message) {

		// TODO: implement a HTTP POST on the service to post the message

		AccessMessage accessMessage = new AccessMessage(message);

		try (Socket s = new Socket(Configuration.host, Configuration.port)) {
			Gson gson = new Gson();
			String jsonBody = gson.toJson(accessMessage);

			RawHttp http = new RawHttp();

			RawHttpRequest request = http.parseRequest(
					"POST " + logpath + "\n" +
							"Host: " + Configuration.host
			).withBody(
					new StringBody(jsonBody, "application/json")
			);

			request.writeTo(s.getOutputStream());

			RawHttpResponse<Void> response = http.parseResponse(s.getInputStream());

			System.out.println(response.eagerly());

		} catch (IOException ex) {
			System.err.println(ex);
		}
		
	}
	
	private static String codepath = "/accessdevice/code";
	
	public AccessCode doGetAccessCode() {

		AccessCode code = null;
		
		// TODO: implement a HTTP GET on the service to get current access code
		
		return code;
	}
}
