package model;

import java.util.Date;
import java.util.Map;

public class Management {
	private String EMPNO;
	private String SNO;
	
	public Management(){
	}
	
	
	public Management(String eMPNO, String sNO) {
		EMPNO = eMPNO;
		SNO = sNO;
	}

	public static Management getInstance(Map map){
		Management management=new Management(
				(String)map.get("EMPNO"),
				(String)map.get("SNO"));
		return management;
	}
	


	@Override
	public String toString() {
		return "Management [EMPNO=" + EMPNO + ", SNO=" + SNO + "]";
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
	
	

}
