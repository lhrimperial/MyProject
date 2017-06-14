package com.handy.frame.web.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author longhairen
 * @create 2017/6/14 0014 下午 3:05
 */
public class Space implements Serializable {

    /**
     * auto generated serialVersionUid.
     */
    private static final long serialVersionUID = 5632812127919571530L;

    /** public space name for people in the space.*/
    private String publicName;
    private String privateName;
    private boolean isActive;
    private Date lastUpdatedTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPublicName() {
        return publicName;
    }

    public void setPublicName(String publicName) {
        this.publicName = publicName;
    }

    public String getPrivateName() {
        return privateName;
    }

    public void setPrivateName(String privateName) {
        this.privateName = privateName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public void setLastUpdatedTime(Date lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    /**
     *  setter & getter
     */

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder("Space:");
        buffer.append("public name:").append(publicName).append(", ");
        buffer.append("private name:").append(privateName).append(", ");
        buffer.append("is actived:").append(isActive).append(", ");
        buffer.append("lastUpdatedTime:").append(lastUpdatedTime.getTime());
        return buffer.toString();
    }
}
