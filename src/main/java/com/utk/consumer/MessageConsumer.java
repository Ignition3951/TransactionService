package com.utk.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.Gson;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import com.utk.transactionService.entity.TransactionDao;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.utk.entity.TransactionDao;
import com.utk.request.TransactionRequestDto;
import com.utk.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@KafkaListener(topics = "expense_topic", id = "multiGroup")
public class MessageConsumer {

    private static final Logger LOGGER = Logger.getLogger(MessageConsumer.class.getName());

    @Autowired
    public TransactionService transactionService;


    @KafkaHandler
    public void handleTransaction(String transaction) {
        LOGGER.log(Level.INFO, "Received Transaction: {0}", transaction);

        try {
            ObjectMapper mapper = new ObjectMapper();
            TransactionRequestDto transactionDto = mapper.readValue(transaction, TransactionRequestDto.class);
            LOGGER.log(Level.INFO, "Parsed Transaction: json {0}", transactionDto);
            String dateStr = transactionDto.getTransaction_date();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy");
            LocalDate localDate = LocalDate.parse(dateStr, formatter);
            LOGGER.log(Level.INFO, "Parsed Date: date {0}", localDate.toString());
            TransactionDao transactionDao = TransactionDao.builder()
                    .upiId(transactionDto.getUpi_id())
                    .bankName(transactionDto.getBank_name())
                    .transactionDate(localDate)
                    .currency(transactionDto.getCurrency())
                    .transactionAmount(new BigDecimal(transactionDto.getTransaction_amount()))
                    .transactionDetails(transactionDto.getTransaction_details())
                    .createdAt(LocalDateTime.now())
                    .build();
            transactionService.saveTransaction(transactionDao);
            LOGGER.log(Level.INFO, "Transaction saved: {0}", transactionDao);
        }
        catch(Exception e){
            LOGGER.log(Level.SEVERE, "Error parsing transaction: {0}", e.getMessage());
            return;
        }

    }
}
