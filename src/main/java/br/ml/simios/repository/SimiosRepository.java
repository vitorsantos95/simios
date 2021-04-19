package br.ml.simios.repository;

import java.util.List;

import br.ml.simios.entity.SimiosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimiosRepository extends JpaRepository<SimiosEntity, String> {

    List<SimiosEntity> findBySimian(boolean simian);
}
