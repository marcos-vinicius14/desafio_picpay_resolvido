package com.desafio.picpay.module.user.entity;

import com.desafio.picpay.module.transfer.entity.TransferEntity;
import com.desafio.picpay.module.user.model.valueObjects.UserType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "user_name", nullable = false)
    String userName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_type")
    @Enumerated(EnumType.STRING)
    private UserType type;

    @Column(name = "document_number", nullable = false, unique = true)
    private  String documentNumber;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @OneToMany(mappedBy = "payers")
    private List<TransferEntity> transfersSended;

    @OneToMany(mappedBy = "payee")
    private List<TransferEntity> transfersReceived;

}
