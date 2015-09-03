/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ng.logentries.logs.java;

import ng.logentries.logs.LogDataMapper;
import ng.logentries.logs.LogEntryData;
import ng.logentries.util.AttributeKey;

/**
 *
 * @author NavNag
 */
public class JavaHeapMemoryData extends LogEntryData {

    @AttributeKey(name = "4")
    private String dyno;
    @AttributeKey(name = "measure.mem.jvm.heap.used")
    private int used;
    @AttributeKey(name = "measure.mem.jvm.heap.committed")
    private int committed;
    @AttributeKey(name = "measure.mem.jvm.heap.max")
    private int max;

    @Override
    public String getPattern() {
        return "measure.mem.jvm.heap";
    }

    @Override
    public String toString() {
        return "JavaHeapMemoryData{" + "dyno=" + dyno + ", used=" + used + ", committed=" + committed + ", max=" + max + '}';
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        String log = "192 <190>1 2015-08-26T00:02:15.603974+00:00 app worker.1 - - measure.mem.jvm.heap.used=49M measure.mem.jvm.heap.committed=285M measure.mem.jvm.heap.max=349M";
        JavaHeapMemoryData data = LogDataMapper.parse(log, JavaHeapMemoryData.class);
        System.out.println(data);
    }

}
