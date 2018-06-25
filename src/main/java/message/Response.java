package main.java.message;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Response implements Serializable{
    private int code;
    private String version;
    private String status;
    private Map headers;
    private String contents;

    public static Response init(){
        Response response = new Response();
        // hard coding
        response.setCode(200).setStatus("OK").setVersion("HTTP/1.1");
        response.setHeaders(response.initHeader()).setContents("<html><header><title>TEst</title></header><body>hello</body></html>");

        return response;
    }

    public Map initHeader(){
        Map<String,String> map = new HashMap();
        map.put("Access-Control-Allow-Origin","*");
        return map;
    }

    public Response setCode(int code) {
        this.code = code;
        return this;
    }

    public Response setVersion(String version) {
        this.version = version;
        return this;
    }

    public Response setStatus(String status) {
        this.status = status;
        return this;
    }

    public Response setHeaders(Map headers) {
        this.headers = headers;
        return this;
    }

    public Response setContents(String contents) {
        this.contents = contents;
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getContents() {
        return contents;
    }

    public String getVersion() {
        return version;
    }

    public String getStatus() {
        return status;
    }

    public Map getHeaders() {
        return headers;
    }

    @Override
    public String toString() {
        return version +" " + code + " " + status +"\n"
                + "Access-Control-Allow-Origin : * \n"
                +"\n"
                + contents;

    }
}
