package com.tent.database.modal;

import java.io.Serializable;

public class Person implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int personId;
	
	private String personFirstName;
	
	private String personLastName;
	
	private long personPhone;
	
	private String personAddress;
	
	private int addressId;
	
	private int phoneId;

	/**
	 * @return the addressId
	 */
	public int getAddressId() {
		return addressId;
	}

	/**
	 * @param addressId the addressId to set
	 */
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	/**
	 * @return the phoneId
	 */
	public int getPhoneId() {
		return phoneId;
	}

	/**
	 * @param phoneId the phoneId to set
	 */
	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

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
		return personPhone;
	}

	/**
	 * @param personPhoneNumber the personPhoneNumber to set
	 */
	public void setPersonPhoneNumber(long personPhoneNumber) {
		this.personPhone = personPhoneNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return personAddress;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.personAddress = address;
	}

	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personFirstName=" + personFirstName + ", personLastName="
				+ personLastName + ", personPhone=" + personPhone + ", personAddress=" + personAddress + ", addressId="
				+ addressId + ", phoneId=" + phoneId + "]";
	}
}
