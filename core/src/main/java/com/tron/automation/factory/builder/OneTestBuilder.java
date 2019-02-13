package com.tron.automation.factory.builder;

import com.tron.automation.test.OneTest;

/**
 * 测试建造者
 */
public interface OneTestBuilder<P> extends Builder<OneTest>{

    void setBuilderParam(P p);

    void buildOneOperation();

    void buildOperationGroup();

    void buildTestCase();
}
