package cn.com.ulic.op.domain;
/**
 * @author ruanhua
 */
public class Area {
    private Integer id;
    /**父id*/
    private Integer parentId;
    /**名称*/
    private String  name;
    /**1省2市3区*/
    private Integer levelType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevelType() {
        return levelType;
    }

    public void setLevelType(Integer levelType) {
        this.levelType = levelType;
    }
}
