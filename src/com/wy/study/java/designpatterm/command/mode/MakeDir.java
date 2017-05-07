package com.wy.study.java.designpatterm.command.mode;

import java.io.File;
import java.util.List;

/**
 * Created by wy_ms on 2017/05/07.
 */
public class MakeDir {

    public void makedir(String name) {

        File file = new File(name);
        file.mkdirs();

    }

    public void deletedir(String name) {
        File file = new File(name);
        file.delete();
    }
}
