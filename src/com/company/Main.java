package com.company;

import java.util.Date;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        Event event = new Event(UUID.randomUUID(), "Absolvent Talent Days Online - summer 2021", true);

        // Creating employer profile
        Employer employer = new Employer(UUID.randomUUID());

        // Assigning employer to event
        event.addEmployer(employer);

        EmployerEventProfile profile = null;
        try {
            profile = EmployerEventProfile.createProfile(event, employer, "BGK - Bank Gospodarstwa Krajowego", "https://bgk.image.url/image.png");
            employer.fillProfileForEvent(event, profile);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        bobka jest super

        Workshop workshop = new Workshop("How to boost your mind in 1 day.", new Date(), new Date());
        workshop.assignEmployer(employer);

        // Candidate creation
        Candidate candidate = new Candidate(UUID.randomUUID(), "john@kowalski.pl");

        Application application = new Application("https://aplication.file.url/file.pdf");
        candidate.addApplication(application);
        employer.addApplication(application);

        try {
            // Composition usage
            System.out.println(event.findEmployer(employer.getIdentifier()).showName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(application);
    }
}
