package org.volans.kafka;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.Stores;

/**
 * @author <a href="http://github.com/athc">j</a>
 * @date 2019-11-04
 * @since JDK1.8
 */
public class MyProcessor implements Processor {

    private ProcessorContext processorContext;

    private KeyValueStore keyValueStore;

    @Override

    public void init(ProcessorContext processorContext) {
        this.processorContext = processorContext;
//        this.processorContext.schedule();
        this.keyValueStore = (KeyValueStore) processorContext.getStateStore("counts");
    }

    @Override public void process(Object o, Object o2) {
        Stores.inMemoryKeyValueStore("counts");

    }

    @Override public void close() {
        this.keyValueStore.close();
    }
}
