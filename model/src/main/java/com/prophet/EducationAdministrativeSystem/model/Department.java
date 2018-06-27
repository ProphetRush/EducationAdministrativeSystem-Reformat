package com.prophet.EducationAdministrativeSystem.model;

import com.prophet.EducationAdministrativeSystem.model.annotations.ID;
import com.prophet.EducationAdministrativeSystem.model.annotations.TableName;

@TableName("department")
public class Department {

  @ID
  private Long id;
  private String deptName;
  private String building;
  private Double budget;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }


  public String getBuilding() {
    return building;
  }

  public void setBuilding(String building) {
    this.building = building;
  }


  public Double getBudget() {
    return budget;
  }

  public void setBudget(Double budget) {
    this.budget = budget;
  }

}
