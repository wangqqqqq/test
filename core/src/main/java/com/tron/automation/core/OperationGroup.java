package com.tron.automation.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 *  操作组 一条测试用例对应一组操作 一组测试用例生成一条测试结果
 */
public class OperationGroup{
    private static final Logger log = LoggerFactory.getLogger(OperationGroup.class);

    private List<OneOperation> oneOperationList;

    private int next = 0;

    /**
     * 上下文环境，一组操作拥有一个
     */
    public Context context;

    public void executeNextOperate() {
        if (next >= 0 && next < oneOperationList.size()) {
            next++;
//            log.info("第{}个操作 --------> begin",next);
            oneOperationList.get(next-1).executeOperate(this);

        }
    }

    public List<OperateResult> getOperateResultList() {

        return context.operateResultList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setOneOperationList(List<OneOperation> oneOperationList) {
        this.oneOperationList = oneOperationList;
    }

    public List<OneOperation> getOneOperationList() {
        return oneOperationList;
    }
}
