package com.example.event;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Attendee {

    public Attendee(Long id) {
		super();
		this.id = id;
	}

	public Attendee(String email, Event event) {
		super();
		this.email = email;
		this.event = event;
	}

	public Attendee(String name, String email, Event event) {
		super();
		this.name = name;
		this.email = email;
		this.event = event;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Override
	public String toString() {
		return "Attendee [id=" + id + ", name=" + name + ", email=" + email + ", event=" + event + "]";
	}

	public Attendee(Long id, String name, String email, Event event) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.event = event;
	}

	private String name;
    private String email;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToOne(fetch = FetchType.LAZY)
    private Event event;

    // Constructors, getters, and setters

    public Attendee() {
    }

    public Attendee(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and setters

    // Getters and setters for Event

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}