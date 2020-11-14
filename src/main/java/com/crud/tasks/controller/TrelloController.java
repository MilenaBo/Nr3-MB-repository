package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.mapper.CreatedTrelloCard;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
// 22.2 zadanie punkt 3
//  GET REQUEST str27mod22.3
        trelloBoards.stream().filter(trelloBoardDto -> trelloBoardDto.getId() != null &&
                trelloBoardDto.getName() != null &&
                trelloBoardDto.getName().contains("Kodilla"))
                .forEach(trelloBoardDto -> {
                    System.out.println(trelloBoardDto.getName() + " - " + trelloBoardDto.getId());
                    System.out.println("**********  This board contains lists: ");
                    trelloBoardDto.getLists().forEach(trelloList ->
                    System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));
                 });
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoardsTEMPORARY")
    public void getTrelloBoardsTEMPORARY(@RequestParam String boardName) throws TaskNotFoundException {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoardsTEMPORARY();
// 22.2 zadanie punkty 2 i 3
//  GET REQUEST str27mod22.3
//http://localhost:8080/v1/trello/getTrelloBoardsTEMPORARY?boardName=%22Kodilla%
        trelloBoards.stream().filter(trelloBoardDto -> trelloBoardDto.getId() != null &&
                trelloBoardDto.getName() != null &&
                trelloBoardDto.getName().contains(boardName))
                .forEach(trelloBoardDto -> {
                    System.out.println(trelloBoardDto.getName() + " - " + trelloBoardDto.getId());
                    System.out.println("**********  This board contains lists: ");
                    trelloBoardDto.getLists().forEach(trelloList ->
                            System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));
                });
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createNewCard(trelloCardDto);
    }
}