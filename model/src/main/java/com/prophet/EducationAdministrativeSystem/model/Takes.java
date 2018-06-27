package com.prophet.EducationAdministrativeSystem.model;


import com.prophet.EducationAdministrativeSystem.model.annotations.ID;
import com.prophet.EducationAdministrativeSystem.model.annotations.TableName;

@TableName("takes")
public class Takes {

  @ID
  private Long id;
  private String grade;
  private Long sectionId;
  private Long studentId;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getGrade() {
    return grade;
  }

  public void setGrade(String grade) {
    this.grade = grade;
  }


  public Long getSectionId() {
    return sectionId;
  }

  public void setSectionId(Long sectionId) {
    this.sectionId = sectionId;
  }


  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

}
