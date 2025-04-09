package com.desafio.picpay.module.transfer.repository;

import com.desafio.picpay.module.transfer.entity.TransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<TransferEntity, Long> {

}
