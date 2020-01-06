package com.igoredm.arangodbbasicservice.model.entity;

import com.arangodb.springframework.annotation.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@Document("log")
@NoArgsConstructor
@AllArgsConstructor
public class LogEntity extends BaseEntity {

    private String serviceName;
    private LocalDateTime dataInclusao;
    private List<String> descricao;
}
