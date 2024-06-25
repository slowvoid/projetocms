package cca.dsoo.ufscar.cms.model;

public class CommentModel extends Model {
    private UserModel author = null;
    private ContentModel content;
    private String comment;

    CommentModel() {
        super();
    }
}
