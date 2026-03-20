package org.annotationbasedconfiguration.repository;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    public StudentRepository(){
        System.out.println("student repository");
    }
}
