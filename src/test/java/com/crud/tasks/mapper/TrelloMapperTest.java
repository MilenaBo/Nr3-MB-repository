package com.crud.tasks.mapper;
//29.1 zadanie
import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTest {
    @InjectMocks
    private TrelloMapper trelloMapper;

    @Test
    public void mapToBoardsTest() {
        //given  ***   dostarczenie list
        List<TrelloListDto> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloListDto("1", "test_list", false));
        List<TrelloBoardDto> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoardDto("1", "test", trelloLists));
        List<TrelloList> mappedTrelloLists = new ArrayList<>();
        mappedTrelloLists.add(new TrelloList("1", "test_list", false));
        List<TrelloBoard> mappedTrelloBoards = new ArrayList<>();
        mappedTrelloBoards.add(new TrelloBoard("1","test",mappedTrelloLists));
        //when
        List<TrelloBoard> mapToBoards = trelloMapper.mapToBoards(trelloBoards);
        //then
        assertNotNull(mapToBoards);
        assertEquals(1, mapToBoards.size());
        mapToBoards.forEach(trelloBoardDto -> {
            assertEquals("1", trelloBoardDto.getId());
            assertEquals("test", trelloBoardDto.getName());

            trelloBoardDto.getLists().forEach(trelloListDto -> {
                assertEquals("1", trelloListDto.getId());
                assertEquals("test_list", trelloListDto.getName());
                assertEquals(false, trelloListDto.isClosed());
            });
        });
    }
    @Test
    public void mapToBoardsDtoTest() {
        //given  ***   dostarczenie list
        List<TrelloListDto> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloListDto("1", "test_list", false));
        List<TrelloBoardDto> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoardDto("1", "test", trelloLists));
        List<TrelloList> mappedTrelloLists = new ArrayList<>();
        mappedTrelloLists.add(new TrelloList("1", "test_list", false));
        List<TrelloBoard> mappedTrelloBoards = new ArrayList<>();
        mappedTrelloBoards.add(new TrelloBoard("1","test",mappedTrelloLists));
        //when
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(mappedTrelloBoards);
        //then
        assertNotNull(trelloBoardDtos);
        assertEquals(1, trelloBoardDtos.size());
        trelloBoardDtos.forEach(trelloBoardDto -> {
            assertEquals("1", trelloBoardDto.getId());
            assertEquals("test", trelloBoardDto.getName());

            trelloBoardDto.getLists().forEach(trelloListDto -> {
                assertEquals("1", trelloListDto.getId());
                assertEquals("test_list", trelloListDto.getName());
                assertEquals(false, trelloListDto.isClosed());
            });
        });
    }
    @Test
    public void mapToListTest() {
        //given  ***   dostarczenie list
        List<TrelloListDto> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloListDto("1", "test_list", false));
        List<TrelloList> mappedTrelloLists = new ArrayList<>();
        mappedTrelloLists.add(new TrelloList("1", "test_list", false));
        //when
        List<TrelloList>  trelloLists1 = trelloMapper.mapToList(trelloLists);
        //then
        assertNotNull(trelloLists1);
        assertEquals(1, trelloLists1.size());
    }
    @Test
    public void mapToListDtoTest() {
        //given  ***   dostarczenie list
        List<TrelloListDto> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloListDto("1", "test_list", false));
        List<TrelloList> mappedTrelloLists = new ArrayList<>();
        mappedTrelloLists.add(new TrelloList("1", "test_list", false));
        //when
        List<TrelloListDto>  trelloLists1 = trelloMapper.mapToListDto(mappedTrelloLists);
        //then
        assertNotNull(trelloLists1);
        assertEquals(1, trelloLists1.size());
    }
    @Test
    public void mapToCardDtoTest() {
        //given
        TrelloCard trelloCard = new TrelloCard("name card","descriptio","top","1");
        TrelloCardDto trelloCardDto = new TrelloCardDto("name cardDto","descriptio",
                "top","1");
        //when
       TrelloCardDto trelloCardDto1 = trelloMapper.mapToCardDto(trelloCard);
        // then
        assertEquals("name card",trelloCardDto1.getName());
    }
    @Test
    public void mapToCardTest() {
        //given
        TrelloCard trelloCard = new TrelloCard("name card","descriptio","top","1");
        TrelloCardDto trelloCardDto = new TrelloCardDto("name cardDto","descriptio",
                "top","1");
        //when
        TrelloCard trelloCard1 = trelloMapper.mapToCard(trelloCardDto);
        //then
        assertEquals("name cardDto",trelloCard1.getName());
    }
}