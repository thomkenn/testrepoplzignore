package test.tomcat.beans;

import java.io.Serializable;

public class reimburse implements Serializable{
	/**
	 * 
	 */
	public reimburse(int userid, int amount, String aDP, int approver) {
		super();
		this.userid = userid;
		this.amount = amount;
		ADP = aDP;
		this.approver = approver;
	}
	private int userid;
	private int amount;
	private String ADP;
	private int approver;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getADP() {
		return ADP;
	}
	public void setADP(String aDP) {
		ADP = aDP;
	}
	public int getApprover() {
		return approver;
	}
	public void setApprover(int approver) {
		this.approver = approver;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ADP == null) ? 0 : ADP.hashCode());
		result = prime * result + amount;
		result = prime * result + approver;
		result = prime * result + userid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		reimburse other = (reimburse) obj;
		if (ADP == null) {
			if (other.ADP != null)
				return false;
		} else if (!ADP.equals(other.ADP))
			return false;
		if (amount != other.amount)
			return false;
		if (approver != other.approver)
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "reimburse [userid=" + userid + ", amount=" + amount + ", ADP=" + ADP + ", approver=" + approver + "]";
	}
	public reimburse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
