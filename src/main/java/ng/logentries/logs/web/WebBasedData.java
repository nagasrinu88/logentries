/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ng.logentries.logs.web;

import ng.logentries.logs.DynoBasedData;
import ng.logentries.util.AttributeKey;

/**
 *
 * @author NavNag
 */
public abstract class WebBasedData extends DynoBasedData {

    @AttributeKey(name = "fwd")
    protected String clientIP;
}
