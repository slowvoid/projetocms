package cca.dsoo.ufscar.cms.util;

public class Logger {
    private static Logger _instance;
    private Logger() {}

    public static Logger getInstance() {
        if(_instance == null) {
            _instance = new Logger();
        }

        return _instance;
    }

    public void error(String msg) {
        System.out.println(msg);
    }

    public void log(String msg) {
        System.out.println(msg);
    }
}
