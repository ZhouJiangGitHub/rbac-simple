package com.zj.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zj.bean.po.Permisson;
import com.zj.service.interfaces.PermissionService;
import com.zj.util.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zj
 * @Description:
 */
@RestController
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @PostMapping("/permission")
    @ResponseBody
    public ResponseEntity addOrEditPermission(Permisson permission) {
        if (permission == null) {
            return ResponseEntity.error("参数错误");
        }
        if (permission.getPermissonId() == null) {
            Integer result = permissionService.add(permission);
            if (result > 0) {
                return ResponseEntity.success();
            } else {
                return ResponseEntity.error("新增失败");
            }
        } else {
            Integer result = permissionService.update(permission);
            if (result > 0) {
                return ResponseEntity.success();
            } else {
                return ResponseEntity.error("修改失败");
            }
        }
    }

    @DeleteMapping("/permission/{permissionId}")
    @ResponseBody
    public ResponseEntity deletePermission(@PathVariable("permissionId") Integer permissionId) {
        Integer result = permissionService.delete(permissionId);
        if (result > 0) {
            return ResponseEntity.success();
        } else {
            return ResponseEntity.error("删除失败");
        }
    }

    @GetMapping("/permission/{permissionId}")
    @ResponseBody
    public ResponseEntity getPermission(@PathVariable("permissionId") Integer permissionId) {
        Permisson permisson = permissionService.selectByPrimaryKey(permissionId);
        return ResponseEntity.success().add("permisson", permisson);
    }
}
