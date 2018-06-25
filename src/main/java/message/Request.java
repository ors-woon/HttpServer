package main.java.message;


import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Request implements Serializable {
    private String method;
    private String path;
    private String version;
    private Map<String, String> headers;
    private String contents;

    public static Request init(BufferedReader br) throws IOException {
        Request request = new Request();
        request.makeStartLine(br.readLine())
                .makeHeader(br);
        return request;

    }

    private Request makeStartLine(String startLine) {
        if(startLine == null){
            new IllegalArgumentException("first line is null. It is invalid data format.");
        }

        String[] array = startLine.split(" ");
        this.method = array[0];
        this.path = array[1];
        this.version = array[2];
        return this;
    }

    private Request makeHeader(BufferedReader br) throws IOException {
        String line = br.readLine();
        this.headers = new HashMap();
        for (; line != null; line = br.readLine()) {
            if(StringUtils.isBlank(line)){
                return this;
            }
            String[] element = line.split(":");
            headers.put(element[0], element[1]);
        }
        return this;
    }

    public String getMethod() {
        return method;
    }

    public String getVersion() {
        return version;
    }

    public String getPath() {
        return path;
    }

    public Map getHeaders() {
        return headers;
    }

    public String getContents() {
        return contents;
    }

    @Override
    public String toString() {
        return "Request{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", headers=" + headers +
                ", contents='" + contents + '\'' +
                '}';
    }
}
