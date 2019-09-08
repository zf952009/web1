package cn.itcast.domain;

/**
 * codening:utf-8
 *
 * @author :File_List
 * @time :2019.07.09,12:35
 * @file :cn.itcast.domain.File_List.jave
 */
public class File_List {
    private Integer id;
    private String name;
    private String url;
    private Integer res;

    public File_List() {
    }

    @Override
    public String toString() {
        return "File_List{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", res=" + res +
                '}';
    }

    public Integer getRes() {
        return res;
    }

    public void setRes(Integer res) {
        this.res = res;
    }

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
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
