package cn.itcast.config;

public class Mapper {
    //TODO
    private String resultType;//返回结果类型
    private String sql;//存储sql语句


    public Mapper() {
    }

    public Mapper(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }




    //TODO
    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
