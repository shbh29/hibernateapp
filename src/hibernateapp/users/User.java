/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateapp.users;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author shubham
 */
@Entity(name = "userdetails")
public class User {
    
    @Column(name = "userid")
    @Id //@GeneratedValue
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    
    @Column(name = "username")
    private String name;
    
    @Temporal(TemporalType.DATE)
    private Date joinedDate;
    
    @Lob
    private String description;
    
    @Embedded
    private Address address;

    public User(Integer Id, String Name) {
        this();
        this.Id = Id;
        this.name = Name;
    }

    public User(Integer Id, String Name, Date joinedDate, String description) {
        this(Id, Name);
        this.joinedDate = joinedDate;
        this.description = description;
    }

    public User() {
    }
    
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    
    public String getName() {
        return name + "from getter";
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    

    @Override
    public String toString() {
        return "User{" + "Id=" + Id + ", name=" + name + ", joinedDate=" + joinedDate + ", description=" + description + '}';
    }
 
    
    
}
