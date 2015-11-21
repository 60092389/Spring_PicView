package picView.picture.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import picView.admin.mapper.AdminMapper;
import picView.album.mapper.AlbumMapper;
import picView.member.mapper.MemberMapper;
import picView.member.model.Member;
import picView.picture.mapper.PictureMapper;

public class PictureDao {
	
	private static PictureDao dao = new PictureDao();
	
	public static PictureDao getInstance(){
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
	
	public int insertPicture(Picture picture){
		SqlSession sqlSession = getSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(PictureMapper.class).insertPicture(picture);
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
	//my_Show.jsp에 사용되는 리스트
	public List<PictureShow> listMyShow(int mem_no){
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			return sqlSession.getMapper(PictureMapper.class).listMyShow(mem_no);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			sqlSession.close();
		}
	}
	
	//my_Manage.jsp에 사용되는 리스트
	public List<Picture> ManageListPicture(int mem_no){
		SqlSession sqlSession = getSessionFactory().openSession();
		
		return sqlSession.getMapper(PictureMapper.class).ManageListPicture(mem_no);
	}
	//my_Manage.jsp에 사용되는 날짜뽑는 리스트
	public List<Picture> PictureDate(int mem_no){
		SqlSession sqlSession = getSessionFactory().openSession();
		
		return sqlSession.getMapper(PictureMapper.class).PictureDate(mem_no);
	}
	
	public int deletePicture(int pic_no){
		SqlSession sqlSession = getSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(PictureMapper.class).deletePicture(pic_no);
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
