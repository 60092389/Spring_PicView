package picView.follow.mapper;

import java.util.List;

import picView.follow.model.Follow;


public interface FollowMapper {
	public void addNewFollow(Follow follow);
	public List<Follow> listFollow(int mem_no);
	public List<Follow> listFollowCheck(int mem_no);
	public void updateFollowCheck(Follow follow);
	public void cancelFollow(Follow follow);
	public List<Follow> followCheck(Follow follow);
}
