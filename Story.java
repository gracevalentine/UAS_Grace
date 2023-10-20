package Sem3.PrakPBO.UAS;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Story extends Post{
    private int duration, views;

    public Story(String postId, ContentState status, Timestamp timeUpload, ContentType postType,
            ArrayList<Comment> listComments, int duration, int views) {
        super(postId, status, timeUpload, postType, listComments);
        this.duration = duration;
        this.views = views;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    
}
