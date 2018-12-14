package xyz.homesangsang.sessionbase.modules.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.homesangsang.sessionbase.modules.sys.entity.RoleEntity;
import xyz.homesangsang.sessionbase.modules.sys.service.RoleService;
import xyz.homesangsang.sessionbase.util.R;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping
    public R roleList () {
        List<RoleEntity> roleList = roleService.getRoleList();
        return R.ok().put("data", roleList);
    }
}
