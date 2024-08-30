package in.happy.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.happy.entity.CitizenPlan;
@Component
public class PdfGenerator {
	
	public void generatePdf(HttpServletResponse response,List<CitizenPlan> plans ,File f) throws Exception  {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		PdfWriter.getInstance(document, new FileOutputStream(f));
		
		document.open();
		Paragraph p = new Paragraph("Citizen_Plan_Info");
		document.add(p);
		
	//	PdfTable table = new PdfTable(6); 
		
		PdfPTable table = new PdfPTable(6);
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End Date");
		

		for(CitizenPlan plan : plans) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getName());
			table.addCell(plan.getPalnName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getPlanStartDate()+"");
			table.addCell(plan.getPlanEndDate()+"");	
		
		}
		
		document.add(table);
		document.close();
		
		
	}

		
	}


