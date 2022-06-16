package com.automationpractice.qa.utilities;

import java.util.ResourceBundle;

public class ResourceUtils {
    static final String USER_DIR = System.getProperty("user.dir") + "/";
    private ResourceBundle bundle;

    public ResourceUtils getResource(String file) {
        bundle = ResourceBundle.getBundle(file);
        return this;
    }

    public String getString(String key) {
        return bundle.getString(key);
    }

    public int getInteger(String key) {
        return Integer.parseInt(bundle.getString(key));
    }

    public boolean getBoolean(String key) {
        return Boolean.parseBoolean(bundle.getString(key));
    }
}
