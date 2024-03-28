package com.example.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendeeService {

    private final AttendeeRepository attendeeRepository;

    @Autowired
    public AttendeeService(AttendeeRepository attendeeRepository) {
        this.attendeeRepository = attendeeRepository;
    }

    public Attendee registerAttendee(Attendee attendee) {
        return attendeeRepository.save(attendee);
    }

    public Attendee getAttendeeById(Long id) {
        return attendeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendee not found with id: " + id));
    }

    public Attendee updateAttendee(Long id, Attendee updatedAttendee) {
        Attendee attendee = getAttendeeById(id);
        attendee.setName(updatedAttendee.getName());
        attendee.setEmail(updatedAttendee.getEmail());
        return attendeeRepository.save(attendee);
    }

    public void deleteAttendee(Long id) {
        Attendee attendee = getAttendeeById(id);
        attendeeRepository.delete(attendee);
    }
}
