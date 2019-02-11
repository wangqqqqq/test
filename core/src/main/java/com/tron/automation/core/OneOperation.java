package com.tron.automation.core;

/**
 * 一次操作
 */
public abstract class OneOperation implements Operate{
    protected Position position;

    protected Order order;

    /**
     * 执行操作之前做的事情
     */
    public abstract void begin();

    /**
     * 执行操作之后做的事情
     */
    public abstract void end();

    /**
     * 做一些操作
     */
    public abstract void doOperate(Context context);

    public void executeDefaultOperate(Context context) {
        begin();

        doOperate(context);

        end();
    }
}
