package com.capstone.metro.dto;

import com.capstone.metro.domain.Metro;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor
@Builder(access = PRIVATE)
public class MetroResponseDTO {

    private String metroInfo;
    private String metroTopic;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy.MM.dd HH:mm",
            locale = "Asia/Seoul"
    )
    private LocalDateTime startDate;

    public static MetroResponseDTO from(Metro metro) {
        return MetroResponseDTO.builder()
                .metroInfo(metro.getText())
                .metroTopic(metro.getMetroTopic())
                .startDate(metro.getStartDate())
                .build();
    }
}
