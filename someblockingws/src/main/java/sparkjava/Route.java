package sparkjava;

import spark.Request;
import spark.Response;
import java.util.concurrent.ThreadLocalRandom;

public class Route {

	/* méthode très lente à répondre */
	public static String answerMe(Request request, Response response) {
		String name = request.params("name");
		int i = ThreadLocalRandom.current().nextInt(10_000, 20_000);/* ten to twenty secs */
		try {
			Thread.sleep(i);
		} catch(InterruptedException e) {e.printStackTrace();}
		return "Hello " + name + " I have been waiting for " + i + " ms";
	}

	/* répond rapidement */
	public static String faster(Request request, Response response) {
		String name = request.params("name");
		return "Hello " + name;
	}
}
