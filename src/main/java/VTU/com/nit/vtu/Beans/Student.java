package VTU.com.nit.vtu.Beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student implements Serializable{

	@Id
	String ID;
	@Id
	String sem;
	@Id
	String year;
	@Id
	String department;
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSemresult() {
		return semresult;
	}

	public void setSemresult(String semresult) {
		this.semresult = semresult;
	}

	String Name;
	
	@ElementCollection
	List<Subject> subjects ;
	private String semresult;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getSem() {
		return sem;
	}

	public void setSem(String sem) {
		this.sem = sem;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public void setResult(String semresult) {
		// TODO Auto-generated method stub
		this.semresult=semresult;
	}
}
