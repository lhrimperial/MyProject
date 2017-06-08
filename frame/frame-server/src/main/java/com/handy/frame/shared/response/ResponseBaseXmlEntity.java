package com.handy.frame.shared.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/4 0004.
 */

@XmlRootElement(name="xml")
public class ResponseBaseXmlEntity implements Serializable {
    private static final long serialVersionUID = -5545811904878562659L;

    private String code;
    private String message;

    @XmlElement(name="code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlElement(name="message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
