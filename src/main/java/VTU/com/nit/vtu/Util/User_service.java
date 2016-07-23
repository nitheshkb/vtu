package VTU.com.nit.vtu.Util;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import VTU.com.nit.vtu.Beans.Student;

public class User_service {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> usn = new ArrayList<String>();

		String[] dept = { "cs", "is", "ec", "it", "ee" };
		for (int j = 0; j < dept.length; j++) {
			String us = "1rn14";
			us = us + dept[j];
			for (int i = 0; i < 150; i++) {
				String temp = String.valueOf(i);
				if (temp.length() == 1) {
					temp = "00" + temp;
				} else if (temp.length() == 2) {
					temp = "0" + temp;
				} else {
					temp = "" + temp;
				}
				usn.add(us + temp);
			}
		}
		List<Student> studs = new Vtutest().getStudentsresult("", usn);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for (Student stu : studs) {
			session.saveOrUpdate(stu);
		}
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	
	static Session getSession(){
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		return session;
	}
}
