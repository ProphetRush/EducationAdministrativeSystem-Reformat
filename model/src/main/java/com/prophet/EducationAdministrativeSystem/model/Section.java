package com.prophet.EducationAdministrativeSystem.model;


import com.prophet.EducationAdministrativeSystem.model.annotations.ID;
import com.prophet.EducationAdministrativeSystem.model.annotations.TableName;

@TableName("section")
public class Section {

  @ID
  private Long id;
  private Long courseId;
  private String secId;
  private String semester;
  private Long year;
  private String timeSlotId;
  private Long instructorId;
  private Long classroomId;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getCourseId() {
    return courseId;
  }

  public void setCourseId(Long courseId) {
    this.courseId = courseId;
  }


  public String getSecId() {
    return secId;
  }

  public void setSecId(String secId) {
    this.secId = secId;
  }


  public String getSemester() {
    return semester;
  }

  public void setSemester(String semester) {
    this.semester = semester;
  }


  public Long getYear() {
    return year;
  }

  public void setYear(Long year) {
    this.year = year;
  }


  public String getTimeSlotId() {
    return timeSlotId;
  }

  public void setTimeSlotId(String timeSlotId) {
    this.timeSlotId = timeSlotId;
  }


  public Long getInstructorId() {
    return instructorId;
  }

  public void setInstructorId(Long instructorId) {
    this.instructorId = instructorId;
  }


  public Long getClassroomId() {
    return classroomId;
  }

  public void setClassroomId(Long classroomId) {
    this.classroomId = classroomId;
  }

}
