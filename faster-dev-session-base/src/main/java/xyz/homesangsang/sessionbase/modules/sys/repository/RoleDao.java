package xyz.homesangsang.sessionbase.modules.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.homesangsang.sessionbase.modules.sys.entity.RoleEntity;

@Repository
public interface RoleDao extends JpaRepository<RoleEntity, String> {

    RoleEntity findRoleEntityByRole(String role);
}
