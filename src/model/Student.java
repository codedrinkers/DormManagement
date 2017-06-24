package model;

import java.util.Map;

public class Student{
	private String SNO;
	private String SSEX;
	private String SNAME;
	private String SMAJOR;
	private String SGRADE;
	private String SCLASS;
	private String SBNO;
	private String SDNO;

	public Student(){
		
	}
	
	public Student(String sNO, String sSEX, String sNAME, String sMAJOR, String sGRADE, String sCLASS, String sBNO,
			String sDNO) {
		SNO = sNO;
		SSEX = sSEX;
		SNAME = sNAME;
		SMAJOR = sMAJOR;
		SGRADE = sGRADE;
		SCLASS = sCLASS;
		SBNO = sBNO;
		SDNO = sDNO;
	}
	public Student(Map map) {
		SNO=(String)map.get("SNO");
		SSEX=(String)map.get("SSEX");
		SNAME=(String)map.get("SNAME");
		SMAJOR=(String)map.get("SMAJOR");
		SGRADE=(String)map.get("SGRADE");
		SCLASS=(String)map.get("SCLASS");
		SBNO=(String)map.get("SBNO");
		SDNO=(String)map.get("SDNO");
	}
	
	public static Student toModel(Map map){
		Student student=new Student(
				(String)map.get("SNO"),
				(String)map.get("SSEX"),
				(String)map.get("SNAME"),
				(String)map.get("SMAJOR"),
				(String)map.get("SGRADE"),
				(String)map.get("SCLASS"),
				(String)map.get("SBNO"),
				(String)map.get("SDNO"));
		return student;
	}
	
	
	
	@Override
	public String toString() {
		return "Student [SNO=" + SNO + ", SSEX=" + SSEX + ", SNAME=" + SNAME + ", SMAJOR=" + SMAJOR + ", SGRADE="
				+ SGRADE + ", SCLASS=" + SCLASS + ", SBNO=" + SBNO + ", SDNO=" + SDNO + "]";
	}

	public String[] toArray(){
	    String[] tmp = {this.SNO,this.SSEX,this.SNAME,this.SMAJOR,this.SGRADE,this.SCLASS,this.SBNO,this.SDNO};	    
	    return tmp;
	}
	public String getSNO() {
		return SNO;
	}
	public void setSNO(String sNO) {
		SNO = sNO;
	}
	public String getSSEX() {
		return SSEX;
	}
	public void setSSEX(String sSEX) {
		SSEX = sSEX;
	}
	public String getSNAME() {
		return SNAME;
	}
	public void setSNAME(String sNAME) {
		SNAME = sNAME;
	}
	public String getSMAJOR() {
		return SMAJOR;
	}
	public void setSMAJOR(String sMAJOR) {
		SMAJOR = sMAJOR;
	}
	public String getSGRADE() {
		return SGRADE;
	}
	public void setSGRADE(String sGRADE) {
		SGRADE = sGRADE;
	}
	public String getSCLASS() {
		return SCLASS;
	}
	public void setSCLASS(String sCLASS) {
		SCLASS = sCLASS;
	}
	public String getSBNO() {
		return SBNO;
	}
	public void setSBNO(String sBNO) {
		SBNO = sBNO;
	}
	public String getSDNO() {
		return SDNO;
	}
	public void setSDNO(String sDNO) {
		SDNO = sDNO;
	}
	
}
