package com.tsyrkunou.mongodb.mongotask.model.dto;

import lombok.Data;

import java.time.ZonedDateTime;

import org.springframework.format.annotation.DateTimeFormat;

@Data
public class OverdueParam {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateFrom;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateTo;
}
