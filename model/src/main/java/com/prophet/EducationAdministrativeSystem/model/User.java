package com.prophet.EducationAdministrativeSystem.model;


import com.prophet.EducationAdministrativeSystem.model.annotations.ID;
import com.prophet.EducationAdministrativeSystem.model.annotations.TableName;

@TableName("user")
public class User {

  @ID
  private Long id;
  private String groupId;
  private String userGroup;
  private String password;
  private String username;
  private String email;
  private String phone;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }


  public String getUserGroup() {
    return userGroup;
  }

  public void setUserGroup(String userGroup) {
    this.userGroup = userGroup;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

}
