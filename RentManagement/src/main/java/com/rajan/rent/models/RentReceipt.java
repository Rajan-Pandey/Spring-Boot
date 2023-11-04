package com.rajan.rent.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RentReceipt")
public class RentReceipt {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int Id;
@Column
private int RoomNumber;
@Column
private double Amount;
@Column
private String mahina;
@Column
private boolean isPaid;
@Column
private Date DueDate;
@Column
private Date PaidOn;

public RentReceipt(int id, int RoomNumber, double Amount, String Month, boolean isPaid, Date DueDate, Date PaidOn) {
	super();
	Id = id;
	this.RoomNumber = RoomNumber;
	this.Amount = Amount;
	this.mahina = Month;
	this.isPaid = isPaid;
	this.DueDate = DueDate;
	this.PaidOn = PaidOn;
}
public int getId() {
	return this.Id;
}
public void setId(int Id) {
	this.Id = Id;
}
public int getRoomNumber() {
	return this.RoomNumber;
}
public void setRoomNumber(int RoomNumber) {
	this.Amount = RoomNumber;
}
public double getAmount() {
	return this.Amount;
}
public void setAmount(double Amount) {
	this.Amount = Amount;
}
public String getMonth() {
	return this.mahina;
}
public void setMonth(String Month) {
	this.mahina = Month;
}
public boolean isPaid() {
	return this.isPaid;
}
public void setPaid(boolean isPaid) {
	this.isPaid = isPaid;
}
public Date getDueDate() {
	return this.DueDate;
}
public void setDueDate(Date DueDate) {
	this.DueDate = DueDate;
}
public Date getPaidOn() {
	return PaidOn;
}
public void setPaidOn(Date PaidOn) {
	this.PaidOn = PaidOn;
}
@Override
public String toString() {
	return "RentReceipt [Id=" + Id + ", RoomNumber=" + RoomNumber + ", Amount=" + Amount + ", Month=" + mahina
			+ ", isPaid=" + isPaid + ", DueDate=" + DueDate + ", PaidOn=" + PaidOn + "]";
}
public RentReceipt() {
	super();
	// TODO Auto-generated constructor stub
}
	
}
