package com.learn.department.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Department {

    @Id
    @Column(name = "deptId", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @Column(name = "deptName", unique = true, nullable = false)
    private String departmentName;

    @Column(name = "deptCode", unique = true, nullable = false)
    private String departmentCode;

    @Column(name = "description", unique = true, nullable = false)
    private String description;

}
