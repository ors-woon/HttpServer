package main.java.message;


import java.io.Serializable;
import java.util.Map;

public class Response implements Serializable{
    private int code;
    private Map headers;
    private String contents;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    @Override
    public String toString() {
        return code+"\n"+
                "contentsize : 100"+
                "\n\n" + contents;
    }
}
