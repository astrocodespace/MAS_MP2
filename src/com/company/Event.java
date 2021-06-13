package com.company;

import java.util.HashMap;
import java.util.UUID;

public class Event {

    private UUID identifier;

    private boolean current;

    /**
     * Asocjacja kwalifikowana
     */
    private HashMap<UUID, Employer> employers;

    public void addEmployer(Employer employer) {
        employer.addEvent(this);
        this.employers.put(employer.getIdentifier(), employer);
    }

    public Employer findEmployer(UUID employerId) {
        return this.employers.get(employerId);
    }

    public UUID getIdentifier() {
        return this.identifier;
    }

    public boolean isCurrent() {
        return this.current;
    }
}
