package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Employer {

    private UUID identifier;

    private List<Event> events = new ArrayList<>();

    /**
     * Kompozycja
     */
    private HashMap<Event, EmployerEventProfile> employerEditionsData = new HashMap<>();

    /**
     * Asocjacja z atrybutem
     */
    private List<Application> applications = new ArrayList<>();

    /**
     * Asocjacja zwykła - jeden do wielu
     */
    private ArrayList<Workshop> workshops;

    public Employer(UUID identifier) {
        this.identifier = identifier;
    }

    public void addApplication(Application application) {
        application.setEmployer(this);
        this.applications.add(application);
    }

    public void addWorkshop(Workshop workshop) {
        workshop.assignEmployer(this);
        this.workshops.add(workshop);
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

    public void fillProfileForEvent(Event event, EmployerEventProfile profileData) throws Exception {
        boolean isEmployerAssignedToEvent = false;
        for (Event singleEvent: events) {
            if (singleEvent.getIdentifier().equals(event.getIdentifier())) {
                System.out.println(singleEvent.getIdentifier().toString());
                isEmployerAssignedToEvent = true;
            }
        }

        if (!isEmployerAssignedToEvent) {
            throw new Exception("EMPLOYER IS NOT ASSIGNED TO THIS EVENT");
        }

        this.employerEditionsData.put(event, profileData);
    }

    public UUID getIdentifier() {
        return this.identifier;
    }

    public String showName() throws Exception {
        List<Map.Entry<Event, EmployerEventProfile>> employerEventDataList = this.employerEditionsData
                .entrySet()
                .stream()
                .filter(map -> map.getKey().isCurrent())
                .collect(Collectors.toList());

        if (employerEventDataList.isEmpty()) {
            throw new Exception("Employer profile not filled");
        }

        return (employerEventDataList.get(0).getValue().getName());
    }
}
