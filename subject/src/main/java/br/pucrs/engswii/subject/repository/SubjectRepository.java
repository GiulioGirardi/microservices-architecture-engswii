package br.pucrs.engswii.subject.repository;

import br.pucrs.engswii.subject.entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
}
