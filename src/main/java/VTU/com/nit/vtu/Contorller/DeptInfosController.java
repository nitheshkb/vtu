package VTU.com.nit.vtu.Contorller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import VTU.com.nit.vtu.Beans.Department;
import VTU.com.nit.vtu.Beans.Series;
import VTU.com.nit.vtu.Service.DepartmentService;

@Path("/department")
public class DeptInfosController {


/*	@Autowired
	private DepartmentService departmentService;
*/
	@Autowired private ApplicationContext applicationContext;


	@Path("/rank")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Series> getDepartmentRank(@Context UriInfo uriInfo,@Context HttpServletRequest servletRequest){
		MultivaluedMap<String, String> uriQuery = uriInfo.getQueryParameters();

		
		DepartmentService departmentService = (DepartmentService) applicationContext.getBean("departmentService");
		
		List<Department> dept = departmentService.getDepartmentRanks(uriQuery.get("year"),uriQuery.get("sem"));
		Series ser = new Series();
		ser.setData(dept);
		List<Series> ser1 = new ArrayList<Series>();
		ser1.add(ser);
		return ser1;

	}
}
