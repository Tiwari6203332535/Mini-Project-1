package in.happy.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import in.happy.DTO.SerchRequest;
import in.happy.entity.CitizenPlan;
import in.happy.repo.CitizenPlanRepo;
import in.happy.util.EmailSender;
import in.happy.util.ExcelGenerator;
import in.happy.util.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService {
	@Autowired
	private EmailSender mailsender;

	@Autowired
	private ExcelGenerator excelGenerator;
	@Autowired
	private PdfGenerator pdfgenerator;

	@Autowired
	private CitizenPlanRepo PlanRepo;

	@Override
	public List<String> getpalnName() {
		List<String> name = PlanRepo.getpalnName();
		return name;
	}

	@Override
	public List<String> getplanStatus() {
		List<String> status = PlanRepo.getplanStatus();
		return status;
	}

	@Override
	public List<CitizenPlan> search(SerchRequest request) {
		CitizenPlan entity = new CitizenPlan();

		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPalnName(request.getPlanName());
		}
		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localdate = LocalDate.parse(startDate, formatter);
		}
		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}

		List<CitizenPlan> all = PlanRepo.findAll(Example.of(entity));
		return all;
	}

	@Override
	public Boolean exportExcel(HttpServletResponse response) throws Exception {
		File f = new File("Plans.xls");
		List<CitizenPlan> all = PlanRepo.findAll();
		excelGenerator.generateExcel(response, all,f);
	
		String subject ="Test mail subjected";
		String body ="<h2>Test Mail Body</h2>";
		String to = "tiwari95874@gmail.com";
	
		mailsender.mailsender(subject, body, to,f);
		f.delete();
		return true;

	}

	@Override
	public Boolean exportPDF(HttpServletResponse response) throws Exception {
		File f = new File("Plans.pdf");
		
		 List<CitizenPlan> plans = PlanRepo.findAll();
		 pdfgenerator.generatePdf(response, plans, f);
		 
		 String subject ="Test mail subjected";
			String body ="<h2>Test Mail Body</h2>";
			String to = "tiwari95874@gmail.com";
		
			mailsender.mailsender(subject, body, to,f);
			f.delete();
		return true;
	}
}
