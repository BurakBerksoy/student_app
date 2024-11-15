package com.example.student.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoStudentIU {

    @NotEmpty(message = "Öğrenci tam adı boş bırakılamaz")
    @Size(min = 6, max = 15, message = "Öğrenci tam adı 6-15 karakter aralığında olmalıdır")
    private String studentFullName;

    @NotEmpty(message = "Öğrenci id boş bırakılamaz")
    @Size(min = 4, max = 4, message = "öğrenci numarası 4 basamaktan oluşmalıdır")
    private String schoolId;
}
