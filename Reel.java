package Sem3.PrakPBO.UAS;

import java.sql.Timestamp;
import java.util.ArrayList;

public class Reel extends Post {
    private int duration, playedCount;

    public Reel(String postId, ContentState status, Timestamp timeUpload, ContentType postType,
            ArrayList<Comment> listComments, int duration, int playedCount) {
        super(postId, status, timeUpload, postType, listComments);
        this.duration = duration;
        this.playedCount = playedCount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPlayedCount() {
        return playedCount;
    }

    public void setPlayedCount(int playedCount) {
        this.playedCount = playedCount;
    }

    
}
