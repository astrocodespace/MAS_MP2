package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Employer {

    private UUID identifier;

    private ArrayList<Event> events;

    /**
     * Kompozycja
     */
    private HashMap<Event, EmployerEventProfile> employerEditionsData;

    /**
     * Asocjacja z atrybutem
     */
    private ArrayList<Application> applications;

    /**
     * Asocjacja zwykła - jeden do wielu
     */
    private ArrayList<Workshop> workshops;

    public void apply(Candidate candidate, String applicationFile) {
        Application application = new Application(candidate, applicationFile, this);
        candidate.addApplication(application);
        this.applications.add(
                application
        );
    }

    public void addWorkshop(Workshop workshop) {
        workshop.assignEmployer(this);
    }

    public void addEvent(Event event) {
        this.events.add(event);
    }

    public void fillProfileForEvent(Event event, EmployerEventProfile profileData) {
        this.employerEditionsData.put(event, profileData);
    }

    public UUID getIdentifier() {
        return this.identifier;
    }

    public String showName() {
        List<Map.Entry<Event, EmployerEventProfile>> employerEventDataList = this.employerEditionsData
                .entrySet()
                .stream()
                .filter(map -> map.getKey().isCurrent())
                .collect(Collectors.toList());

        return (employerEventDataList.get(0).getValue().getName());
    }
}
