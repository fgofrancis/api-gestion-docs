package org.fedcoop.repository;

import org.fedcoop.domain.DocType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepo extends JpaRepository<DocType, Long> {
}
