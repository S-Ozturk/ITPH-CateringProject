package com.project.catering.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class OrderMeal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name, deliveryAdress;
	private Date orderDate, deliveryDate;
	private int minCalorie, peopleAmount;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		      name="ORDER_MEAL_MEAL_LIST",
		      joinColumns=@JoinColumn(name="ORDER_MEAL_ID", referencedColumnName="ID"),
		      inverseJoinColumns=@JoinColumn(name="MEAL_LIST_ID", referencedColumnName="ID"))
	private List<MealList>  mealLists;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CUSTOMER_ID", nullable=false)
    private Customer customer;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDeliveryAdress() {
		return deliveryAdress;
	}
	public void setDeliveryAdress(String deliveryAdress) {
		this.deliveryAdress = deliveryAdress;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public int getMinCalorie() {
		return minCalorie;
	}
	public void setMinCalorie(int minCalorie) {
		this.minCalorie = minCalorie;
	}
	public int getPeopleAmount() {
		return peopleAmount;
	}
	public void setPeopleAmount(int peopleAmount) {
		this.peopleAmount = peopleAmount;
	}
	public List<MealList> getMealLists() {
		return mealLists;
	}
	public void setMealLists(List<MealList> mealLists) {
		this.mealLists = mealLists;
	}

}
