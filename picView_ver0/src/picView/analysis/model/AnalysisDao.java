package picView.analysis.model;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import picView.analysis.mapper.AnalysisMapper;

@Component
public class AnalysisDao {
	private SqlSessionTemplate myTemplate;

	@Autowired
	public void setMyTemplate(SqlSessionTemplate myTemplate) {
		this.myTemplate = myTemplate;
	}

	public void list2(Map<String, Object> listAnal) {
		myTemplate.getMapper(AnalysisMapper.class).listAnalysis2(listAnal);
	}

	// 분석 리스트
	public List<Analysis> listAnalysis(int mem_no) {
		return myTemplate.getMapper(AnalysisMapper.class).listAnalysis(mem_no);
	}

	// 분석 번호 찾아서 없으면 insert, 있으면 update
	public int select_no(Analysis_select anal_select) {
		return myTemplate.getMapper(AnalysisMapper.class).select_no(anal_select);
	}

	// 분석 횟수 update
	public void updateAnl_count(Analysis analysis) {
		myTemplate.getMapper(AnalysisMapper.class).updateAnl_count(analysis);
	}

	// 분석 insert
	public void insertAnalysis(Analysis analysis) {
		myTemplate.getMapper(AnalysisMapper.class).insertAnalysis(analysis);
	}
	
	//사진 삭제시 유입분석 데이터 삭제
	public void deleteAnalysis(int pic_no){
		myTemplate.getMapper(AnalysisMapper.class).deleteAnalysis(pic_no);
	}

}
