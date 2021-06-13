package com.company;

import java.util.Date;

public class Workshop {
    private Employer employer;
    private String title;
    private Date startDate;
    private Date endDate;

    public Workshop(String title, Date startDate, Date endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void assignEmployer(Employer employer) {
        this.employer = employer;
    }
}
