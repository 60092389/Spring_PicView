package picView.member.model;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


//폼으로부터 받는 가입정보
public class MemberCommand implements Serializable{
	@NotEmpty(message="반드시 이름을 입력하세요.")
	private String name;
	
	@NotEmpty(message="반드시 아이디를 입력하세요")
	@Pattern(regexp="^[_0-9a-zA-Z-]+@[0-9a-zA-Z]+(.[_0-9a-zA-Z-]+)*$", message="이메일 형식으로 입력해주세요.")
	private String id;
	
	@NotEmpty(message="반드시 비밀번호를 입력하세요.")
	private String password;
	
	@NotEmpty(message="반드시 생일을 입력하세요.")
	private String year;
	
	@NotEmpty(message="반드시 생일을 입력하세요.")
	private String month;
	
	@NotEmpty(message="반드시 생일을 입력하세요.")
	private String day;
	
	@NotEmpty(message="반드시 성별을 입력하세요.")
	private String gender;
	private String category_no;
	
	public MemberCommand(){}
	
	public MemberCommand(String name, String id, String year, String month, String password, String day,
			String gender, String category_no) {
		super();
		this.name = name;
		this.id = id;
		this.year = year;
		this.month = month;
		this.password = password;
		this.day = day;
		this.gender = gender;
		this.category_no = category_no;
	}



	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
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


	public String getCategory_no() {
		return category_no;
	}


	public void setCategory_no(String category_no) {
		this.category_no = category_no;
	}
	
		
	
}
