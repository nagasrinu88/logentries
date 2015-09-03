/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ng.logentries.logs;

import ng.logentries.util.AttributeKey;

/**
 *
 * @author NavNag
 */
public abstract class LogEntryData {

    @AttributeKey(name = "2")
    protected String time;

    public abstract String getPattern();
}
