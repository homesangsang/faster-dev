package xyz.homesangsang.sessionbase.modules.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.homesangsang.sessionbase.modules.sys.entity.RoleEntity;
import xyz.homesangsang.sessionbase.modules.sys.entity.UserEntity;
import xyz.homesangsang.sessionbase.modules.sys.entity.UserRoleEntity;
import xyz.homesangsang.sessionbase.modules.sys.repository.RoleDao;
import xyz.homesangsang.sessionbase.modules.sys.repository.UserDao;
import xyz.homesangsang.sessionbase.modules.sys.repository.UserRoleDao;
import xyz.homesangsang.sessionbase.modules.sys.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;
    @Autowired
    private RoleDao roleDao;

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    @Override
    public UserEntity getUserByUsername(String username) {
        return userDao.findUserEntityByUsername(username);
    }

    /**
     * 注册
     * @param user
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUser(UserEntity user) {
        RoleEntity roleEntity = roleDao.findRoleEntityByRole("ROLE_USER");
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.saveAndFlush(user);
        UserRoleEntity ur = new UserRoleEntity();
        ur.setUserId(user.getId());
        ur.setRoleId(roleEntity.getId());
        userRoleDao.saveAndFlush(ur);
    }
}
