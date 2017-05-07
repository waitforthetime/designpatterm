package com.wy.study.java.designpatterm.command.mode;

/**
 * Created by wy_ms on 2017/05/07.
 */
public interface Command {
    public void execute(String name);
    public void undo();
}
