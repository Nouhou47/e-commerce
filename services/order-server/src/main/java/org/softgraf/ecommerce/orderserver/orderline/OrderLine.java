package org.softgraf.ecommerce.orderserver.orderline;

import jakarta.persistence.*;
import lombok.*;
import org.softgraf.ecommerce.orderserver.order.Order;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@Entity(name = "customer_order")
public class OrderLine {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private Integer productId;
    private double quantity;
}
