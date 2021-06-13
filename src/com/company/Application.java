package com.company;

public class Application {
    private Employer employer;
    private Candidate candidate;
    private String applicationFile;

    public Application(String applicationFile) {
        this.applicationFile = applicationFile;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    @Override
    public String toString() {
        return "Application{" +
                "employer=" + employer +
                ", candidate=" + candidate +
                ", applicationFile='" + applicationFile + '\'' +
                '}';
    }
}
