package org.bluebridge.thread.thread_designpattern.threadlocal_storage.threadlocal_storage_b;

/**
 * @author ronin
 */
public class Context {
    private String name;
    private String idCard;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
