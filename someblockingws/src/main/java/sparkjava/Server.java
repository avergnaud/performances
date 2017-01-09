package sparkjava;

import static spark.Spark.get;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Server {

	public static void main(String[] args) {

		Gson gson = new GsonBuilder()
			.setPrettyPrinting()
			.create();

		//http://localhost:4567/answerMe/adrien
		get("/answerMe/:name", Route::answerMe, gson::toJson);

		//http://localhost:4567/faster/toto
		get("/faster/:name", Route::faster, gson::toJson);

		//http://localhost:4567/hello
		get("/hello", (req, res) -> "Hello World");
	}

}
