package picView.follow.model;

import java.io.Serializable;

public class FollowCommand implements Serializable {
	private String mem_nos;

	public FollowCommand(){}
	
	public FollowCommand(String mem_nos) {
		super();
		this.mem_nos = mem_nos;
	}

	public String getMem_nos() {
		return mem_nos;
	}

	public void setMem_nos(String mem_nos) {
		this.mem_nos = mem_nos;
	}
	
	
	
}
