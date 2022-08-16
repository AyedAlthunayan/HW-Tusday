package com.example.hw_tuesday.Repository;

import com.example.hw_tuesday.Model.Student;
import com.example.hw_tuesday.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherById(Integer id);
    List<Teacher> findBySalaryGreaterThanEqual(Integer salary);


}
