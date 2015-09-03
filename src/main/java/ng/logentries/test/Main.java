/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ng.logentries.test;

import com.google.gson.Gson;
import java.util.List;
import ng.logentries.logs.LogReader;
import ng.logentries.logs.db.pg.PostgresLogEntryData;
import ng.logentries.util.Account;

/**
 *
 * @author NavNag
 */
public class Main {

    public static void main(String[] args) throws Exception {
        //Account acc = new Account("7b89f984-a108-43a1-af99-1452bf94ea2c", "Heroku", "canvass");
        //Account acc = new Account("4938fe3c-1707-4812-b59a-eedde9d5c465", "Heroku", "canvass-new");
        Account acc = new Account("6e69dce5-024d-41de-b536-312853bf481b", "Heroku", "zirrtue-main");
        List<PostgresLogEntryData> logs = LogReader.getInstance().readLogs(PostgresLogEntryData.class, acc, 25);
        //List<JavaHeapMemoryData> logs = getInstance().readLogs(JavaHeapMemoryData.class, acc, 100);
        //List<WebRequestData> logs = getInstance().readLogs(WebRequestData.class, acc, 50);
        //System.out.println(logs);
        System.out.println(new Gson().toJson(logs));
    }
}
