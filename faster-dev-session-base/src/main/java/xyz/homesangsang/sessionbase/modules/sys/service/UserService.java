package xyz.homesangsang.sessionbase.modules.sys.service;

import xyz.homesangsang.sessionbase.modules.sys.entity.UserEntity;

public interface UserService {
    UserEntity getUserByUsername(String username);

    void saveUser(UserEntity user);
}
