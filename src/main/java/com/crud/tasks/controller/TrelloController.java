package com.crud.tasks.controller;
//22chyba
//23.4 s52 wstrzykuję TrelloService, która ma wstrzyknięty Trello Client
//29.s9 zmiany wstrzyknięta TrelloFacade

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/trello")
public class TrelloController {

    @Autowired
    private TrelloFacade trelloFacade;

    @RequestMapping(method = RequestMethod.GET, value = "/getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {
        return trelloFacade.fetchTrelloBoards();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createTrelloCard")
    public CreatedTrelloCardDto createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
        return trelloFacade.createCard(trelloCardDto);
    }
}

//powyżej 29s9
// poniżej zmiany dokonywane w poszczególnych modułach
//    @Autowired zmana w 23.4
//    private TrelloClient trelloClient;

//    @Autowired   zmiana 29.1s9
//    private TrelloService trelloService;
    //mod 23.4 s 52; zmiana 29s9
//@RequestMapping(method = RequestMethod.GET, value = "/getTrelloBoards")
//public List<TrelloBoardDto> getTrelloBoards() {
//    return trelloService.fetchTrelloBoards();}

//    //mod 22.4 s 42
//    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
//    public List<TrelloBoardDto> getTrelloBoards()   {
//        return trelloClient.getTrelloBoards();
//    }

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

 ////////////////////////////////////// to poniżej zablokowałam w 23.4
//    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoardsTEMPORARY")
//    public void getTrelloBoardsTEMPORARY(@RequestParam String boardName) throws TaskNotFoundException {
//
//        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoardsTEMPORARY();
//
//// 22.2 zadanie punkty 2 i 3
////  GET REQUEST str27mod22.3
////http://localhost:8080/v1/trello/getTrelloBoardsTEMPORARY?boardName="Kodilla"
//
//        trelloBoards.stream().filter(trelloBoardDto -> trelloBoardDto.getId() != null &&
//                trelloBoardDto.getName() != null &&
//                trelloBoardDto.getName().contains(boardName))
//                .forEach(trelloBoardDto -> {
//                    System.out.println(trelloBoardDto.getName() + " - " + trelloBoardDto.getId());
//                    System.out.println("**********  This board contains lists: ");
//                    trelloBoardDto.getLists().forEach(trelloList ->
//                            System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));
//                });
//    }
///////////////////////////////////////////////////////////////
//poniżej zmiana 29s9
//    @RequestMapping(method = RequestMethod.POST, value = "/createTrelloCard")
//    public CreatedTrelloCardDto createdTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
//        return trelloService.createdTrelloCard(trelloCardDto);
//    }
//22.3, zablokowałam w 23.4
//    @RequestMapping(method = RequestMethod.POST, value = "createdTrelloBadges")
//    public CreatedTrelloBadges createdTrelloBadges(@RequestBody TrelloCardDto trelloCardDto) {
//        return trelloClient.createNewBadges(trelloCardDto);
//    }
