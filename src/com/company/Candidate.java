package com.company;

import java.util.ArrayList;

public class Candidate {
    private ArrayList<Application> deliveredApplications;

    public Candidate() {

    }

    public void addApplication(Application application) {
        this.deliveredApplications.add(application);
    }
}
