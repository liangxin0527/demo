package com.example.mongodb.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.sql.DataSourceDefinition;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Document("agg")
public class Users implements Serializable {
// id 必须是字符串类型
    @Id
    private String id;
    private String username;
    private List<String> userlike;
    private Date userbirth;
    private Integer userage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getUserlike() {
        return userlike;
    }

    public void setUserlike(List<String> userlike) {
        this.userlike = userlike;
    }

    public Date getUserbirth() {
        return userbirth;
    }

    public void setUserbirth(Date userbirth) {
        this.userbirth = userbirth;
    }

    public Integer getUserage() {
        return userage;
    }

    public void setUserage(Integer userage) {
        this.userage = userage;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", userlike=" + userlike +
                ", userbirth=" + userbirth +
                ", userage=" + userage +
                '}';
    }
}
