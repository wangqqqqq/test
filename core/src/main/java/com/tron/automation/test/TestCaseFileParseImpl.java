package com.tron.automation.test;

import com.google.common.base.Enums;
import com.tron.automation.core.*;
import com.tron.automation.core.order.mouse.ClickOrder;
import com.tron.automation.enums.OrderTypeEnum;
import com.tron.automation.enums.ParamTypeEnum;
import com.tron.automation.enums.PositionTypeEnum;
import org.apache.commons.lang3.EnumUtils;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TestCaseFileParseImpl implements TestCaseFileParse {

    @Override
    public OneTest parse(String FilePath, WebDriver webDriver) {
        Context context = new Context();
        context.driver = webDriver;

        return null;
    }
}
