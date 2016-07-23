package VTU.com.nit.vtu.Beans;

import javax.persistence.Embeddable;

@Embeddable
public class Subject {
	String Subject;
	int External;
	int Internal;
	int Total;
	String Result;
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public int getExternal() {
		return External;
	}
	public void setExternal(int external) {
		External = external;
	}
	public int getInternal() {
		return Internal;
	}
	public void setInternal(int internal) {
		Internal = internal;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}
	public String getResult() {
		return Result;
	}
	public void setResult(String result) {
		Result = result;
	}
}
