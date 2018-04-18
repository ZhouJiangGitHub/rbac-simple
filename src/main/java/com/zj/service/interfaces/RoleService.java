package com.zj.service.interfaces;

import com.zj.bean.po.Role;
import com.zj.bean.po.RolePermisson;
import com.zj.bean.vo.RolePermissonVO;

import java.util.List;

/**
 * @Author: zj
 * @Description:
 */
public interface RoleService {

    Integer add(Role role);

    Integer delete(Integer roleId);

    Integer update(Role role);

    List<Role> listRole(Role role);

    Role selectByPrimaryKey(Integer roleId);

    List<RolePermisson> listRolePermisson(Integer roleId);

    List<RolePermissonVO> listRolePermissons(Integer roleId);

    Integer batchInsert(List<RolePermisson> rolePermissons);

    Integer deleteByRoleId(Integer roleId);

}
