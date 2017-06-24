package model;

import java.util.Map;

public class Administrater {
	private String EMPNO;
	private String EMPID;
	private String EMPNAME;
	private String EMPSEX;
	private String EMPJOB;
	private String EMPPHONE;
	private String EMPPASWD;
	
	public Administrater(){
		
	}
	
	public Administrater(Map<String, Object> map){
		EMPNO = (String)map.get("EMPNO");
		EMPID = (String)map.get("EMPID");
		EMPNAME = (String)map.get("EMPNAME");
		EMPSEX = (String)map.get("EMPSEX");
		EMPJOB = (String)map.get("EMPJOB");
		EMPPHONE = (String)map.get("EMPPHONE");
		EMPPASWD = (String)map.get("EMPPASWD");
	}
	
	public Administrater(String eMPNO, String eMPID, String eMPNAME, String eMPSEX, String eMPJOB, String eMPPHONE,
			String eMPPASWD) {
		super();
		EMPNO = eMPNO;
		EMPID = eMPID;
		EMPNAME = eMPNAME;
		EMPSEX = eMPSEX;
		EMPJOB = eMPJOB;
		EMPPHONE = eMPPHONE;
		EMPPASWD = eMPPASWD;
	}
	
	public static Administrater toModel(Map<String, Object> map){
		Administrater admin=new Administrater(
				(String)map.get("EMPNO"),
				(String)map.get("EMPID"),
				(String)map.get("EMPNAME"),
				(String)map.get("EMPSEX"),
				(String)map.get("EMPJOB"),
				(String)map.get("EMPPHONE"),
				(String)map.get("EMPPASWD"));
		return admin;
	}
	
	
	
	@Override
	public String toString() {
		return "Administrater [EMPNO=" + EMPNO + ", EMPID=" + EMPID + ", EMPNAME=" + EMPNAME + ", EMPSEX=" + EMPSEX
				+ ", EMPJOB=" + EMPJOB + ", EMPPHONE=" + EMPPHONE + ", EMPPASWD=" + EMPPASWD + "]";
	}

	public String getEMPNO() {
		return EMPNO;
	}
	public void setEMPNO(String eMPNO) {
		EMPNO = eMPNO;
	}
	public String getEMPID() {
		return EMPID;
	}
	public void setEMPID(String eMPID) {
		EMPID = eMPID;
	}
	public String getEMPNAME() {
		return EMPNAME;
	}
	public void setEMPNAME(String eMPNAME) {
		EMPNAME = eMPNAME;
	}
	public String getEMPSEX() {
		return EMPSEX;
	}
	public void setEMPSEX(String eMPSEX) {
		EMPSEX = eMPSEX;
	}
	public String getEMPJOB() {
		return EMPJOB;
	}
	public void setEMPJOB(String eMPJOB) {
		EMPJOB = eMPJOB;
	}
	public String getEMPPHONE() {
		return EMPPHONE;
	}
	public void setEMPPHONE(String eMPPHONE) {
		EMPPHONE = eMPPHONE;
	}
	public String getEMPPASWD() {
		return EMPPASWD;
	}
	public void setEMPPASWD(String eMPPASWD) {
		EMPPASWD = eMPPASWD;
	}	
}