package io.huongnq.springboot.Topic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/topics")
@CrossOrigin(origins="*", maxAge = 3600)
public class  TopicController {

    @Autowired
    private  TopicService topicService;

    @PostMapping(value = "/create")
    public HashMap<String, Object> createUser(@RequestBody Topic topic) {
        log.info("Creating Topic {}", topic.getName());

        if (topic.getName().isEmpty()) {
            return ResponseUtils.buildResponse(ErrorMessage.OBJECT_CREATE_EMPTY_FIELD);
        }

        Optional<Topic> existedTopic = topicService.findById(topic.getId());

        if (existedTopic != null) {
            return ResponseUtils.buildResponse(ErrorMessage.USER_CREATE_EXISTING);
        }

        topicService.addTopic(topic);

        return ResponseUtils.buildResponse(ErrorMessage.SUCCESSFUL);
    }
    //https://www.geeksforgeeks.org/passing-and-returning-objects-in-java/

    @GetMapping(value = "/list")
    public HashMap<String, Object> getAllTopic(Model model, Pageable pageable) {
        log.info("Getting user list");

        Page<Topic> pages = topicService.listAllTopic(pageable);

        model.addAttribute("number", pages.getNumber());
        model.addAttribute("totalPages", pages.getTotalPages());
        model.addAttribute("totalElements", pages.getTotalElements());
        model.addAttribute("size", pages.getSize());
        model.addAttribute("topics", pages.getContent());

        return ResponseUtils.buildResponse(ErrorMessage.SUCCESSFUL, model);
    }
}
