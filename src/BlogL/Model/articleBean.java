package BlogL.Model;

public class articleBean {
    private String id;
    private String title;
    private String author;//作者（发布用户）
    private String category;
    private String time;
    private double like;
    private double dislike;
    private double commentCount;
    private double visitCount;
    private String content;//文章内容

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public double getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(double commentCount) {
        this.commentCount = commentCount;
    }

    public double getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(double visitCount) {
        this.visitCount = visitCount;
    }
    
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
