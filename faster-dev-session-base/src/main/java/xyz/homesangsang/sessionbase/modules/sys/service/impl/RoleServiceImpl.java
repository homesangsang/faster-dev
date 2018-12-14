package xyz.homesangsang.sessionbase.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.homesangsang.sessionbase.modules.sys.entity.RoleEntity;
import xyz.homesangsang.sessionbase.modules.sys.entity.UserRoleEntity;
import xyz.homesangsang.sessionbase.modules.sys.repository.RoleDao;
import xyz.homesangsang.sessionbase.modules.sys.repository.UserRoleDao;
import xyz.homesangsang.sessionbase.modules.sys.service.RoleService;

import java.util.ArrayList;
import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public List<RoleEntity> getRoleList() {
        return roleDao.findAll();
    }

    /**
     * 根据用户id,查询用户拥有角色
     * @param userId
     * @return
     */
    @Override
    public List<RoleEntity> getRoleListByUserId(String userId) {
        List<UserRoleEntity> userRoleList = userRoleDao.findAllByUserId(userId);
        List<String> roleIdList = new ArrayList<>(userRoleList.size());
        userRoleList.forEach(ur -> roleIdList.add(ur.getRoleId()));
        List<RoleEntity> roleList = roleDao.findAllById(roleIdList);
        return roleList;
    }
}
