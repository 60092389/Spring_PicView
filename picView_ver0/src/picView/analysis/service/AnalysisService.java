package picView.analysis.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import picView.analysis.model.Analysis;
import picView.analysis.model.AnalysisDao;
import picView.analysis.model.Analysis_select;
import picView.member.model.AuthInfo;

@Service
public class AnalysisService {
	private AnalysisDao anal_Dao;
	
	@Autowired
	public void setAnalDao(AnalysisDao anal_Dao) {
		this.anal_Dao = anal_Dao;
	}

	public void listAnalysis2(Map<String, Object> listAnal) {
		anal_Dao.list2(listAnal);
	}

	// 분석 리스트
	public List<Analysis> listAnalysis(int mem_no) {
		
		return anal_Dao.listAnalysis(mem_no);
	}

	// 분석 번호 찾아서 없으면 insert, 있으면 update
	public void select_no(Analysis_select anal_select, Analysis analysis) {
		System.out.println("유입분석 서비스");
		System.out.println(anal_select);
		System.out.println(analysis);
		
		int select_no = anal_Dao.select_no(anal_select);

		if (select_no == 0) {
			System.out.println("insert");
			anal_Dao.insertAnalysis(analysis);
		} else {
			System.out.println("update");
			anal_Dao.updateAnl_count(analysis);
		}
	}
}
