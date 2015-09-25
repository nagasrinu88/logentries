/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ng.logentries.logs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import ng.logentries.util.Account;
import ng.logentries.util.FilterOptions;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author NavNag
 */
public class LogReader {

    private static final LogReader READER = new LogReader();

    private LogReader() {
    }

    public <T extends LogEntryData> List<T> readLogs(Class<? extends LogEntryData> cls, Account account) throws Exception {
        return readLogs(cls, account, 10);
    }

    public <T extends LogEntryData> List<T> readLogs(Class<? extends LogEntryData> cls, Account account, int limit) throws Exception {
        return readLogs(cls, account, new FilterOptions(limit));
    }

    public <T extends LogEntryData> List<T> readLogs(Class<? extends LogEntryData> cls, Account account, FilterOptions options) throws Exception {
        List<T> list = new ArrayList<>();
        LogEntryData instance = cls.newInstance();
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            URIBuilder uriBuilder = new URIBuilder().
                    setScheme("https").
                    setHost("pull.logentries.com/").
                    setPath(account.getAccessKey() + "/hosts/" + account.getLogSetName() + "/" + account.getLogName() + "/");
            uriBuilder.addParameter("limit", "" + options.getLimit());
            uriBuilder.addParameter("filter", instance.getPattern());
            if (options.getsTime() != -1) {
                uriBuilder.addParameter("start", "" + options.getsTime());
            }
            if (options.geteTime() != -1) {
                uriBuilder.addParameter("end", "" + options.geteTime());
                System.out.println(options.geteTime());
            }
            HttpGet get = new HttpGet(uriBuilder.build());
            HttpResponse httpResponse = httpClient.execute(get);
            HttpEntity entity = httpResponse.getEntity();
            Scanner in = new Scanner(entity.getContent());
            while (in.hasNext()) {
                T parse = (T) LogDataMapper.parse(in.nextLine(), cls);
                list.add(parse);
                //System.out.println(parse);
            }
        } catch (Exception e) {
            System.out.println("Error while trying to read logs: " + e);
        } finally {
            if (httpClient != null) {
                httpClient.close();
            }
        }

        return list;
    }

    /**
     * This method gives the instance
     *
     * @return
     */
    public static LogReader getInstance() {
        return READER;
    }
}
