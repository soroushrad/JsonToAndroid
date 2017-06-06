package plazmid.myapplication;

/**
 * Created by soroush on 6/5/2017 AD.
 */

public class NewsModel {


    private String title;
    private String Content;

    public NewsModel() {
    }

    public NewsModel(String title, String content) {
        this.title = title;
        Content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
