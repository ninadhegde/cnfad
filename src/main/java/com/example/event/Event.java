package com.example.event;
//import javax.persistence.*;


import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String date;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Attendee> attendees = new HashSet<>();

    // Constructors, getters, and setters

    public Event() {
    }

    @Override
	public String toString() {
		return "Event [id=" + id + ", name=" + name + ", location=" + location + ", date=" + date + ", attendees="
				+ attendees + "]";
	}

	public Event(String name, String location, String date, Set<Attendee> attendees) {
		super();
		this.name = name;
		this.location = location;
		this.date = date;
		this.attendees = attendees;
	}

	public Event(String name, String location, String date) {
        this.name = name;
        this.location = location;
        this.date = date;
    }

    // Getters and setters

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Set<Attendee> getAttendees() {
		return attendees;
	}

	public void setAttendees(Set<Attendee> attendees) {
		this.attendees = attendees;
	}

	// Add attendee to event
    public void addAttendee(Attendee attendee) {
        attendees.add(attendee);
        attendee.setEvent(this);
    }

    // Remove attendee from event
    public void removeAttendee(Attendee attendee) {
        attendees.remove(attendee);
        attendee.setEvent(null);
    }

    // Getters and setters
}
