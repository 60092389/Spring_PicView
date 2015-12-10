package picView.analysis.mapper;

import java.util.List;
import java.util.Map;

import picView.analysis.model.Analysis;
import picView.analysis.model.Analysis_select;

public interface AnalysisMapper {
	public void listAnalysis2(Map<String, Object> listAnal);
	
	public List<Analysis> listAnalysis(int mem_no);
	public int select_no(Analysis_select anal_select);
	public void updateAnl_count(Analysis analysis);
	
	public void insertAnalysis(Analysis analysis);
	public void deleteAnalysis(int pic_no);

}
