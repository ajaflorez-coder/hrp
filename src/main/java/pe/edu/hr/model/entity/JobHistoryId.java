package pe.edu.hr.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class JobHistoryId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Date startDate;
	
	public JobHistoryId(Integer id, Date startDate) {
		super();
		this.id = id;
		this.startDate = startDate;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(id, startDate);
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        JobHistoryId jobHis1 = (JobHistoryId) obj;
        if (this.id != jobHis1.id) return false;
        return this.startDate == jobHis1.startDate;
	}
	

	
}
