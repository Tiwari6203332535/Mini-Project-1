package in.happy.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

    @Entity
	@Data
	@Table(name = "CITIZEN_PLAN_INFO")
	public class CitizenPlan {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer citizenId;
		private String name;
		private String gender;
		private String  palnName;
		private String planStatus;
		private LocalDate planStartDate;
		private LocalDate planEndDate;
		private Double benifitamount;
		private String deniedReason;
		private LocalDate terminateddate;
		private String terminationReason;
		
		

}
