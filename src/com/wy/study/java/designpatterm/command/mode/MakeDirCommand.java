package com.wy.study.java.designpatterm.command.mode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wy_ms on 2017/05/07.
 */
public class MakeDirCommand implements Command {

    private MakeDir makeDir;
    private List<String> dirnames;

    public MakeDirCommand(MakeDir makeDir) {
        this.makeDir = makeDir;
        this.dirnames = new ArrayList<>();
    }

    @Override
    public void execute(String name) {
        makeDir.makedir(name);
        dirnames.add(name);
    }

    /**
     * 撤销的含义：撤销已执行的命令，撤销最后一次指令
     */
    @Override
    public void undo() {
        if (dirnames.isEmpty()) {
            System.out.println("没有需要撤销的命令");
        } else {
            int size = dirnames.size();
            makeDir.deletedir(dirnames.get(size - 1));
            dirnames.remove(size - 1);
        }
    }
}
