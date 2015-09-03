/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ng.logentries.logs.web;

import ng.logentries.logs.LogDataMapper;
import ng.logentries.util.AttributeKey;

/**
 *
 * @author NavNag
 */
public class WebRequestData extends WebBasedData {

    @AttributeKey(name = "method")
    private String method;
    @AttributeKey(name = "path")
    private String path;
    @AttributeKey(name = "connect")
    private int connect;
    @AttributeKey(name = "service")
    private int service;
    @AttributeKey(name = "status")
    private int status;
    @AttributeKey(name = "bytes")
    private int bytes;

    @Override
    public String getPattern() {
        return "heroku router";
    }

    @Override
    public String toString() {
        return "WebRequestData{" + "method=" + method + ", path=" + path + ", clientIP=" + clientIP + ", dyno=" + dyno + ", connect=" + connect + ", service=" + service + ", status=" + status + ", bytes=" + bytes + '}';
    }

}
