package com.desafio.picpay.module.transfer.entity;

import com.desafio.picpay.module.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_transfers")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class TransferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "value", nullable = false)
    private BigDecimal value;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "payer_id")
    private UserEntity user;

    @Column(name = "payee_id", unique = true, nullable = false)
    private Long payeeId;

    @Column(name = "payer_id", nullable = false, unique = true)
    private Long payerId;


}
