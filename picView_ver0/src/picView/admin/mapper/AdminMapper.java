package picView.admin.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import picView.admin.model.Search;
import picView.member.model.Member;

public interface AdminMapper {
	public List<Member> listMember(RowBounds row, Search search);
	public int totalRow(Search search);

}
