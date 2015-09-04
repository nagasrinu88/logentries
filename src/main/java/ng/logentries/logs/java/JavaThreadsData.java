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
public class JavaThreadsData extends LogEntryData {

    @AttributeKey(name = "4")
    private String dyno;
    @AttributeKey(name = "measure.threads.jvm.total")
    private int total;
    @AttributeKey(name = "measure.threads.jvm.daemon")
    private int daemon;
    @AttributeKey(name = "measure.threads.jvm.nondaemon")
    private int nondaemon;
    @AttributeKey(name = "measure.threads.jvm.internal")
    private int internal;

    @Override
    public String getPattern() {
        return "measure.threads.jvm";
    }

    @Override
    public String toString() {
        return "JavaThreadsData{" + "dyno=" + dyno + ", total=" + total + ", daemon=" + daemon + ", nondaemon=" + nondaemon + ", internal=" + internal + '}';
    }
}
