package VTU.com.nit.vtu;

import java.io.IOException;
import java.util.Base64;
import java.util.StringTokenizer;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("api")
public class UserValidation {

	@POST
	@Path("authenticate")
	@Produces(MediaType.APPLICATION_JSON)
	public String Authuser(@Context HttpServletRequest servletRequest) {
 
		System.out.println("" + servletRequest);
		String authCredentials = servletRequest.getHeader("Authorization");
		authenticate(authCredentials);
		JsonObject jo=Json.createObjectBuilder()
	            .add("success", true).build();
		String aa=jo.toString();
		return aa;
	}
	
	public boolean authenticate(String authCredentials) {

		if (null == authCredentials)
			return false;
		// header value format will be "Basic encodedstring" for Basic
		// authentication. Example "Basic YWRtaW46YWRtaW4="
		final String encodedUserPassword = authCredentials.replaceFirst("Basic"
				+ " ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = Base64.getDecoder().decode(
					encodedUserPassword);
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		final StringTokenizer tokenizer = new StringTokenizer(
				usernameAndPassword, ":");
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();

		// we have fixed the userid and password as admin
		// call some UserService/LDAP here
		boolean authenticationStatus = "admin".equals(username)
				&& "admin".equals(password);
		System.out.println(username+"  "+password);
		return authenticationStatus;
	}
}
