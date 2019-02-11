package com.tron.automation.core;

/**
 * 命令 如：鼠标的单击命令，双击命令
 */
public interface Order {

    /**
     * 执行命令，命令作用再位置上
     */
    void execute(Position position, Context context);
}
