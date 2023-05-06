package com.wxq.mall.system;

/**
 * @author weixiaoqiang
 * @date 2023/4/23
 **/
public class RabbitMqProperties {

    private String host = "localhost";

    private Integer port = 5672;

    private String username = "guest";

    private String password = "guest";

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
