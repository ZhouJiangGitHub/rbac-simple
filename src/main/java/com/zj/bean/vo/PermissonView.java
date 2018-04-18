package com.zj.bean.vo;

import com.zj.bean.po.Permisson;

import java.util.List;

/**
 * @Author: zj
 * @Description:
 */
public class PermissonView extends Permisson{
    private List<Permisson> childPermissons;

    public List<Permisson> getChildPermissons() {
        return childPermissons;
    }

    public void setChildPermissons(List<Permisson> childPermissons) {
        this.childPermissons = childPermissons;
    }
}
