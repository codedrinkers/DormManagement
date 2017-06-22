package model;

import java.util.Date;
import java.util.Map;

public class Fix extends Model {
	private String FNAME;
	private String EMPNO;
	private String SNO;
	private Date FDATE;

	public Fix() {

	}

	public Fix(String fNAME, String eMPNO, String sNO, Date fDATE) {
		FNAME = fNAME;
		EMPNO = eMPNO;
		SNO = sNO;
		FDATE = fDATE;
	}

	public Fix(Map map) {
		FNAME = (String) map.get("FNAME");
		EMPNO = (String) map.get("EMPNO");
		SNO = (String) map.get("SNO");
		FDATE = (Date) map.get("FDATE");
	}

	public static Fix toModel(Map map) {
		Fix fix = new Fix((String) map.get("FNAME"), (String) map.get("EMPNO"), (String) map.get("SNO"),
				(Date) map.get("FDATE"));
		return fix;
	}

	@Override
	public String toString() {
		return "Fix [FNAME=" + FNAME + ", EMPNO=" + EMPNO + ", SNO=" + SNO + ", FDATE=" + FDATE + "]";
	}

	public String getFNAME() {
		return FNAME;
	}

	public void setFNAME(String fNAME) {
		FNAME = fNAME;
	}

	public String getEMPNO() {
		return EMPNO;
	}

	public void setEMPNO(String eMPNO) {
		EMPNO = eMPNO;
	}

	public String getSNO() {
		return SNO;
	}

	public void setSNO(String sNO) {
		SNO = sNO;
	}

	public Date getFDATE() {
		return FDATE;
	}

	public void setFDATE(Date fDATE) {
		FDATE = fDATE;
	}

}
