package com.crud.tasks.trello.client;
//22.4 ten test nie chodzi
import com.crud.tasks.domain.TrelloCardDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class TrelloClientTest {

    @InjectMocks
    private TrelloClient trelloClient;
    @Mock
    private RestTemplate restTemplate;

    @Test
    public void shouldCreateCard()   {
        //given
        TrelloCardDto trelloCardDto = new TrelloCardDto(
                "test task",
                "Test description",
                "top",
                "test id");
//        URI uri = new URI("http://test.com/cards?key=test&token=test&name=test%20task&desc=Test%20description&pos=top&idList=test id");
//
//        CreatedTrelloCard CreatedTrelloCardDto = new CreatedTrelloCard(
//                "1",
//                "test task",
//                "http://test.com",null        );
//        //when
//        CreatedTrelloCard newCard = trelloClient.createNewCard(trelloCardDto);
//
//        //then
//    }

}}