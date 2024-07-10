package cca.dsoo.ufscar.cms.view;

public class ViewFactory {
    public static IView createCreateUserView() {
        return new CreateUserView();
    }

    public static IView createCreateContentView() {
        return new CreateContentView();
    }

    public static IView createUpdateUserView() {
        return new UpdateUserView();
    }

    public static IView createViewUserView() {
        return new ViewUserView();
    }
}
