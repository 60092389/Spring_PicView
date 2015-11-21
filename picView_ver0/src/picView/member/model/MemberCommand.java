package picView.member.model;

import java.io.Serializable;
import java.sql.Timestamp;


//폼으로부터 받는 가입정보
public class MemberCommand implements Serializable{
	private String name;
	private String id;
	private String pass;
	private String year;
	private String month;
	private String day;
	private String gender;
	
	public MemberCommand(){}
	
	public MemberCommand(String name, String id, String pass, String year, String month, String day, String gender) {
		super();
		this.name = name;
		this.id = id;
		this.pass = pass;
		this.year = year;
		this.month = month;
		this.day = day;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
		
	
}
