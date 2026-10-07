package com.nisanur.cv;

public class Experience {
    private final String company;
    private final String position;
    private final String period;
    private final String description;

    public Experience(String company, String position, String period, String description) {
        this.company = company;
        this.position = position;
        this.period = period;
        this.description = description;
    }

    public String getCompany() { return company; }
    public String getPosition() { return position; }
    public String getPeriod() { return period; }
    public String getDescription() { return description; }
}
