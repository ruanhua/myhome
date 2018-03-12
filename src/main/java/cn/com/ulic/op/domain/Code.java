package cn.com.ulic.op.domain;

import java.io.Serializable;

public class Code implements Serializable {

    private Integer id;

    private String type;

    private String unioncode;

    private String unionname;

    private String code;

    private String name;

    /**上级类型*/
    private String upperType;

    /**上级代码*/
    private String upperUnioncode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnioncode() {
        return unioncode;
    }

    public void setUnioncode(String unioncode) {
        this.unioncode = unioncode;
    }

    public String getUnionname() {
        return unionname;
    }

    public void setUnionname(String unionname) {
        this.unionname = unionname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUpperType() {
        return upperType;
    }

    public void setUpperType(String upperType) {
        this.upperType = upperType;
    }

    public String getUpperUnioncode() {
        return upperUnioncode;
    }

    public void setUpperUnioncode(String upperUnioncode) {
        this.upperUnioncode = upperUnioncode;
    }
}