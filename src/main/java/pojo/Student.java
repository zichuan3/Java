package pojo;

public class Student {
    private Integer stuid;
    private String stuname;
    public Integer getStuid(){
        return stuid;
    }
    public void setStuid(Integer stuid){
        this.stuid=stuid;
    }
    public String getStuname(){
        return stuname;
    }
    public void setStuname(String stuname){
        this.stuname=stuname;
    }
    public int add(int a, int b) {
        int c = a+b;
        return c;
    }
}
