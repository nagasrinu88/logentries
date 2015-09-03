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

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        //String s = "334 <158>1 2015-08-26T00:13:02.436378+00:00 heroku router - - at=info method=POST path=\"/onlineCampaignHandler.do?action=NEW_EMAIL_HISTORY_UPDATE\" host=canvass.herokuapp.com request_id=d773f5ab-b52d-48bf-88f4-fcdec78da646 fwd=\"198.37.145.29\" dyno=web.1 connect=0ms service=45ms status=200 bytes=221";
        String s = "798 <158>1 2015-08-26T01:07:49.815349+00:00 heroku router - - at=error code=H12 desc=\"Request timeout\" method=GET path=\"/CustomerServiceHandler.do?apiAccessKey=468063a5897103c38c75b0675f41b6f00eccfa34&apiSecret=1abf59cf45b11b16b927600102a0505fa0bf6da1&action=ADD_CUSTOMER&data={%22name%22:%22krishna%20kumar%22,%22email%22:%22srivastava.850@gmail.com%22,%22mobileNumber%22:%229369365040%22,%22city%22:%22pratapgarh%22,%22CLPRODCATEGORY%22:%22BANK%22,%22CLPRODTYPE%22:%22TS%22,%22Registration_Date%22:%2226/08/2015%22,%22CLENQID%22:%22641286%22,%22CLSOURCE%22:%22Google%20Ads%22}&sublist=[%22Google:Bank%20TS%22]\" host=dashboard.canvass.in request_id=ba191f1b-039a-4a97-ae16-3f223fcf59cf fwd=\"52.74.39.47\" dyno=web.1 connect=1ms service=30000ms status=503 bytes=0";
        WebRequestErrorData data = LogDataMapper.parse(s, WebRequestErrorData.class);
        System.out.println(data);
    }
}
