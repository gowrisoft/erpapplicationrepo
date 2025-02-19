package com.gentech.erp.hr.zsecurity.repository;

import com.gentech.erp.hr.entity.Employee;
import com.gentech.erp.hr.zsecurity.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MyUserRepository extends JpaRepository<MyUser, Long> {
    Optional<MyUser> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmployee(Employee employee);
    Optional<MyUser> findByEmployee_Email(String email);
}