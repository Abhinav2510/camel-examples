package com.tutorials.csvflat.fixed.bean;

import org.apache.camel.dataformat.bindy.annotation.DataField;
import org.apache.camel.dataformat.bindy.annotation.FixedLengthRecord;

@FixedLengthRecord(length = 100, paddingChar = ' ')
public class OrderBenFixed {

	@DataField(pos = 1, length = 7)
	int orderId;
	@DataField(pos = 8, length = 20)
	String customerName;
	@DataField(pos = 28, length = 6)
	int pincode;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

}
