package com.prophet.EducationAdministrativeSystem.model;

import com.prophet.EducationAdministrativeSystem.model.annotations.ID;
import com.prophet.EducationAdministrativeSystem.model.annotations.TableName;

@TableName("classroom")
public class Classroom {
    
    @ID
    private Long id;
    private String building;
    private Long roomNumber;
    private Long capacity;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    
    public String getBuilding() {
        return building;
    }
    
    public void setBuilding(String building) {
        this.building = building;
    }
    
    
    public Long getRoomNumber() {
        return roomNumber;
    }
    
    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }
    
    
    public Long getCapacity() {
        return capacity;
    }
    
    public void setCapacity(Long capacity) {
    this.capacity = capacity;
    }

}
