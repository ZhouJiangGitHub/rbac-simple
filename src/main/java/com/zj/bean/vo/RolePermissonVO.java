package com.zj.bean.vo;

import com.zj.bean.po.Permisson;
import com.zj.bean.po.Role;

import java.util.List;

/**
 * @Author: zj
 * @Description:
 */
public class RolePermissonVO extends Role {

    private Permisson permisson;//角色拥有的权限

    public void setPermisson(Permisson permisson) {
        this.permisson = permisson;
    }

    public Permisson getPermisson() {
        return permisson;
    }
}
