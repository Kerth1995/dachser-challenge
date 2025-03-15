package com.datcher.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.util.Date;

@MappedSuperclass
public class Auditory extends BaseEntity{

    @Column(name = "create_user")
    public String createUser;

    @Column(name = "update_user")
    public String updateUser;

    @Column(name = "create_date")
    public Date createDate;

    @Column(name = "update_date")
    public Date updateDate;

    @PrePersist
    public void prePersist(){
        this.createUser = "user_admin";
        this.createDate = new Date();
        this.setRegisterState(1);
    }

    @PreUpdate
    public void preUpdate(){
        this.updateUser = "user_admin";
        this.updateDate = new Date();
    }
}
