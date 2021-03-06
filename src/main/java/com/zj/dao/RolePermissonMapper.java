package com.zj.dao;

import com.zj.bean.po.RolePermisson;
import com.zj.bean.vo.RolePermissonVO;

import java.util.List;

public interface RolePermissonMapper {

    int deleteByPrimaryKey(Integer id);

    int deleteByRoleId(Integer roleId);

    int insertSelective(RolePermisson record);

    RolePermisson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermisson record);

    List<RolePermissonVO> listRolePermissons(Integer roleId);

    List<RolePermisson> listRolePermisson(Integer roleId);

    Integer batchInsert(List<RolePermisson> rolePermissons);
}