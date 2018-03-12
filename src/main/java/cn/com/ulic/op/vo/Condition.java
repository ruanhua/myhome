package cn.com.ulic.op.vo;

/**
 * @author ruanhua
 * @date 2017/12/4
 */
public class Condition {

    /**父id*/
    private String parentId;

    /**1省2市3区*/
    private String levelType;

    private String codeType;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }
}
