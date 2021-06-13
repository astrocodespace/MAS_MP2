package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Event {

    private UUID identifier;

    private String name;

    private boolean current;

    /**
     * Asocjacja kwalifikowana
     */
    private Map<UUID, Employer> employers = new HashMap<>();

    public Event(UUID id, String name, boolean isCurrent) {
        this.identifier = id;
        this.name = name;
        this.current = isCurrent;
    }

    public void addEmployer(Employer employer) {
        employer.addEvent(this);
        this.employers.put(employer.getIdentifier(), employer);
    }

    public Employer findEmployer(UUID employerId) throws Exception {
        if (!this.employers.containsKey(employerId)) {
            throw new Exception("Employer with given id does not exists in this event");
        }
        return this.employers.get(employerId);
    }

    public UUID getIdentifier() {
        return this.identifier;
    }

    public boolean isCurrent() {
        return this.current;
    }
}
