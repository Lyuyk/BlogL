package BlogL.Model;

public class commentBean {
    private String id;
    private String articleId;
    private String nickName;//评论用户名
    private String content;
    private String time;
    private double like;
    private double dislike;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getLike() {
        return like;
    }

    public void setLike(double like) {
        this.like = like;
    }

    public double getDislike() {
        return dislike;
    }

    public void setDislike(double dislike) {
        this.dislike = dislike;
    }

    public short getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(short jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    private short jurisdiction;
}
