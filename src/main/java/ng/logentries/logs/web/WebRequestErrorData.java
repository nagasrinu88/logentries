/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ng.logentries.logs.web;

import ng.logentries.util.AttributeKey;

/**
 *
 * @author NavNag
 */
public class WebRequestErrorData extends WebRequestData {

    @AttributeKey(name = "code")
    private String code;
    @AttributeKey(name = "desc")
    private String descreption;

    @Override
    public String getPattern() {
        return "at=error";
    }

    @Override
    public String toString() {
        return "WebRequestErrorData{" + "code=" + code + ", descreption=" + descreption + '}';
    }

}
