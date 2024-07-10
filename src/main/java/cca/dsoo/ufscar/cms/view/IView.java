package cca.dsoo.ufscar.cms.view;

import jdk.jshell.spi.ExecutionControl;

import java.util.HashMap;

public interface IView {
    String render(HashMap<String, Object> data);
}
