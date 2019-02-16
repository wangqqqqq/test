package com.tron.automation.factory;

import com.tron.automation.core.OneOperation;
import com.tron.automation.core.operation.DefaultOneOperation;

public class OneOperationFactory {

    public static OneOperation create(String className) {
        if (className == null) {
            return new DefaultOneOperation();
        }

        try {

           return (OneOperation) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return new DefaultOneOperation();
    }
}
