/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ng.logentries.logs.java;

import ng.logentries.logs.LogEntryData;
import ng.logentries.util.AttributeKey;

/**
 *
 * @author NavNag
 */
public class JavaNonHeapMemoryData extends LogEntryData {

    @AttributeKey(name = "4")
    private String dyno;
    @AttributeKey(name = "measure.mem.jvm.nonheap.used")
    private int used;
    @AttributeKey(name = "measure.mem.jvm.nonheap.committed")
    private int committed;
    @AttributeKey(name = "measure.mem.jvm.nonheap.max")
    private int max;

    @Override
    public String getPattern() {
        return "measure.mem.jvm.nonheap";
    }

    @Override
    public String toString() {
        return "JavaHeapMemoryData{" + "dyno=" + dyno + ", used=" + used + ", committed=" + committed + ", max=" + max + '}';
    }
}
