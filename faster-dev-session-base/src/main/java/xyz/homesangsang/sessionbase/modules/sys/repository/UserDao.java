package xyz.homesangsang.sessionbase.modules.sys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.homesangsang.sessionbase.modules.sys.entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, String> {
    UserEntity findUserEntityByUsername(String username);
}
