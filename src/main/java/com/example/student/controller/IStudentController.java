package com.example.student.controller;

import com.example.student.dto.DtoStudent;
import com.example.student.dto.DtoStudentIU;

import java.util.List;

public interface IStudentController {
    List<DtoStudent> getAllStudents();
    DtoStudent getStudentById(Integer id);
    DtoStudent saveNewStudent(DtoStudentIU dtoStudentIU);
    void deleteStudentById(Integer id);
    DtoStudent updateStudentById(Integer id, DtoStudentIU dtoStudentIU);

}
