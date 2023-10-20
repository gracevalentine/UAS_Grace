package Sem3.PrakPBO.UAS;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Post {
    private String postId;
    private ContentState status;
    private Timestamp timeUpload;
    private ContentType postType;
    ArrayList<Comment> listComments = new ArrayList<>();

    public Post(String postId, ContentState status, Timestamp timeUpload, ContentType postType,
            ArrayList<Comment> listComments) {
        this.postId = postId;
        this.status = status;
        this.timeUpload = timeUpload;
        this.postType = postType;
        this.listComments = listComments;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public ContentState getStatus() {
        return status;
    }

    public void setStatus(ContentState status) {
        this.status = status;
    }

    public Timestamp getTimeUpload() {
        return timeUpload;
    }

    public void setTimeUpload(Timestamp timeUpload) {
        this.timeUpload = timeUpload;
    }

    public ContentType getPostType() {
        return postType;
    }

    public void setPostType(ContentType postType) {
        this.postType = postType;
    }

    public ArrayList<Comment> getListComments() {
        return listComments;
    }

    public void setListComments(ArrayList<Comment> listComments) {
        this.listComments = listComments;
    }

}
