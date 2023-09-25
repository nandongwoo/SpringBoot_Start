package com.example.demo.dto;

import com.example.demo.entity.StudentEntity;
import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String studentNumber;
    private String studentName;
    private String studentMobile;
    private String studentMajor;



    // Entity -> DTO 변환 메서드
    public static StudentDTO toSaveDTO(StudentEntity studentEntity){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(studentEntity.getId());
        studentDTO.setStudentMobile(studentEntity.getStudentMobile());
        studentDTO.setStudentMajor(studentEntity.getStudentMajor());
        studentDTO.setStudentName(studentEntity.getStudentName());
        studentDTO.setStudentNumber(studentEntity.getStudentNumber());
        return studentDTO;
    }

}
