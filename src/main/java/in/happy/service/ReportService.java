package in.happy.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import in.happy.DTO.SerchRequest;
import in.happy.entity.CitizenPlan;

public interface ReportService {
	public List<String> getpalnName();
	public List<String> getplanStatus();
	public List<CitizenPlan> search(SerchRequest request);
	public Boolean exportExcel(HttpServletResponse response) throws Exception;
	public Boolean exportPDF(HttpServletResponse response) throws Exception;;


}
