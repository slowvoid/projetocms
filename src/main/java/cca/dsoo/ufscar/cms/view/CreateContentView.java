package cca.dsoo.ufscar.cms.view;
import cca.dsoo.ufscar.cms.controller.ContentController;

class CreateContentView extends View {
    public CreateContentView() {
        super("create_content");
    }

    public void teste(){
        var teste = new ContentController();
        teste.createContent();
    }
}
