package {{application_package}}.samples.aws.sqs;

import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CreateNewProductMessageSqsClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreateNewProductMessageSqsClient.class);

    private final String queueName;
    private final QueueMessagingTemplate sqsTemplate;

    public CreateNewProductMessageSqsClient(QueueMessagingTemplate sqsTemplate,
                                            @Value("${samples.aws.sqs.producer-queue}") String queueName) {
        this.sqsTemplate = sqsTemplate;
        this.queueName = queueName;
    }

    /**
     * Send a new product message to SQS queue
     */
    public void send(NewProductMessage message) {

        if (message == null) {
            throw new IllegalArgumentException("message can not be null");
        }

        LOGGER.info("Sending a new product message to SQS queue: {}", message);
        sqsTemplate
            .convertAndSend(queueName, message);
    }

}
