package example.sarafan.dto;

import com.fasterxml.jackson.annotation.JsonView;
import example.sarafan.domain.Message;
import example.sarafan.domain.Views;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@Setter
@JsonView(Views.FullMessage.class)
public class MessagePageDto {
    private List<Message> messages;
    private int currentPage;
    private int totalPages;
}
