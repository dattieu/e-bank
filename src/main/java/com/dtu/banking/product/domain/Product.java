package com.dtu.banking.product.domain;

import com.dtu.banking.core.domain.Auditable;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Map;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "products")
public class Product extends Auditable<String> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "product_id")
    private String productId;

    @Column(name = "product_version")
    private String productVersion;

    @Column(name = "product_name")
    private String productName;

    @ElementCollection
    @JoinTable(name = "template_params_map", joinColumns = @JoinColumn(name="id"))
    @MapKeyColumn(name = "param_id")
    @Column(name = "template_params")
    private Map<String, String> templateParams;
}
