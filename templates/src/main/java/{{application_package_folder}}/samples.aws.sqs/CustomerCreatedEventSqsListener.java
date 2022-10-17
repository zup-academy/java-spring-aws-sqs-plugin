package {{application_package}}.samples.aws.sqs;

import {{application_package}}.samples.aws.sqs.model.Customer;
import {{application_package}}.samples.aws.sqs.model.CustomerRepository;
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.util.Map;

@Component
public class CustomerCreatedEventSqsListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerCreatedEventSqsListener.class);

    private final CustomerRepository repository;

    public CustomerCreatedEventSqsListener(CustomerRepository repository) {
        this.repository = repository;
    }

    @SqsListener(
            value = "${samples.aws.sqs.consumer-queue}",
            deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS
    )
    public void receive(CustomerCreatedEvent event, @Header("MessageId") String messageId) {

        LOGGER.info(
            "Receiving a CustomerCreatedEvent (MessageId=\"{}\") from SQS queue: {}",
                messageId, event
        );

        // converts to domain model and invokes your business logic
        Customer customer = event.toModel();
        repository.save(customer);
    }

    @MessageExceptionHandler(ConstraintViolationException.class)
    public void handleOnError(ConstraintViolationException exception,
                              @Payload CustomerCreatedEvent event,
                              @Headers Map<String, String> headers) {
        LOGGER.error(
                "It was not possible to consume the message with messageId={} (ApproximateReceiveCount ={}): {}",
                headers.get("MessageId"),
                headers.get("ApproximateReceiveCount"),
                event,
                exception
        );
    }

}
