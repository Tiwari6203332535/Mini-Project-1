package in.happy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.happy.entity.CitizenPlan;

public interface CitizenPlanRepo  extends JpaRepository<CitizenPlan,Integer> {
	@Query("select distinct(palnName) From CitizenPlan")
	public List<String> getpalnName();
	
	@Query("select distinct(planStatus) From CitizenPlan")
	public List<String> getplanStatus();

}
