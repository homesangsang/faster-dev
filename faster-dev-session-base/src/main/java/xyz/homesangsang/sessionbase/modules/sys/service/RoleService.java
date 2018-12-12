package xyz.homesangsang.sessionbase.modules.sys.service;

import xyz.homesangsang.sessionbase.modules.sys.entity.RoleEntity;

import java.util.List;

public interface RoleService {
    List<RoleEntity> getRoleListByUserId(String userId);
}
