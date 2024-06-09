package com.backend.demo.persistence.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "bus_medical_appointment_header")
public class MedicalAppointmentHeaderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medical_appointment_id")
    private Integer medicalAppointmentId;
    @Column(name = "medical_appointment_description")
    private String medicalAppointmentDescription;
    @CreationTimestamp
    @Column(name = "create_date", insertable = true, updatable = false)
    private LocalDateTime createDate;
    @UpdateTimestamp
    @Column(name = "update_date", insertable = false, updatable = true)
    private LocalDateTime updateDate;
    
    @ManyToOne
    @JoinColumn(name="user_id")
    private UserEntity userEntity;
}
