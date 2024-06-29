package cca.dsoo.ufscar.cms.view;

import jdk.jshell.spi.ExecutionControl;

import java.util.Dictionary;

class View implements IView {
    protected String template;
    public View(String template) {
        this.template = template;
    }

    public void render(Dictionary<String, Object> data) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Method View.render not implemented");
    }
}
