package com.example.student.service.impl;

import com.example.student.dto.DtoStudent;
import com.example.student.dto.DtoStudentIU;
import com.example.student.entity.Student;
import com.example.student.repository.IStudentRepository;
import com.example.student.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public List<DtoStudent> getAllStudents() {
        List<DtoStudent> allDtoStudents = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        for (Student student : students) {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student, dtoStudent);
            allDtoStudents.add(dtoStudent);
        }
        return allDtoStudents;
    }

    @Override
    public DtoStudent getStudentById(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(student.get(), dtoStudent);
            return dtoStudent;
        }
        return null;
    }

    @Override
    public DtoStudent saveNewStudent(DtoStudentIU dtoStudentIU) {
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudentIU, student);
        studentRepository.save(student);
        DtoStudent dtoStudent = new DtoStudent();
        BeanUtils.copyProperties(student, dtoStudent);
        return dtoStudent;
    }

    @Override
    public void deleteStudentById(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        student.ifPresent(deleteStudent -> studentRepository.delete(deleteStudent));
    }

    @Override
    public DtoStudent updateStudentById(Integer id, DtoStudentIU dtoStudentIU) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            Student updateStudent = student.get();
            updateStudent.setStudentFullName(dtoStudentIU.getStudentFullName());
            updateStudent.setSchoolId(dtoStudentIU.getSchoolId());
            studentRepository.save(updateStudent);

            DtoStudent dtoStudent = new DtoStudent();
            BeanUtils.copyProperties(updateStudent, dtoStudent);
            return dtoStudent;
        }
        return null;
    }
}
