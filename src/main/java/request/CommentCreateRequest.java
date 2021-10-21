package request;

import com.example.quesapptwo.entities.Post;
import com.example.quesapptwo.entities.User;
import lombok.Data;


@Data
public class CommentCreateRequest {

    Long id;
    Long postId;
    Long userId;
    String text;
}
