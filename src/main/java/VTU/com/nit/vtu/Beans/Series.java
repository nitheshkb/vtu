package VTU.com.nit.vtu.Beans;

import java.util.List;

public class Series {
	String name = "% Result";
	boolean colorByPoint = true;
	List<Department> data;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isColorByPoint() {
		return colorByPoint;
	}
	public void setColorByPoint(boolean colorByPoint) {
		this.colorByPoint = colorByPoint;
	}
	public List<Department> getData() {
		return data;
	}
	public void setData(List<Department> dept) {
		this.data = dept;
	}
	
}
