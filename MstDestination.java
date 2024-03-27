package jp.co.internous.milestone.model.domain;

/**
 * mst_destinationのドメイン
 * @author インターノウス
 *
 */
public class MstDestination {
	private int id;
	private int userId;
	private  String familyName;
	private String firstName;
	private String telNumber;
	private String address;
	private byte status;
	private String createdAt;
	private String updatedAt;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getTelNumber() {
		return telNumber;
	}
	
	public void setTelNumber(String tekNumber) {
		this.telNumber = tekNumber;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public byte getStatus() {
		return status;
	}
	
	public void setStatus(byte status) {
		this.status = status;
	}
	
	public String getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
