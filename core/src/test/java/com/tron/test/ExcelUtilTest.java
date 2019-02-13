package com.tron.test;

import com.tron.automation.util.ExcelUtil;
import org.junit.Test;

import java.io.File;
import java.util.List;

public class ExcelUtilTest {

    @Test
    public void testReader() {
        List<List> list = ExcelUtil.readExcel(new File("D://teondice-testcase.xlsx"));
        for (List a : list) {
            for (Object o: a) {
                System.out.println(o);
            }
        }
    }
}
