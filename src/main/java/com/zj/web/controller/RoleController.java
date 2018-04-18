package com.zj.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.zj.bean.po.Role;
import com.zj.bean.po.RolePermisson;
import com.zj.service.interfaces.RoleService;
import com.zj.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zj
 */
@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @PostMapping("/role")
    @ResponseBody
    public ResponseEntity addOrEditRole(Role role) {
        if (role == null) {
            return ResponseEntity.error("参数错误");
        }
        if (role.getRoleId() == null) {
            Integer result = roleService.add(role);
            if (result > 0) {
                return ResponseEntity.success();
            } else {
                return ResponseEntity.error("新增失败");
            }
        } else {
            Integer result = roleService.update(role);
            if (result > 0) {
                return ResponseEntity.success();
            } else {
                return ResponseEntity.error("修改失败");
            }
        }
    }

    @DeleteMapping("/role/{roleId}")
    @ResponseBody
    public ResponseEntity deleteRole(@PathVariable("roleId") Integer roleId) {
        Integer result = roleService.delete(roleId);
        if (result > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error("删除失败");
        }
    }

    @GetMapping("/role/{roleId}")
    @ResponseBody
    public ResponseEntity getRole(@PathVariable("roleId") Integer roleId) {
        Role role = roleService.selectByPrimaryKey(roleId);
        return ResponseEntity.success().add("role", role);
    }


    /**
     * 根据角色ID获取此角色拥有的权限Id的集合
     *
     * @param roleId
     * @return
     */
    @GetMapping("/role-permission/{roleId}")
    @ResponseBody
    public ResponseEntity getRolePermission(@PathVariable("roleId") Integer roleId) {
        List<RolePermisson> rolePermissons = roleService.listRolePermisson(roleId);
        List<Integer> permissonIds = rolePermissons.stream().map(RolePermisson::getPermissonId).collect(Collectors.toList());
        return ResponseEntity.success().add("permissonIds", permissonIds);
    }

    @PostMapping(value = "/role-authorization/{roleId}")
    @ResponseBody
    public ResponseEntity RoleAuthorization(
            @PathVariable("roleId") Integer roleId, @RequestParam("permissonIds[]") Integer[] permissonIds) {
        List<Integer> ids = Arrays.asList(permissonIds);
        List<RolePermisson> list = new ArrayList<>();
        RolePermisson rolePermisson = null;
        for (Integer id : ids) {
            rolePermisson = new RolePermisson();
            rolePermisson.setRoleId(roleId);
            rolePermisson.setPermissonId(id);
            list.add(rolePermisson);
        }
        Integer result = roleService.batchInsert(list);
        if (result > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error("授权失败！");
        }
    }
}
