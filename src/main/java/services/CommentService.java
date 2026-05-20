package services;

import model.Comment;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CommentService {
    private Logger logger = Logger.getLogger(CommentService.class.getName());
    public String publishComment(Comment comment ){
        logger.info("Publising comment : "+comment.getText());
        return "SUCCESS";
    }
}
