package Sem3.PrakPBO.UAS;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Feed extends Post {
    private String caption;
    private int likes;

    public Feed(String postId, ContentState status, Timestamp timeUpload, ContentType postType,
            ArrayList<Comment> listComments, String caption, int likes) {
        super(postId, status, timeUpload, postType, listComments);
        this.caption = caption;
        this.likes = likes;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    
}
