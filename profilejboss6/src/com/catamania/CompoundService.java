package com.catamania;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

/*
   calls someblockingws
 */
public enum CompoundService {

	INSTANCE;

	/* appelle un service REST (someblockingws) lent à répondre */
	public String get(String name) throws ClientProtocolException, IOException {

//		String result = "";

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://localhost:4567/answerMe/" + name);
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		return rd.readLine();
	}

	/* appelle un service REST (someblockingws) plus rapide */
	public String faster(String name) throws ClientProtocolException, IOException {

//		String result = "";

		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet("http://localhost:4567/faster/" + name);
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		return rd.readLine();
	}

}
