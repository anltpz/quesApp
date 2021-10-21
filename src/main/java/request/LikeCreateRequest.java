package request;

import com.example.quesapptwo.entities.Post;
import com.example.quesapptwo.entities.User;
import lombok.Data;
import javax.persistence.Id;


@Data
public class LikeCreateRequest {

    Long id;
    Long postId;
    Long userId;
}
