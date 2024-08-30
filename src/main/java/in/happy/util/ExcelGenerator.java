package in.happy.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import in.happy.entity.CitizenPlan;
@Component
public class ExcelGenerator {
	
	
	private int dataRowIndex;

	public void generateExcel(HttpServletResponse response,List<CitizenPlan> record ,File file) throws Exception {
		
		
		//	Workbook WB =	 new XSSFWorkbook();  support xlsx extension in controller
		Workbook WB =	 new HSSFWorkbook();
		Sheet sheet = WB.createSheet("plans-data");
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Citizen Name");
		row.createCell(2).setCellValue("Plan Name");
		row.createCell(3).setCellValue("Plan Status");
		row.createCell(4).setCellValue("Plan Start Date");
		row.createCell(5).setCellValue("Plan End Date");
		row.createCell(6).setCellValue("Benifit Amt");
		
		//List<CitizenPlan> record = PlanRepo.findAll();
		
		  dataRowIndex = 1;
		  
		 for(CitizenPlan plan :record ) {
			 Row datarow = sheet.createRow(dataRowIndex);
			 datarow.createCell(0).setCellValue(plan.getCitizenId());
			 datarow.createCell(1).setCellValue(plan.getName());
			 datarow.createCell(2).setCellValue(plan.getPalnName());
			 datarow.createCell(3).setCellValue(plan.getPlanStatus());
			 if(null !=plan.getPlanStartDate()){
				 datarow.createCell(4).setCellValue(plan.getPlanStartDate()+"");
				 }else {
					 datarow.createCell(4).setCellValue("N/A");
				 }
			 if(null !=plan.getPlanEndDate()){
				 datarow.createCell(5).setCellValue(plan.getPlanEndDate()+"");
				 }else {
					 datarow.createCell(5).setCellValue("N/A");
				 }
			
			 if(null !=plan.getBenifitamount()){
			 datarow.createCell(6).setCellValue(plan.getBenifitamount());
			 }else {
				 datarow.createCell(6).setCellValue("N/A");
			 }
			 dataRowIndex++;
		
		 }
		 // file input stream
		 
	  try (FileOutputStream fos = new FileOutputStream(file)) {
			  WB.write(fos);
		    } catch (IOException e) {
		        e.printStackTrace();  // Handle exception
	       
	    } finally {
		    	WB.close();  // Close the workbook
		    }
		
		
		 ServletOutputStream stream = response.getOutputStream();
		 WB.write(stream);
		 WB.close();
		 
		 
		}
	}


