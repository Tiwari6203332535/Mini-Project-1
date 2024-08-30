package in.happy.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.happy.entity.CitizenPlan;
import in.happy.repo.CitizenPlanRepo;
@Component
public class DataLoader implements ApplicationRunner {
	@Autowired
	private CitizenPlanRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		repo.deleteAll();
		CitizenPlan c1 = new CitizenPlan();

		c1.setName("Happy");
		c1.setGender("Male");
		c1.setPalnName("Medical");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenifitamount(5000.00);

		CitizenPlan c2 = new CitizenPlan();

		c2.setName("kishan");
		c2.setGender("Male");
		c2.setPalnName("Medical");
		c2.setPlanStatus("Denied");
		c1.setDeniedReason("rentalroom");

		CitizenPlan c3 = new CitizenPlan();

		c3.setName("rani");
		c3.setGender("Male");
		c3.setPalnName("Medical");
		c3.setPlanStatus("Terminated");
		c3.setPlanStartDate(LocalDate.now());
		c3.setPlanEndDate(LocalDate.now().plusMonths(6));
		c3.setBenifitamount(5000.00);
		c3.setTerminateddate(LocalDate.now());
		c3.setTerminationReason("employee");

		CitizenPlan c4 = new CitizenPlan();

		c4.setName("Happy1");
		c4.setGender("Male");
		c4.setPalnName("food");
		c4.setPlanStatus("Approved");
		c4.setPlanStartDate(LocalDate.now());
		c4.setPlanEndDate(LocalDate.now().plusMonths(6));
		c4.setBenifitamount(5000.00);

		CitizenPlan c5 = new CitizenPlan();

		c5.setName("kishan1");
		c5.setGender("Male");
		c5.setPalnName("food");
		c5.setPlanStatus("Denied");
		c5.setDeniedReason("rentalroom");

		CitizenPlan c6 = new CitizenPlan();

		c6.setName("rani1");
		c6.setGender("female");
		c6.setPalnName("food");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now());
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setBenifitamount(5000.00);
		c6.setTerminateddate(LocalDate.now());
		c6.setTerminationReason("employee");
		CitizenPlan c7 = new CitizenPlan();

		c7.setName("Happy2");
		c7.setGender("Male");
		c7.setPalnName("food");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenifitamount(5000.00);

		CitizenPlan c8 = new CitizenPlan();

		c8.setName("kishan2");
		c8.setGender("Male");
		c8.setPalnName("food");
		c8.setPlanStatus("Denied");
		c8.setDeniedReason("rentalroom");

		CitizenPlan c9 = new CitizenPlan();

		c9.setName("rani3");
		c9.setGender("female");
		c9.setPalnName("food");
		c9.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now());
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c9.setBenifitamount(5000.00);
		c9.setTerminateddate(LocalDate.now());
		c9.setTerminationReason("employee");

		CitizenPlan c10 = new CitizenPlan();

		c10.setName("Happy3");
		c10.setGender("Male");
		c10.setPalnName("medicine");
		c10.setPlanStatus("Approved");
		c10.setPlanStartDate(LocalDate.now());
		c10.setPlanEndDate(LocalDate.now().plusMonths(6));
		c10.setBenifitamount(5000.00);

		CitizenPlan c11 = new CitizenPlan();

		c11.setName("kishan3");
		c11.setGender("Male");
		c11.setPalnName("medicine");
		c11.setPlanStatus("Denied");
		c11.setDeniedReason("rentalroom");

		CitizenPlan c12 = new CitizenPlan();

		c12.setName("rani3");
		c12.setGender("female");
		c12.setPalnName("medicine");
		c12.setPlanStatus("Terminated");
		c12.setPlanStartDate(LocalDate.now());
		c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		c12.setBenifitamount(5000.00);
		c12.setTerminateddate(LocalDate.now());
		c12.setTerminationReason("employee");

		CitizenPlan c13 = new CitizenPlan();

		c13.setName("Happy4");
		c13.setGender("Male");
		c13.setPalnName("emp");
		c13.setPlanStatus("Approved");
		c13.setPlanStartDate(LocalDate.now());
		c13.setPlanEndDate(LocalDate.now().plusMonths(6));
		c13.setBenifitamount(5000.00);

		CitizenPlan c14 = new CitizenPlan();

		c14.setName("kishan4");
		c14.setGender("Male");
		c14.setPalnName("emp");
		c14.setPlanStatus("Denied");
		c14.setDeniedReason("rentalroom");

		CitizenPlan c15 = new CitizenPlan();

		c15.setName("rani4");
		c15.setGender("female");
		c15.setPalnName("emp");
		c15.setPlanStatus("Terminated");
		c15.setPlanStartDate(LocalDate.now());
		c15.setPlanEndDate(LocalDate.now().plusMonths(6));
		c15.setBenifitamount(5000.00);
		c15.setTerminateddate(LocalDate.now());
		c15.setTerminationReason("employee");
		
		List<CitizenPlan> list = Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15);
		repo.saveAll(list);

	}
}
