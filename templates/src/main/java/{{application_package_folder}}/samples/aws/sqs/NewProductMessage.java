package {{application_package}}.samples.aws.sqs;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class NewProductMessage {

    private UUID id;
    private String name;
    private BigDecimal price;
    private LocalDateTime createdAt;

    public NewProductMessage(String name, BigDecimal price, LocalDateTime createdAt) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "NewProductMessage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                '}';
    }
}
