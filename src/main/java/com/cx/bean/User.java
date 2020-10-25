package com.cx.bean;

import javax.validation.constraints.Pattern;

public class User {
    private Integer id;

    @Pattern(regexp="(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})"
            ,message="用户名必须是2-5位中文或者6-16位英文和数字的组合")
    private String name;

    public User() {
    }

    public User(Integer id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }
    //@Email
    @Pattern(regexp="^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",
            message="邮箱格式不正确")
    private String pwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }
}