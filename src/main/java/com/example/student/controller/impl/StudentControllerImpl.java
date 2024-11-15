package com.example.student.controller.impl;

import com.example.student.controller.IStudentController;
import com.example.student.dto.DtoStudent;
import com.example.student.dto.DtoStudentIU;
import com.example.student.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping(path = "/api/student")
public class StudentControllerImpl implements IStudentController {

    @Autowired
    private IStudentService studentService;

    @GetMapping(path = "/list/all")
    @Override
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoStudent getStudentById(@Valid @PathVariable(name = "id") Integer id) {
        DtoStudent dtoStudent = studentService.getStudentById(id);
        if (dtoStudent == null) {
            throw new RuntimeException("Student not found");
        }
        return dtoStudent;
    }

    @PostMapping(path = "/save")
    public DtoStudent saveNewStudent(@Valid @RequestBody DtoStudentIU dtoStudentIU) {
        return studentService.saveNewStudent(dtoStudentIU);
    }


    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteStudentById(@Valid @PathVariable(name = "id") Integer id) {
        DtoStudent dtoStudent = studentService.getStudentById(id);
        if (dtoStudent == null) {
            throw new RuntimeException("Student not found");
        }
        studentService.deleteStudentById(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoStudent updateStudentById(@Valid @PathVariable(name = "id") Integer id,
                                        @Valid @RequestBody DtoStudentIU dtoStudentIU) {
        DtoStudent dtoStudent = studentService.getStudentById(id);
        if (dtoStudent == null) {
            throw new RuntimeException("Student not found");
        }
        return studentService.updateStudentById(id, dtoStudentIU);
    }
}
