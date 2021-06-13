package com.company;

import java.util.ArrayList;
import java.util.UUID;

public class Candidate {
    private UUID identifier;
    private String email;
    private ArrayList<Application> deliveredApplications = new ArrayList<>();

    public Candidate(UUID uuid, String email) {
        this.identifier = uuid;
        this.email = email;
    }

    public void addApplication(Application application) {
        application.setCandidate(this);
        this.deliveredApplications.add(application);
    }
}
