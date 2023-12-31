package br.pucrs.engswii.matriculate.service;

import br.pucrs.engswii.matriculate.entity.MatriculateEntity;
import br.pucrs.engswii.matriculate.repository.MatriculateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculateService {

    private MatriculateRepository matriculateRepository;

    @Autowired
    public MatriculateService(MatriculateRepository matriculateRepository) {
        this.matriculateRepository = matriculateRepository;
    }

    public Optional<MatriculateEntity> saveMatriculates(MatriculateEntity matriculateEntity) {
        return Optional.ofNullable(matriculateRepository.save(matriculateEntity));
    }

    public List<MatriculateEntity> findByRegistrationStudent(Long registrationStudent) {
        return matriculateRepository.findMatriculateEntitiesByRegistrationStudent(registrationStudent);
    }

    public List<MatriculateEntity> findBySubjectCode(String subjectCode) {
        return matriculateRepository.findMatriculateEntitiesBySubjectCode(subjectCode);
    }

    public List<MatriculateEntity> findBySubjectClass(Long subjectClass) {
        return matriculateRepository.findMatriculateEntitiesBySubjectClass(subjectClass);
    }

    public boolean studentAlreadyMatriculates(MatriculateEntity matriculateEntity) {
        List<MatriculateEntity> listMatriculatesStudent = matriculateRepository.findMatriculateEntitiesByRegistrationStudent(matriculateEntity.getRegistrationStudent());
        return listMatriculatesStudent
                .stream()
                .anyMatch(matriculate ->
                        matriculate.getSubjectCode().equals(matriculateEntity.getSubjectCode()));
    }
}

