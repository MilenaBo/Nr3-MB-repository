package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloBadges;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.mapper.CreatedTrelloCard;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
@CrossOrigin("*")
public class TrelloController {

    @Autowired
    private TrelloClient trelloClient;

    //mod 22.4 s 42
    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards()   {
        return trelloClient.getTrelloBoards();
    }

// METODA PONIZEJ dziala poprawnie, jest zamieniona zgodnie z 22.4  str 42 na metodę POWYZEJ
//    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
//    public void getTrelloBoards() {
//
//        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();
//// 22.2 zadanie punkt 3
////  GET REQUEST str27mod22.3
//        trelloBoards.stream().filter(trelloBoardDto -> trelloBoardDto.getId() != null &&
//                trelloBoardDto.getName() != null &&
//                trelloBoardDto.getName().contains("Kodilla"))
//                .forEach(trelloBoardDto -> {
//                    System.out.println(trelloBoardDto.getName() + " - " + trelloBoardDto.getId());
//                    System.out.println("**********  This board contains lists: ");
//                    trelloBoardDto.getLists().forEach(trelloList ->
//                    System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));
//                 });
//    }

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoardsTEMPORARY")
    public void getTrelloBoardsTEMPORARY(@RequestParam String boardName) throws TaskNotFoundException {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoardsTEMPORARY();
// 22.2 zadanie punkty 2 i 3
//  GET REQUEST str27mod22.3
//http://localhost:8080/v1/trello/getTrelloBoardsTEMPORARY?boardName="Kodilla"

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
//22.3
    @RequestMapping(method = RequestMethod.POST, value = "createdTrelloBadges")
    public CreatedTrelloBadges createdTrelloBadges(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloClient.createNewBadges(trelloCardDto);
    }
}