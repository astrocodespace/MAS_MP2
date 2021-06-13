package com.company;

public class Application {
    private Employer employer;
    private Candidate candidate;
    private String applicationFile;

    public Application(Candidate candidate,
                       String applicationFile,
                       Employer employer) {
        this.candidate = candidate;
        this.applicationFile = applicationFile;
        this.employer = employer;
    }

}
