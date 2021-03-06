import java.net.MalformedURLException;
import java.net.URL;

import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2Session;
import com.thetransactioncompany.jsonrpc2.client.JSONRPC2SessionException;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		URL serverURL = null;

		try {
			serverURL = new URL("http://jsonrpc.example.com:8080");
			
		} catch (MalformedURLException e) {
			// handle exception...
		}

		// Create new JSON-RPC 2.0 client session
		 JSONRPC2Session mySession = new JSONRPC2Session(serverURL);
		 
		 // Construct new request
		 String method = "getServerTime";
		 int requestID = 0;
		 JSONRPC2Request request = new JSONRPC2Request(method, requestID);

		 // Send request
		 JSONRPC2Response response = null;

		 try {
		         response = mySession.send(request);

		 } catch (JSONRPC2SessionException e) {

		         System.err.println(e.getMessage());
		         // handle exception...
		 }

		 // Print response result / error
		 if (response.indicatesSuccess())
			System.out.println(response.getResult());
		else
			System.out.println(response.getError().getMessage());

	}

}
