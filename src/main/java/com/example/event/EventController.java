package com.example.event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        return ResponseEntity.ok(events);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Event event = eventService.getEventById(id);
        return ResponseEntity.ok(event);
    }

//    @PostMapping
//    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
//        Event createdEvent = eventService.createEvent(event);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
//    }

    
    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        // Validate event details
        if (event.getName() == null || event.getName().isEmpty() ||
                event.getLocation() == null || event.getLocation().isEmpty() ||
                event.getDate() == null || event.getDate().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Save the event using the service layer
        Event createdEvent = eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEvent);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
        Event event = eventService.updateEvent(id, updatedEvent);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
