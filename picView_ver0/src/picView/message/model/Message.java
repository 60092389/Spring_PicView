package picView.message.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class Message implements Serializable {
	private String msg_no;
	private int mem_no;
	private String msg_sender;
	private String msg_receiver;
	private String msg_content;
	private String msg_check;
	private Timestamp msg_wri_date;
	private Timestamp msg_rec_date;
	private int msg_list_check;

	public Message() {
	}

	public Message(String msg_no, int mem_no, String msg_sender, String msg_receiver, String msg_content,
			String msg_check, Timestamp msg_wri_date, Timestamp msg_rec_date, int msg_list_check) {
		super();
		this.msg_no = msg_no;
		this.mem_no = mem_no;
		this.msg_sender = msg_sender;
		this.msg_receiver = msg_receiver;
		this.msg_content = msg_content;
		this.msg_check = msg_check;
		this.msg_wri_date = msg_wri_date;
		this.msg_rec_date = msg_rec_date;
		this.msg_list_check = msg_list_check;
	}

	public String getMsg_no() {
		return msg_no;
	}

	public void setMsg_no(String msg_no) {
		this.msg_no = msg_no;
	}

	public int getMem_no() {
		return mem_no;
	}

	public void setMem_no(int mem_no) {
		this.mem_no = mem_no;
	}

	public String getMsg_sender() {
		return msg_sender;
	}

	public void setMsg_sender(String msg_sender) {
		this.msg_sender = msg_sender;
	}

	public String getMsg_receiver() {
		return msg_receiver;
	}

	public void setMsg_receiver(String msg_receiver) {
		this.msg_receiver = msg_receiver;
	}

	public String getMsg_content() {
		return msg_content;
	}

	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}

	public String getMsg_check() {
		return msg_check;
	}

	public void setMsg_check(String msg_check) {
		this.msg_check = msg_check;
	}

	public Timestamp getMsg_wri_date() {
		return msg_wri_date;
	}

	public void setMsg_wri_date(Timestamp msg_wri_date) {
		this.msg_wri_date = msg_wri_date;
	}

	public Timestamp getMsg_rec_date() {
		return msg_rec_date;
	}

	public void setMsg_rec_date(Timestamp msg_rec_date) {
		this.msg_rec_date = msg_rec_date;
	}

	public int getMsg_list_check() {
		return msg_list_check;
	}

	public void setMsg_list_check(int msg_list_check) {
		this.msg_list_check = msg_list_check;
	}

	@Override
	public String toString() {
		return "Message [msg_no=" + msg_no + ", mem_no=" + mem_no + ", msg_sender=" + msg_sender + ", msg_receiver="
				+ msg_receiver + ", msg_content=" + msg_content + ", msg_check=" + msg_check + ", msg_wri_date="
				+ msg_wri_date + ", msg_rec_date=" + msg_rec_date + ", msg_list_check=" + msg_list_check + "]";
	}
	
}
