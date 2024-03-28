package com.example.event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/attendees")
public class AttendeeController {

    private final AttendeeService attendeeService;

    @Autowired
    public AttendeeController(AttendeeService attendeeService) {
        this.attendeeService = attendeeService;
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<Attendee> getAttendeeById(@PathVariable Long id) {
        Attendee attendee = attendeeService.getAttendeeById(id);
        if (attendee.getId()==null) {
        	return null;
        }
        return ResponseEntity.ok(attendee);
    }

//    @PostMapping
//    public ResponseEntity<Attendee> registerAttendee(@RequestBody Attendee attendee) {
//        Attendee registeredAttendee = attendeeService.registerAttendee(attendee);
//        return ResponseEntity.status(HttpStatus.CREATED).body(registeredAttendee);
//    }

    

    @PostMapping
    public ResponseEntity<Attendee> registerAttendee(@RequestBody Attendee attendee) {
        // Validate attendee details
        if (attendee.getName() == null || attendee.getName().isEmpty() ||
                attendee.getEmail() == null || attendee.getEmail().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Register the attendee using the service layer
        Attendee registeredAttendee = attendeeService.registerAttendee(attendee);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredAttendee);
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Attendee> updateAttendee(@PathVariable Long id, @RequestBody Attendee updatedAttendee) {
//        Attendee attendee = attendeeService.updateAttendee(id, updatedAttendee);
//        return ResponseEntity.ok(attendee);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteAttendee(@PathVariable Long id) {
//        attendeeService.deleteAttendee(id);
//        return ResponseEntity.noContent().build();
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Attendee> updateAttendee(@PathVariable Long id, @RequestBody Attendee updatedAttendee) {
        // Check if the attendee with the given id exists
        Optional<Attendee> existingAttendeeOptional = Optional.ofNullable(attendeeService.getAttendeeById(id));
        if (existingAttendeeOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Attendee existingAttendee = existingAttendeeOptional.get();

        // Update attendee details
        existingAttendee.setName(updatedAttendee.getName());
        existingAttendee.setEmail(updatedAttendee.getEmail());

        // Save the updated attendee using the service layer
        Attendee updatedAttendeeResult = attendeeService.updateAttendee(id, existingAttendee);
        return ResponseEntity.ok(updatedAttendeeResult);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttendee(@PathVariable Long id) {
        // Check if the attendee with the given id exists
        Optional<Attendee> existingAttendeeOptional = Optional.ofNullable(attendeeService.getAttendeeById(id));
        if (existingAttendeeOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Delete the attendee using the service layer
        attendeeService.deleteAttendee(id);
        return ResponseEntity.noContent().build();
    }
}
