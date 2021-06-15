package practice.springmvc.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.springmvc.Event;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventApi {

    @PostMapping
    public Event createEvent(@Valid @RequestBody Event event,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(System.out::println);
        }

        return event;
    }

    @PostMapping("/httpEntity")
    public Event createEventToHttpEntity(HttpEntity<Event> request) {
        MediaType contentType = request.getHeaders().getContentType();
        System.out.println("contentType = " + contentType);

        return request.getBody();
    }
}
