/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ng.logentries.logs.db.pg;

import ng.logentries.logs.LogEntryData;
import ng.logentries.util.AttributeKey;

/**
 *
 * @author NavNag
 */
public class PostgresLogEntryData extends LogEntryData {

    // all the memory related value are in K.Bs
    @AttributeKey(name = "sample#current_transaction")
    private int currentTransactions;
    @AttributeKey(name = "sample#db_size")
    private long dbSize;
    @AttributeKey(name = "sample#tables")
    private int tables;
    @AttributeKey(name = "sample#active-connections")
    private int activeConnections;
    @AttributeKey(name = "sample#waiting-connections")
    private int waitingConnections;
    @AttributeKey(name = "sample#index-cache-hit-rate")
    private float indexCacheHitRatio;
    @AttributeKey(name = "sample#table-cache-hit-rate")
    private float tableCacheHitRatio;
    @AttributeKey(name = "sample#read-iops")
    private float readIOPS;
    @AttributeKey(name = "sample#write-iops")
    private float writeIOPS;
    @AttributeKey(name = "sample#memory-total")
    private long totalMemory;
    @AttributeKey(name = "sample#memory-free")
    private long freeMemory;
    @AttributeKey(name = "sample#memory-cached")
    private long cachedMemory;
    @AttributeKey(name = "sample#memory-postgres")
    private long postgresMemory;

    @Override
    public String toString() {
        return "PostgresLogEntryData{time=" + time + ",currentTransactions=" + currentTransactions + ", dbSize=" + dbSize + ", tables=" + tables + ", activeConnections=" + activeConnections + ", waitingConnections=" + waitingConnections + ", indexCacheHitRatio=" + indexCacheHitRatio + ", tableCacheHitRatio=" + tableCacheHitRatio + ", readIOPS=" + readIOPS + ", writeIOPS=" + writeIOPS + ", totalMemory=" + totalMemory + ", freeMemory=" + freeMemory + ", cachedMemory=" + cachedMemory + ", postgresMemory=" + postgresMemory + '}';
    }

    @Override
    public String getPattern() {
        return "app heroku-postgres";
    }

    public static void main(String[] args) {
        System.out.println(Long.parseLong("14575610528 bytes".replaceAll("\\D", "")));
    }
}
