package pe.edu.hr.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class JobHistoryId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer employee;
	private Date startDate;
	
	public JobHistoryId() {
	}

	public JobHistoryId(Integer employee, Date startDate) {
		super();
		this.employee = employee;
		this.startDate = startDate;
	}

	public Integer getEmployee() {
		return employee;
	}

	public Date getStartDate() {
		return startDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employee, startDate);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
        if (obj == null || getClass() != obj.getClass()) 
        	return false;
        JobHistoryId jobHistoryId = (JobHistoryId) obj;
        if (this.employee != jobHistoryId.employee) 
        	return false;
        return this.startDate == jobHistoryId.startDate;
	}
	
}
