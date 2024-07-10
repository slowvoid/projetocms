package cca.dsoo.ufscar.cms.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ContentModel extends Model {
    private UserModel author;
    private String title;
    private String content;

    ContentModel() {
        super();
    }

    public UserModel getAuthor() {
        return author;
    }

    public void setAuthor(UserModel author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public HashMap<String, Object> getModelMap() {
        return null;
    }

    @Override
    public void create() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void update() {

    }

    @Override
    public ArrayList<Model> find() {
        return null;
    }
}
