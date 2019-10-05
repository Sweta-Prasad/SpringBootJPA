package com.example.SpringBootJpa.topic;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Topic Controller Rest End Points")
public class TopicController {

    @Autowired
    TopicService topicService;


    @ApiOperation("returns all Topics")
    @ApiResponses(
            value = {@ApiResponse(code = 100, message = "100 is the message"),
                    @ApiResponse(code = 200, message = "successful return of all Topics")}
    )
    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @ApiOperation("returns a particular Topic")
    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @ApiOperation("Adds a Topic")
    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    @ApiOperation("Updates a Topic")
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topic.setId(id);
        topicService.updateTopic(id, topic);
    }

    @ApiOperation("Deletes a Topic")
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }
}
