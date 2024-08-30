package in.happy.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.happy.DTO.SerchRequest;
import in.happy.entity.CitizenPlan;
import in.happy.service.ReportService;

@Controller
public class ReportController {
	@Autowired
	private ReportService service;
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");
		service.exportPDF(response);
	}
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=plans.xls");
		service.exportExcel(response);
		
	}
	

	@PostMapping("/search")
	public String Handlerequest(@ModelAttribute("searchkey")   SerchRequest request ,Model model) {
		System.out.println(request);
		List<CitizenPlan> plans = service.search(request);
		model.addAttribute("key", plans);
		init(model);
		return "index";
	}
	
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("searchkey", new SerchRequest());
		//SerchRequest search = new SerchRequest();
		//model.addAttribute("searchkey", search);
		
		init(model);
		return "index";
	}

	private void init(Model model) {
		
		model.addAttribute("name",service.getpalnName());
		model.addAttribute("status",service.getplanStatus());
	}
	
		
	}

