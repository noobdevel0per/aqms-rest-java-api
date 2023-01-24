package com.aqms.app.rest.Config;

import com.amazonaws.services.iot.client.AWSIotDevice;
import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.aqms.app.rest.Models.data;
import com.aqms.app.rest.dto.MyMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MQTTConfig {

    String clientEndpoint = "a295darxjf5v6c-ats.iot.us-east-1.amazonaws.com";   // use value returned by describe-endpoint --endpoint-type "iot:Data-ATS"
    String clientId = "sensor";                              // replace with your own client ID. Use unique client IDs for concurrent connections.
    String awsAccessKeyId = "AKIA3ONMXQDRLZ3JTPWR";
    String awsSecretAccessKey = "IO70hpji7R4oEXqeAJAI69rlklEDaKn4DvLRtjmE";

    String sessionToken = null;
    AWSIotMqttClient client = null;

    public void ConnectToIot() throws AWSIotException {
        // AWS IAM credentials could be retrieved from AWS Cognito, STS, or other secure sources
        client = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, sessionToken);
        client.connect();
        System.out.println("Connected to IOT");
    }

    public void publish(data payload) throws AWSIotException, JsonProcessingException {
        String topic = "$aws/things/sensor/shadow/update";
        AWSIotQos qos = AWSIotQos.QOS0;
        long timeout = 3000;                    // milliseconds
        ObjectMapper mapper = new ObjectMapper();
        AWSIotDevice device = new AWSIotDevice(clientId);
        String state = "{\"state\":{\"reported\":{\"sensor\":3.0}}}";
        client = new AWSIotMqttClient(clientEndpoint, clientId, awsAccessKeyId, awsSecretAccessKey, sessionToken);

        client.attach(device);
        client.connect();
        MyMessage message = new MyMessage(topic, qos, state);
        client.publish(message, timeout);
    }


}