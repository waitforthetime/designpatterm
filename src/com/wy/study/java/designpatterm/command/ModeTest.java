package com.wy.study.java.designpatterm.command;

import com.wy.study.java.designpatterm.command.mode.MakeDir;
import com.wy.study.java.designpatterm.command.mode.MakeDirCommand;
import com.wy.study.java.designpatterm.command.mode.MakeDirRequestor;

/**
 * Created by wy_ms on 2017/05/07.
 */
public class ModeTest {

    public static void main(String[] args) {

        MakeDir makeDir = new MakeDir();
        MakeDirCommand makeDirCommand = new MakeDirCommand(makeDir);
        MakeDirRequestor requestor = new MakeDirRequestor();
        requestor.setCommand(makeDirCommand);
        requestor.makedir("E:/first");
        requestor.makedir("E:/secoond");
        requestor.makedir("E:/third");
        requestor.undo();
        requestor.undo();
    }

}
