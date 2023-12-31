package br.pucrs.engswii.subject.controller;

import br.pucrs.engswii.subject.dto.SubjectDTO;
import br.pucrs.engswii.subject.entity.SubjectEntity;
import br.pucrs.engswii.subject.service.SubjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("subject-register/v1")
public class SubjectController {

    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }


    @PostMapping("/subject/register")
    public ResponseEntity<SubjectEntity> registerSubject(@RequestBody SubjectDTO subjectDTO) {
        SubjectEntity subjectEntity = SubjectEntity.builder().build();
        BeanUtils.copyProperties(subjectDTO, subjectEntity);

        Optional<SubjectEntity> optionalSubjectEntity = subjectService.saveSubject(subjectEntity);

        if (optionalSubjectEntity.isPresent()) {
            return new ResponseEntity<>(optionalSubjectEntity.get(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}

