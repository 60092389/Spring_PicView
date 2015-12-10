package picView.analysis.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Analysis implements Serializable {
	private int anl_no;
	private int mem_no;
	private int pic_no;
	private String pic_title;
	private Timestamp pic_date;
	private String pic_add;
	private int pic_count;
	private int good_count;
	private int rep_count;
	private String anl_word;
	private Timestamp anl_date;
	private int anl_count;

	public Analysis(){}	
	

	public Analysis(int anl_no, int mem_no, int pic_no, String pic_title, Timestamp pic_date, String pic_add,
			int pic_count, int good_count, int rep_count, String anl_word, Timestamp anl_date, int anl_count) {
		super();
		this.anl_no = anl_no;
		this.mem_no = mem_no;
		this.pic_no = pic_no;
		this.pic_title = pic_title;
		this.pic_date = pic_date;
		this.pic_add = pic_add;
		this.pic_count = pic_count;
		this.good_count = good_count;
		this.rep_count = rep_count;
		this.anl_word = anl_word;
		this.anl_date = anl_date;
		this.anl_count = anl_count;
	}



	public int getAnl_no() {
		return anl_no;
	}

	public void setAnl_no(int anl_no) {
		this.anl_no = anl_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public int getPic_no() {
		return pic_no;
	}

	public void setPic_no(int pic_no) {
		this.pic_no = pic_no;
	}

	public String getPic_title() {
		return pic_title;
	}

	public void setPic_title(String pic_title) {
		this.pic_title = pic_title;
	}

	public Timestamp getPic_date() {
		return pic_date;
	}

	public void setPic_date(Timestamp pic_date) {
		this.pic_date = pic_date;
	}

	public String getPic_add() {
		return pic_add;
	}

	public void setPic_add(String pic_add) {
		this.pic_add = pic_add;
	}

	public int getPic_count() {
		return pic_count;
	}

	public void setPic_count(int pic_count) {
		this.pic_count = pic_count;
	}

	public int getGood_count() {
		return good_count;
	}

	public void setGood_count(int good_count) {
		this.good_count = good_count;
	}

	public int getRep_count() {
		return rep_count;
	}

	public void setRep_count(int rep_count) {
		this.rep_count = rep_count;
	}

	public String getAnl_word() {
		return anl_word;
	}

	public void setAnl_word(String anl_word) {
		this.anl_word = anl_word;
	}

	public Timestamp getAnl_date() {
		return anl_date;
	}

	public void setAnl_date(Timestamp anl_date) {
		this.anl_date = anl_date;
	}

	public int getAnl_count() {
		return anl_count;
	}

	public void setAnl_count(int anl_count) {
		this.anl_count = anl_count;
	}

	
		
}
