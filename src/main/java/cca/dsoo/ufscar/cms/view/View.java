package cca.dsoo.ufscar.cms.view;

import jdk.jshell.spi.ExecutionControl;

import java.util.HashMap;

@PackageVisibility
class View implements IView {
    protected String template;
    public View(String template) {
        this.template = template;
    }

    public String render(HashMap<String, Object> data) {
        return this.template;
    }
}
