package org.fedcoop.repository;

import org.fedcoop.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrgRepo extends JpaRepository<Organization, Long > {
   List<Organization> findByKind(Organization.Kind k);
}
