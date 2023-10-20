package Sem3.PrakPBO.UAS;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void dataDummy(ArrayList<User> listUsers, ArrayList<Post> listPosts) {
        Comment comment1 = new Comment("C-001", "Kembali lagi bersama aku...", ContentState.SHOWED);
        Comment comment2 = new Comment("C-002", "Jaaa matanee mantappuu...", ContentState.PINNED);
        Comment comment3 = new Comment("C-001", "Kembali lagi bersama aku...", ContentState.SHOWED);
        listPosts.get(0).listComments.add(comment1);
        listPosts.get(1).listComments.add(comment2);
        listPosts.get(2).listComments.add(comment3);

        Post post1 = new Post("P-001", ContentState.DELETED, Timestamp.valueOf("2012-09-23 10:39:15"),
                ContentType.VIDEO, listPosts.get(0).listComments);
        Post post2 = new Post("P-002", ContentState.PINNED, Timestamp.valueOf("2017-01-01 11:11:11"),
                ContentType.PICTURE, listPosts.get(1).listComments);
        Post post3 = new Post("P-003", ContentState.SHOWED, Timestamp.valueOf("2023-09-01 19:23:14"),
                ContentType.PICTURE, listPosts.get(0).listComments);
        listPosts.add(post1);
        listPosts.add(post2);
        listPosts.add(post3);

        User user1 = new User("U-412", "gra.tine", "hiyaaa", "serene.", listPosts);
        User user2 = new User("U-534", "hollahopedea", "pacarnya_jeno", "doy's lover", listPosts);
        User user3 = new User("U-612", "onyourm__ark", "canadaohcanada", "subakk", listPosts);
        listUsers.add(user1);
        listUsers.add(user2);
        listUsers.add(user3);
    }

    public static void showUserPost() {
        String printResult = "";
        int counter = 0;
        ArrayList<User> listUsers = new ArrayList<>();
        ArrayList<Post> listPosts = new ArrayList<>();
        dataDummy(listUsers, listPosts);

        for (int i = 0; i < listUsers.size(); i++) {
            User user = listUsers.get(i);
            for (int j = 0; j < listPosts.size(); j++) {
                Post post = user.getListPosts().get(j);

                if (post.getStatus().equals(ContentState.PINNED)) {
                    if (post instanceof Reel) {
                        Reel reel = (Reel) post;
                        printResult = "Have been played " + reel.getPlayedCount() + " times.";
                    } else if (post instanceof Story) {
                        Story story = (Story) post;
                        printResult = "Views count\t: " + story.getViews();
                    } else if (post instanceof Feed) {
                        Feed feed = (Feed) post;
                        printResult = "Likes\t: " + feed.getLikes();
                    }

                } else if (post.getStatus().equals(ContentState.SHOWED)) {
                    if (post instanceof Reel) {
                        Reel reel = (Reel) post;
                        printResult = "Have been played " + reel.getPlayedCount() + " times.";
                    } else if (post instanceof Story) {
                        Story story = (Story) post;
                        printResult = "Views count\t: " + story.getViews();
                    } else if (post instanceof Feed) {
                        Feed feed = (Feed) post;
                        printResult = "Likes\t: " + feed.getLikes();
                    }
                } else if (post.getStatus().equals(ContentState.ARCHIVED)) {
                    if (post instanceof Reel) {
                        Reel reel = (Reel) post;
                        printResult = "Have been played " + reel.getPlayedCount() + " times.";
                    } else if (post instanceof Story) {
                        Story story = (Story) post;
                        printResult = "Views count\t: " + story.getViews();
                    } else if (post instanceof Feed) {
                        Feed feed = (Feed) post;
                        printResult = "Likes\t: " + feed.getLikes();
                    }
                } else if (post.getStatus().equals(ContentState.DELETED)) {
                    counter++;
                    System.out.println("Deleted post(s)\t: " + counter);
                }
            }
        }
    }

    public static void showPost(String idPost) {
        ArrayList<Post> listPosts = new ArrayList<>();
        dataDummy(null, listPosts);

        for (int i = 0; i < listPosts.size(); i++) {
            Post post = listPosts.get(i);
            if (post.getPostId().equals(idPost)) {
                System.out.println(
                        "\nID\t: " + post.getPostId() +
                                "\nContent State\t: " + post.getStatus() +
                                "\nTime stamp\t: " + post.getTimeUpload() +
                                "\nContent type\t: " + post.getPostType() +
                                "\nComments: " + post.listComments.get(i).getText());
            } else {
                System.out.println("Post dengan ID: " + idPost + " tidak ditemukan.");
            }
        }
    }

    public static void changePostState(ContentState newContentState) {
        ArrayList<User> listUsers = new ArrayList<>();
        ArrayList<Post> listPosts = new ArrayList<>();
        dataDummy(listUsers, listPosts);

        for (int i = 0; i < listUsers.size(); i++) {
            User user = listUsers.get(i);
            for (int j = 0; j < listPosts.size(); j++) {
                Post post = user.getListPosts().get(j);

                if (post instanceof Reel) {
                    Reel reel = (Reel) post;
                    
                    if (newContentState == ContentState.ARCHIVED || newContentState == ContentState.PINNED) {
                        reel.getStatus().equals(ContentState.SHOWED);
                    } else if (newContentState == ContentState.ARCHIVED || newContentState == ContentState.SHOWED) {
                        reel.getStatus().equals(ContentState.PINNED);
                    } else if (newContentState == ContentState.SHOWED || newContentState == ContentState.PINNED) {
                        reel.getStatus().equals(ContentState.ARCHIVED);
                    }
                    if (newContentState == ContentState.ARCHIVED) {
                        reel.getStatus().equals(ContentState.DELETED);
                    } else if (newContentState == ContentState.SHOWED || newContentState == ContentState.PINNED) {
                        // post.getStatus().equals(ContentState.ARCHIVED);
                        // post.getStatus().equals(ContentState.DELETED);
                    }
                    
                } else if (post instanceof Story) {
                    Story story = (Story) post;

                    if (newContentState == ContentState.ARCHIVED || newContentState == ContentState.PINNED) {
                        story.getStatus().equals(ContentState.SHOWED);
                    } else if (newContentState == ContentState.ARCHIVED || newContentState == ContentState.SHOWED) {
                        story.getStatus().equals(ContentState.PINNED);
                    } else if (newContentState == ContentState.SHOWED || newContentState == ContentState.PINNED) {
                        story.getStatus().equals(ContentState.ARCHIVED);
                    }
                    if (newContentState == ContentState.ARCHIVED) {
                        story.getStatus().equals(ContentState.DELETED);
                    } else if (newContentState == ContentState.SHOWED || newContentState == ContentState.PINNED) {
                        // story.getStatus().equals(ContentState.ARCHIVED);
                        // story.getStatus().equals(ContentState.DELETED);
                    }
                } else if (post instanceof Feed) {
                    Feed feed = (Feed) post;
                    if (newContentState == ContentState.ARCHIVED || newContentState == ContentState.PINNED) {
                        feed.getStatus().equals(ContentState.SHOWED);
                    } else if (newContentState == ContentState.ARCHIVED || newContentState == ContentState.SHOWED) {
                        feed.getStatus().equals(ContentState.PINNED);
                    } else if (newContentState == ContentState.SHOWED || newContentState == ContentState.PINNED) {
                        feed.getStatus().equals(ContentState.ARCHIVED);
                    }
                    if (newContentState == ContentState.ARCHIVED) {
                        feed.getStatus().equals(ContentState.DELETED);
                    } else if (newContentState == ContentState.SHOWED || newContentState == ContentState.PINNED) {
                        // feed.getStatus().equals(ContentState.ARCHIVED);
                        // feed.getStatus().equals(ContentState.DELETED);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;
        ArrayList<User> listUsers = new ArrayList<>();
        ArrayList<Post> listPosts = new ArrayList<>();
        dataDummy(listUsers, listPosts);

        do {
            System.out.println("Silakan Anda memilih menu:" +
                    "\n1. Show User Post" +
                    "\n2. Show Post" +
                    "\n3. Change Post State" +
                    "\n4. . Exit");
            pilihan = sc.nextInt();

            switch (pilihan) {
                case 1:
                    Main.showUserPost();
                    ;
                    break;
                case 2:
                    String idPost = "P-003";
                    Main.showPost(idPost);
                    break;
                case 3:
                    ContentState newContentState = ContentState.PINNED;
                    Main.changePostState(newContentState);
                    break;
            }
        } while (pilihan != 4);
    }
}
