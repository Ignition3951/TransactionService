package com.utk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
@ToString
@Table(name = "transactions")
public class TransactionDao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String upiId;

    private String bankName;

    private LocalDate transactionDate;

    private String currency;

    private BigDecimal transactionAmount;

    private String transactionDetails;

    private LocalDateTime createdAt;
}
