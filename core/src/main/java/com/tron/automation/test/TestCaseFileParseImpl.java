package com.tron.automation.test;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.File;

public class TestCaseFileParseImpl implements TestCaseFileParse {

    @Override
    public OneTest parse(String FilePath) {
        Config conf = conf = ConfigFactory.parseFile(new File("src/main/resources/trondice-testcase.conf"));
        for (Config config : conf.getConfigList("testCase")) {

        }
        return null;
    }
}
