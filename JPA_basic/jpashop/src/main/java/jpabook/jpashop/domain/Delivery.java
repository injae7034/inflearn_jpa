package jpabook.jpashop.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import static javax.persistence.FetchType.*;

@Entity
public class Delivery extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    Address address;

    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

}
