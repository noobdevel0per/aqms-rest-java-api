package com.aqms.app.rest.Controller;

import com.amazonaws.services.iot.client.AWSIotException;
import com.aqms.app.rest.Models.data;
import com.aqms.app.rest.serviceClass.CreateThingService;
import com.aqms.app.rest.serviceClass.MattPubSubService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MQTTController {

	@Autowired
	MattPubSubService service;

	@Autowired
	CreateThingService createThingService;
	
	@PostMapping("/publish")
	public String publishMessaged(@RequestBody data data) throws AWSIotException, JsonProcessingException {
		service.publishMessage(data);
		return "message Published Successfully";
	}

	@PostMapping("/register/{thingName}")
	public String createThing(@PathVariable String thingName) {
		return createThingService.createThingAutomatically(thingName);
	}
}