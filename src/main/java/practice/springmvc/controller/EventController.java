package practice.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import practice.springmvc.Event;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("event")
public class EventController {

    @GetMapping("/events/{id}")
    @ResponseBody
    public Event getEvent(@PathVariable Integer id,
                          @MatrixVariable String name) {
        Event event = new Event();
        event.setId(id);
        event.setName(name);

        return event;
    }

    @GetMapping("/events/param")
    @ResponseBody
    public Event param(@RequestParam Integer id,
                       @RequestParam String name) {
        Event event = new Event();
        event.setId(id);
        event.setName(name);

        return event;
    }

    @PostMapping("/ma")
    @ResponseBody
    public Event getEvent2(@Valid @ModelAttribute Event event,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors().forEach(e -> {
                System.out.println("error = " + e.toString());
            });
        }
        return event;
    }

    @GetMapping("/events/form/name")
    public String eventsFormName(Model model) {
        model.addAttribute("event", new Event());
        return "events/form-name";
    }

    @PostMapping("/events/form/name")
    public String eventsFormNameSubmit(@Valid @ModelAttribute Event event,
                                       BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "events/form-name";
        }

        return "redirect:/events/form/limit";
    }

    @GetMapping("/events/form/limit")
    public String eventsFormLimit(@Valid @ModelAttribute Event event,
                                  Model model) {
        model.addAttribute("event", event);

        return "events/form-limit";
    }

    @PostMapping("/events/form/limit")
    public String eventsFormLimitSubmit(@Valid @ModelAttribute Event event,
                                        BindingResult bindingResult,
                                        SessionStatus sessionStatus
                                        ) {
        if (bindingResult.hasErrors()) {
            return "events/form-limit";
        }
        //sessionStatus.setComplete();

        return "redirect:/events/list";
    }

    @GetMapping("/events/list")
    public String getEvents(@ModelAttribute Event event,
                            Model model,
                            @SessionAttribute LocalDateTime visitTime,
                            HttpSession httpSession) {

        LocalDateTime visitTimeToHttpSession = (LocalDateTime) httpSession.getAttribute("visitTime");

        System.out.println(visitTime);
        System.out.println(visitTimeToHttpSession);

        Event event2 = new Event();
        event2.setName("spring");
        event2.setLimit(12345);

        List<Event> eventList = new ArrayList<>();

        eventList.addAll(List.of(event, event2));

        model.addAttribute("eventList", eventList);
        return "events/list";
    }
}
