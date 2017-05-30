package com.wy.study.java.thinkinginjava.genericity.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wy_ms on 2017/05/29.
 */
public class ThrowGenericException {
}

interface Processor<T,E extends Exception> {

    void processor(List<T> resultCollector) throws E;


}
/*

class ProcessRunner<T,E extends Exception> extends ArrayList<Processor<T,E>> {
    List<T> processAll() throws E {
        List<T> resultCollector = new ArrayList<>();
        for (Processor processor: this) {
            processor.processor(resultCollector);
        }
        return resultCollector;
    }
}
*/
