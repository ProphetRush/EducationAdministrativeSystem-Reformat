package com.prophet.EducationAdministrativeSystem.model;


import com.prophet.EducationAdministrativeSystem.model.annotations.ID;
import com.prophet.EducationAdministrativeSystem.model.annotations.TableName;

@TableName("course")
public class Course {

  @ID
  private Long id;
  private String title;
  private Long credits;
  private Long prereqId;
  private Long deptId;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public Long getCredits() {
    return credits;
  }

  public void setCredits(Long credits) {
    this.credits = credits;
  }


  public Long getPrereqId() {
    return prereqId;
  }

  public void setPrereqId(Long prereqId) {
    this.prereqId = prereqId;
  }


  public Long getDeptId() {
    return deptId;
  }

  public void setDeptId(Long deptId) {
    this.deptId = deptId;
  }

}
