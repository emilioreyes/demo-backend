package com.backend.demo.persistence.Crud;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.demo.persistence.entity.MedicalAppointmentHeaderEntity;

public interface MedicalAppointemntCrudRepository extends JpaRepository<MedicalAppointmentHeaderEntity,Integer> {
    
}
