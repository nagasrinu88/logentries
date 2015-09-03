/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ng.logentries.util;

/**
 *
 * @author NavNag
 */
public class Account {

    private String name;
    private String accessKey;
    private String logSetName;
    private String logName;

    public Account(String accessKey, String logSetName, String logName) {
        this.accessKey = accessKey;
        this.logSetName = logSetName;
        this.logName = logName;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getLogSetName() {
        return logSetName;
    }

    public String getLogName() {
        return logName;
    }

    @Override
    public String toString() {
        return "Account{" + "accessKey=" + accessKey + ", logSetName=" + logSetName + ", logName=" + logName + '}';
    }
}
