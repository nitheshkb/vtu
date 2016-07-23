package VTU.com.nit.vtu.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import VTU.com.nit.vtu.Beans.Student;
import VTU.com.nit.vtu.Beans.Subject;

public class Vtutest {

	private Student sendReq(String idinfo) throws ClientProtocolException,
			IOException {
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("rid", idinfo));
		formparams.add(new BasicNameValuePair("submit", "SUBMIT"));
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams,
				Consts.UTF_8);
		HttpPost httppost = new HttpPost("http://results.vtu.ac.in/vitavi.php");
		httppost.setEntity(entity);
		HttpClient httpclient = HttpClients.createDefault();
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity1 = response.getEntity();
		String responseString = EntityUtils.toString(entity1, "UTF-8");

		Document html = Jsoup.parse(responseString);
		Elements Name = html
				.select("body > table > tbody > tr:nth-child(3) > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > table > tbody > tr:nth-child(2) > td:nth-child(1) > table:nth-child(2) > tbody > tr > td > table > tbody > tr:nth-child(2) > td");
		Elements yearele = html
				.select("body > table > tbody > tr:nth-child(3) > td:nth-child(2) > table > tbody > tr:nth-child(3) > td > table > tbody > tr:nth-child(2) > td:nth-child(1) > table:nth-child(1) > tbody > tr > td");
		String year = yearele.get(0).childNodes().get(1).toString().split(",")[1]
				.trim();
		Iterator<Element> itr = Name.iterator();
		Element ele = itr.next();
		String studinfo = ele.child(0).toString();
		studinfo = studinfo.replaceAll("<[/]*[a-z]>", "");
		studinfo = studinfo.replaceAll("\\(", "");
		studinfo = studinfo.replaceAll("\\)", "").trim();
		String id = studinfo.substring(studinfo.length() - 10,
				studinfo.length());
		Element seminfo = ele.child(6);
		String sem = seminfo.child(0).child(0).child(1).toString()
				.replaceAll("<[/]*[a-z]*>", "");
		String[] semresultinfo = seminfo.child(0).child(0).child(3).toString()
				.replaceAll("<[/]*[a-z]*>", "").split(";");
		String semresult = semresultinfo[6];
		Element Resultdata1 = ele.child(9);
		Element Resultdata2 = ele.child(12);
		Element Resultdata;

		if (Resultdata1.toString().equals("<br>")) {
			Resultdata = Resultdata2;
		} else {
			Resultdata = Resultdata1;
		}
		List<Subject> subs = processresult(Resultdata);
		Student student = new Student();
		student.setID(id.trim());
		student.setName(studinfo.trim());
		student.setSem(sem.trim());
		student.setSubjects(subs);
		student.setYear(year);
		student.setResult(semresult.trim());
		student.setDepartment(id.substring(5, 7).trim());
		return student;
	}

	private List<Subject> processresult(Element Resultdata) {
		List<Subject> subs = new ArrayList<Subject>();
		List<Node> itr1 = Resultdata.childNodes().get(0).childNodes();
		boolean first = true;
		for (Node node : itr1) {
			if (first) {
				first = false;
				continue;
			}
			List<Node> childs = node.childNodes();
			List<String> array = new ArrayList<String>();
			for (Node ch : childs) {
				String val = ch.childNode(0).toString();
				String clearstring = val.replaceAll("<[/]*[a-z]>", "");
				array.add(clearstring);
			}
			Subject sub = new Subject();
			sub.setSubject(array.get(0));
			sub.setExternal(Integer.parseInt(array.get(1)));
			sub.setInternal(Integer.parseInt(array.get(2)));
			sub.setTotal(Integer.parseInt(array.get(3)));
			sub.setResult(array.get(4));
			subs.add(sub);
		}
		return subs;
	}

	public List<Student> getStudentsresult(String dID, List<String> usn) {
		List<Student> studs = new ArrayList<Student>();
		for (String no : usn) {
			try {
				studs.add(sendReq(no));
			} catch (Exception e) {
				System.out.println("EX for +" + no);
				System.out.println(e);
			}
		}

		return studs;
	}
}
