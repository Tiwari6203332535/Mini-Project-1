package in.happy.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SerchRequest {
	private String planName;
	private String planStatus;
    private String gender;
    private String startDate;
    private String endDate;

}
