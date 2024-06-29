package cca.dsoo.ufscar.cms.view;

import jdk.jshell.spi.ExecutionControl;

import java.util.Dictionary;

public interface IView {
    void render(Dictionary<String, Object> data) throws ExecutionControl.NotImplementedException;
}
