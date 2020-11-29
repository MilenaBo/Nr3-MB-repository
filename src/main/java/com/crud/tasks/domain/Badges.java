package com.crud.tasks.domain;
//22.3 zadanie Badges
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Badges {

    @JsonProperty("votes")
    private int votes;
 //zakomentowano na spotkaniu 29.11.20
//    @JsonProperty("attachments")
//    private AttachmentsByType attachments;
}
