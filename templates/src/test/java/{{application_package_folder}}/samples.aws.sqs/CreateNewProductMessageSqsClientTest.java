package {{application_package}}.samples.aws.sqs;

import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.model.GetQueueAttributesResult;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test")
class CreateNewProductMessageSqsClientTest {

    @Autowired
    private CreateNewProductMessageSqsClient createNewProductMessageSqsClient;

    @Autowired
    private QueueMessagingTemplate sqsTemplate;
    @Autowired
    private AmazonSQSAsync SQS;

    @Value("${samples.aws.sqs.producer-queue}")
    private String producerQueueName;

    @BeforeEach
    public void setUp() {
        SQS.createQueue(producerQueueName);
    }

    @AfterEach
    public void cleanUp() {
        SQS.deleteQueue(producerQueueName);
    }

    @Test
    @DisplayName("should send a new product message to a SQS queue")
    public void t1() {

        // scenario
        NewProductMessage message = new NewProductMessage(
                "Kindle",
                new BigDecimal("499.99"),
                LocalDateTime.now()
        );

        // action
        createNewProductMessageSqsClient.send(message);

        // validation
        NewProductMessage messageFromQueue = sqsTemplate
                .receiveAndConvert(producerQueueName, NewProductMessage.class);

        assertThat(messageFromQueue)
                .usingRecursiveComparison()
                .isEqualTo(message)
        ;
    }

    @Test
    @DisplayName("should not send a new product message to a SQS queue when message is null")
    public void t2() {

        // action
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            createNewProductMessageSqsClient.send(null);
        });
        
        // validation
        assertThat(exception)
                .hasMessage("message can not be null");

        // ...and verify side-effects
        assertThat(numberOfMessagesInQueue()).isEqualTo(0);
    }

    private Integer numberOfMessagesInQueue() {
        GetQueueAttributesResult attributes = SQS
                .getQueueAttributes(producerQueueName, of("All"));

        return Integer.parseInt(
                attributes.getAttributes().get("ApproximateNumberOfMessages")
        );
    }

}