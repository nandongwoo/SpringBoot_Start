package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Long save(StudentDTO studentDTO) {
        // DTO -> Entity 변환을 위한 메서드 호출
        StudentEntity studentEntity = StudentEntity.toSaveEntity(studentDTO);
        Long savedId = studentRepository.save(studentEntity).getId(); // DB에서 저장 된 id값을 받아올 수있음
        return savedId;
    }

    public List<StudentDTO> findAll() {
        List<StudentEntity> studentEntityList = studentRepository.findAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();
//        for (StudentEntity studentEntity : studentEntityList) {
//            StudentDTO studentDTO = StudentDTO.toSaveDTO(studentEntity);
//            studentDTOList.add(studentDTO);
//        }
        // ==
        studentEntityList.forEach(studentEntity -> {
            studentDTOList.add(StudentDTO.toSaveDTO(studentEntity));
        });
        /*
          List<studentEntity> -> List<StudentDTO> 로 옮겨담는 코드 작성
          Entity -> DTO 번환하는 메서드는 DTO에 정의
        */
        return studentDTOList;
    }

    public StudentDTO findById(Long id) {
//        Optional<StudentEntity> byId = studentRepository.findById(id);
//        if (byId.isPresent()) {
//            return StudentDTO.toSaveDTO(byId.get());
//        }
//        return null;
//         ==
        return StudentDTO.toSaveDTO(studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException()));
    }

    public void update(StudentDTO studentDTO) {
        StudentEntity studentEntity = StudentEntity.toUpdateEntity(studentDTO);
        /*
            save() 에 넘기는 엔티티 객체에 pk값이 들어있으면 update 쿼리가 나가고
            pk 값이 없으면 insert 쿼리가 나감.
         */
        studentRepository.save(studentEntity);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}