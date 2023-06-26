package br.pucrs.engswii.user.repository;

import br.pucrs.engswii.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}

