package org.bluebridge.bytestream.objectstream;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/9/25 17:23
 */
public class Manager extends Employee{
    private static final long serialVersionUID = -668252664793507835L;
    private Employee secretary;

    public Manager(String name, double salary, int year, int month, int dayOfMonth) {
        super(name, salary, year, month, dayOfMonth);
    }

    public void setSecretary(Employee secretary) {
        this.secretary = secretary;
    }

    @Override
    public String toString() {
        return super.toString() + " [secretary=" + secretary + "]";
    }
}
