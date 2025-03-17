package com.ecom.plantopia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plants")
public class Plantmodel {
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long id;
@Column(name = "Plant name")
private String plantname;
@Column(name = "Plant description")
private String description;
@Column(name = "Price")
private float price;
 //Empty Constructor
public Plantmodel() {
}
public Plantmodel(String plantname, String description, float price) {
  this.plantname = plantname;
  this.description = description;
  this.price = price;
}
public long getId() {
  return id;
}
public String getPlantname() {
  return plantname;
}
public void setPlantname(String plantname) {
    this.plantname = plantname;
}
public String getDescription() {
  return description;
}
public void setDescription(String description) {
  this.description = description;
}
public float getPrice() {
    return price;
}
public void setPrice(float price) {
    this.price = price;
}
}