package BlogL.Model;

public class visitorBean {
    private String id;
    private String IP;
    private String time;
    private String WebIP;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWebIP() {
        return WebIP;
    }

    public void setWebIP(String webIP) {
        WebIP = webIP;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    private String host;
}
