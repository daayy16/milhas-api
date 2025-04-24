package com.milhas.api.models;

import com.milhas.api.dtos.PromotionRecordDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity()
@Table(name = "TB_Promotion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromotionModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String destination;

    @Column(nullable = true)
    private String image;

    @Column(nullable = false)
    private float price;

    public PromotionModel(PromotionRecordDTO data) {
        this.destination = data.destination();
        this.image = data.image();
        this.price = data.price();
    }
}
