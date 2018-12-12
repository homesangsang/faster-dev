package xyz.homesangsang.sessionbase.modules.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.homesangsang.sessionbase.modules.sys.entity.UserRoleEntity;

import java.util.List;

@Repository
public interface UserRoleDao extends JpaRepository<UserRoleEntity, String> {
    List<UserRoleEntity> findAllByUserId(String userId);
}
