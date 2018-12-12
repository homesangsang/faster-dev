package xyz.homesangsang.sessionbase.configure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import xyz.homesangsang.sessionbase.modules.sys.entity.RoleEntity;
import xyz.homesangsang.sessionbase.modules.sys.entity.UserEntity;
import xyz.homesangsang.sessionbase.modules.sys.service.RoleService;
import xyz.homesangsang.sessionbase.modules.sys.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SessionUserDetailService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在!");
        }
        List<RoleEntity> roleList = roleService.getRoleListByUserId(user.getId());
        List<SimpleGrantedAuthority> authList = new ArrayList<>(roleList.size());
        roleList.forEach(role -> authList.add(new SimpleGrantedAuthority(role.getRole())));
        return new User(user.getUsername(), user.getPassword(), authList);
    }
}
