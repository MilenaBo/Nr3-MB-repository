package com.crud.tasks.trello.client;

import com.crud.tasks.config.TrelloConfig;
import com.crud.tasks.domain.CreatedTrelloBadges;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.mapper.CreatedTrelloCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;

@Component
public class TrelloClient {
private static final Logger LOGGER = LoggerFactory.getLogger(TrelloClient.class);

// 22.4s45 opakujemy te pola w klasę TrelloConfig >>>> na razie nie robię22.4
    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;
    @Value("${trello.app.key}")
    private String trelloAppKey;
    @Value("${trello.app.token}")
    private String trelloToken;
    @Value("${trello.app.username}")
    private String trelloUserName;

//    @Autowired na razie nie robię22.4
//    private TrelloConfig trelloConfig;

    @Autowired
    private RestTemplate restTemplate;

    private URI adresURL(String trelloEndpoint,String trelloKey,String trello_Token, String trelloUser)    {
        URI theUrl = UriComponentsBuilder.fromHttpUrl(trelloEndpoint + "/members/"+trelloUser+"/boards")
                .queryParam("key", trelloKey)
                .queryParam("token", trello_Token)
                .queryParam("fields", "name,id")
                .queryParam("lists", "all").build().encode().toUri();
        return theUrl;
    }

    public List<TrelloBoardDto> getTrelloBoards() {
    LOGGER.info("*********** Starting my getTrelloBoards/TrelloClient 22.2,22.4 s 41");
        URI url = adresURL(trelloApiEndpoint,trelloAppKey,trelloToken,trelloUserName);
        try {
            TrelloBoardDto[] boardsResponse = restTemplate.getForObject(url, TrelloBoardDto[].class);
            return Arrays.asList(ofNullable(boardsResponse).orElse(new TrelloBoardDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    // w TrelloController  "getTrelloBoardsTEMPORARY"
    public List<TrelloBoardDto> getTrelloBoardsTEMPORARY() {
        LOGGER.info("*********** Starting my getTrelloBoardsTEMPORARY/TrelloClient 22.2 punkt 2 budowanie URL");
        URI url = adresURL(trelloApiEndpoint,trelloAppKey,trelloToken,trelloUserName);

        try {
            TrelloBoardDto[] boardsResponse = restTemplate.getForObject(url, TrelloBoardDto[].class);
            return Arrays.asList(ofNullable(boardsResponse).orElse(new TrelloBoardDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }

    public CreatedTrelloCard createNewCard(TrelloCardDto trelloCardDto) {
        LOGGER.info("*********** Starting my createNewCar/TrelloClient 22.");
        URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/cards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("name", trelloCardDto.getName())
                .queryParam("desc", trelloCardDto.getDescription())
                .queryParam("pos", trelloCardDto.getPos())
                .queryParam("idList", trelloCardDto.getListId()).build().encode().toUri();

        return restTemplate.postForObject(url, null, CreatedTrelloCard.class);
    }
//22.3
    public CreatedTrelloBadges createNewBadges(TrelloCardDto trelloCardDto) {
        LOGGER.info("*********** Starting my createNewCar/TrelloClient 22.");
        URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/cards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("name", trelloCardDto.getName())
                .queryParam("desc", trelloCardDto.getDescription())
                .queryParam("pos", trelloCardDto.getPos())
                .queryParam("idList", trelloCardDto.getListId()).build().encode().toUri();
               // .queryParam("card",trelloCardDto.getCard()
                   //     .queryParam()
                     //   .build().encode().toUri();

        return restTemplate.postForObject(url, null, CreatedTrelloBadges.class);
    }
}
