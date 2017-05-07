package com.wy.study.java.designpatterm.command.mode;

/**
 * Created by wy_ms on 2017/05/07.
 */
public class MakeDirRequestor {

    private MakeDirCommand command;

    public void setCommand(MakeDirCommand command) {
        this.command = command;
    }

    public void makedir(String name) {
        command.execute(name);
    }

    public void undo() {
        command.undo();
    }

}
