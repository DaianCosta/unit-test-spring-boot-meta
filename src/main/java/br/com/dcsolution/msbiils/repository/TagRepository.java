package br.com.dcsolution.msbiils.repository;

import br.com.dcsolution.msbiils.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
}
