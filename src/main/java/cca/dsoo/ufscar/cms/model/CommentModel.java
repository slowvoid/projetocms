package cca.dsoo.ufscar.cms.model;

public class CommentModel extends Model {
    private UserModel author = null;
    private ContentModel content;
    private String comment;

    CommentModel() {
        super();
    }

    public UserModel getAuthor() {
        return author;
    }

    public void setAuthor(UserModel author) {
        this.author = author;
    }

    public ContentModel getContent() {
        return content;
    }

    public void setContent(ContentModel content) {
        this.content = content;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
