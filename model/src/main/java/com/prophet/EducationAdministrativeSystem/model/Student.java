package com.prophet.EducationAdministrativeSystem.model;


import com.prophet.EducationAdministrativeSystem.model.annotations.ID;
import com.prophet.EducationAdministrativeSystem.model.annotations.TableName;

@TableName("student")
public class Student {

  @ID
  private Long id;
  private String name;
  private Long totCred;
  private Long creditLeft;
  private Long advisorId;
  private Long deptId;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public Long getTotCred() {
    return totCred;
  }

  public void setTotCred(Long totCred) {
    this.totCred = totCred;
  }


  public Long getCreditLeft() {
    return creditLeft;
  }

  public void setCreditLeft(Long creditLeft) {
    this.creditLeft = creditLeft;
  }


  public Long getAdvisorId() {
    return advisorId;
  }

  public void setAdvisorId(Long advisorId) {
    this.advisorId = advisorId;
  }


  public Long getDeptId() {
    return deptId;
  }

  public void setDeptId(Long deptId) {
    this.deptId = deptId;
  }

}
