package com.company;

public class EmployerEventProfile {
    private String name;
    private String profilePhoto;

    /**
     * Kompozycja
     */
    private Employer employer;

    private EmployerEventProfile(Employer employer,
                                 String name,
                                 String profilePhoto) {
        this.employer = employer;
        this.name = name;
        this.profilePhoto = profilePhoto;
    }

    public static EmployerEventProfile createProfile(Event event,
                                                     Employer employer,
                                                     String name,
                                                     String profilePhoto) throws Exception {
        EmployerEventProfile eventProfile = new EmployerEventProfile(employer, name, profilePhoto);
        employer.fillProfileForEvent(event, eventProfile);

        return eventProfile;
    }

    public String getName() {
        return this.name;
    }
}
