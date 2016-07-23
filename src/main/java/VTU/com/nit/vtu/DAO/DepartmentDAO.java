package VTU.com.nit.vtu.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import VTU.com.nit.vtu.Beans.Department;

public class DepartmentDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Department> getDepartmentRanks(List<String> year, List<String> sem) {
	String sql = "select totaltab.department,passcount,total,(passcount*1.0*100/total) as percent from (select department,count(*) total from student where sem=? and year=? group by department) totaltab join (select department,count(*) as passcount from student where sem=? and semresult != 'FAIL'  and year=? group by department) passtab on totaltab.department=passtab.department order by percent desc";

		List<Department> departments = (List<Department>) jdbcTemplate.query(sql,
				new Object[] { sem.get(0), year.get(0), sem.get(0), year.get(0) }, new DepartmentMapper());

		return departments;
	}

}

class DepartmentMapper implements RowMapper<Department> {

	@Override
	public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Department department = new Department();
		department.setName(rs.getString("department"));
		department.setY(rs.getFloat("percent"));
		return department;
	}

}



