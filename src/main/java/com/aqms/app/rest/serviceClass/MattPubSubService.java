package com.aqms.app.rest.serviceClass;

import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.aqms.app.rest.Config.MQTTConfig;
import com.aqms.app.rest.Models.data;
import com.aqms.app.rest.dto.MyMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MattPubSubService {

    @Autowired
    MQTTConfig mqttConfig;
    public void publishMessage(data payload) throws AWSIotException, JsonProcessingException {
        //mqttConfig.ConnectToIot();
        mqttConfig.publish(payload);
    }
}
