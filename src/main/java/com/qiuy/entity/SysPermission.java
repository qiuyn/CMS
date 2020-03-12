package com.qiuy.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2019/12/8.
 */
@Entity
public class SysPermission implements Serializable {
    @Id
    @GeneratedValue
    private long id;//主键.
    private String name;//名称.
    private String url;//资源路径.
    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="SysRolePermission",joinColumns={@JoinColumn(name="permissionId")},inverseJoinColumns={@JoinColumn(name="roleId")})
    private List<SysRole> roles;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public String getPermission() {
        return permission;
    }
}
