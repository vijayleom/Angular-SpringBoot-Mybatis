package com.tent.detail.mapping;

import java.io.Serializable;

public class PersonDetailsDO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int personId;
	
	private String personFirstName;
	
	private String personLastName;
	
	private long personPhoneNumber;
	
	private String address;

	/**
	 * @return the personId
	 */
	public int getPersonId() {
		return personId;
	}

	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(int personId) {
		this.personId = personId;
	}

	/**
	 * @return the personFirstName
	 */
	public String getPersonFirstName() {
		return personFirstName;
	}

	/**
	 * @param personFirstName the personFirstName to set
	 */
	public void setPersonFirstName(String personFirstName) {
		this.personFirstName = personFirstName;
	}

	/**
	 * @return the personLastName
	 */
	public String getPersonLastName() {
		return personLastName;
	}

	/**
	 * @param personLastName the personLastName to set
	 */
	public void setPersonLastName(String personLastName) {
		this.personLastName = personLastName;
	}

	/**
	 * @return the personPhoneNumber
	 */
	public long getPersonPhoneNumber() {
		return personPhoneNumber;
	}

	/**
	 * @param personPhoneNumber the personPhoneNumber to set
	 */
	public void setPersonPhoneNumber(long personPhoneNumber) {
		this.personPhoneNumber = personPhoneNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PersonDetailsDO [personId=" + personId + ", personFirstName=" + personFirstName + ", personLastName="
				+ personLastName + ", personPhoneNumber=" + personPhoneNumber + ", address=" + address + "]";
	}
	
	
}
