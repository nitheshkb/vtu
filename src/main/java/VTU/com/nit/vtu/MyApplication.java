package VTU.com.nit.vtu;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import VTU.com.nit.vtu.Contorller.DeptInfosController;

/**
 * Spring HelloWorld Web Application configuration.
 *
 * @author Jakub Podlesak (jakub.podlesak at oracle.com)
 */
public class MyApplication extends ResourceConfig {

	/**
	 * Register JAX-RS application components.
	 */
	public MyApplication() {
		register(RequestContextFilter.class);
		register(MyResource.class);
		register(DeptInfosController.class);
		register(UserValidation.class);

	}
}