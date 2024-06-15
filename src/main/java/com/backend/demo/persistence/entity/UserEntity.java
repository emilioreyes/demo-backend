package com.backend.demo.persistence.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sec_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    
    @NonNull
    @Column(name = "first_name")
    private String firstName;
    @NonNull
    @Column(name = "last_name")
    private String lastName;
    @NonNull
    private String document;

    @NonNull
    private String password;
    @CreationTimestamp
    @Column(name = "create_date", insertable = true, updatable = false)
    private LocalDateTime createDate;
    @UpdateTimestamp
    @Column(name = "update_date", insertable = false, updatable = true)
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "userEntity")
    private List<MedicalAppointmentHeaderEntity> headerMedicalAppointmentEntity=new ArrayList<>();
}
