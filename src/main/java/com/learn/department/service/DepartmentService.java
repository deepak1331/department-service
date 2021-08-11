package com.learn.department.service;

import com.learn.department.entity.Department;
import com.learn.department.exception.ResourceNotFoundException;
import com.learn.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository repository;

    public Department saveDepartment(Department department) {
        log.info("Saving Single Department Info");
        return repository.save(department);
    }

    public List<Department> saveDepartments(List<Department> departmentList) {
        log.info("Saving Multiple ({}) Department's Info", departmentList.size());
        return repository.saveAll(departmentList);
    }

    public Department findDepartmentById(Long id) {
        log.info("Searching for Department with ID : {}", id);
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department not found with ID:" + id));
    }

    public List<Department> findAllDepartments() throws ResourceNotFoundException {
        log.info("Fetching all Departments list");
        return repository.findAll();
    }

    public Page<Department> findAllDepartments(int page) throws ResourceNotFoundException {
        log.info("Fetching all Departments list with Pagination, PageNo {} sorted by DeptCode then DeptName", page);
        Pageable first20SortedByDeptCodeAndDeptName = PageRequest.of(page, 20, Sort.by("departmentCode")
                .ascending().and(Sort.by("departmentName").descending()));
        Page<Department> response = repository.findAll(first20SortedByDeptCodeAndDeptName);
        if (response != null)
            return response;
        else
            throw new ResourceNotFoundException("No Department information not found");
    }
}
