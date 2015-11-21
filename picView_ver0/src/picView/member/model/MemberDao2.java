/*package picView.member.model;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import picView.admin.model.Search;
import picView.admin.mapper.AdminMapper;
import picView.member.mapper.MemberMapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import picView.member.mapper.MemberMapper;

public class MemberDao2 implements Serializable {
	
	private static MemberDao2 dao = new MemberDao2();
	
	public static MemberDao2 getInstance(){
		return dao;
	}
	
	public SqlSessionFactory getSessionFactory(){
		String resource = "mybatis-config.xml";
		InputStream input = null;
		try {
			input = Resources.getResourceAsStream(resource);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(input);
	}
	
	public int insertMember(Member member){
		SqlSession sqlSession = getSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(MemberMapper.class).insertMember(member);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return re;
	}
	public Member loginMember(Member member){
		SqlSession sqlSession = getSessionFactory().openSession();

		return sqlSession.getMapper(MemberMapper.class).loginMember(member);
		
	}
	public List<Member> listMember(int requestPage, Search search){
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			return sqlSession.getMapper(AdminMapper.class).listMember(new RowBounds(requestPage, 10), search);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			sqlSession.close();
		}
	}
	
	public int totalRow(Search search){
		SqlSession sqlSession = getSessionFactory().openSession();
		try {
			return sqlSession.getMapper(AdminMapper.class).totalRow(search);
		} catch (Exception e) {
			return 0;
		}finally{
			sqlSession.close();
		}
	}
	
	public int deleteMember(int mem_no){
		SqlSession sqlSession = getSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(MemberMapper.class).deleteMember(mem_no);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		return re;
	}
	

}
*/