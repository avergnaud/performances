package com.catamania;

import org.jboss.resteasy.client.*;

/*
   calls someblockingws
 */
public class CompoundService {

/* appelle un service REST (someblockingws) lent à répondre */
public String get(String name) {

  String result = "";

try {
  ClientRequest request = new ClientRequest("http://localhost:4567/answerMe/" + name);
  ClientResponse<String> response = request.get(String.class);
  result = response.getEntity();
} catch(Exception e) {e.printStackTrace();}

  return result;
}

/* appelle un service REST (someblockingws) plus rapide */
public String getfaster(String name) {

  String result = "";

try {
  ClientRequest request = new ClientRequest("http://localhost:4567/faster/" + name);
  ClientResponse<String> response = request.get(String.class);
  result = response.getEntity();
} catch(Exception e) {e.printStackTrace();}

  return result;
}

}
