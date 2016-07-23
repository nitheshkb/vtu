package VTU.com.nit.vtu.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import VTU.com.nit.vtu.Beans.Department;
import VTU.com.nit.vtu.DAO.DepartmentDAO;

public class DepartmentService {
	@Autowired
	DepartmentDAO departmentDAO;

	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public List<Department> getDepartmentRanks(List<String> year, List<String> sem) {

		List<Department> departments=departmentDAO.getDepartmentRanks(year, sem);
		return departments;
	}

}
