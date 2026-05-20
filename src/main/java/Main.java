import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

import java.util.logging.Logger;

public class Main {
    private static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ProjectConfig.class);

        Comment comment = new Comment();
        comment.setText("Demo comment for testing");
        comment.setAuthor("Nimita");

        CommentService service = context.getBean(CommentService.class);
        String value = service.publishComment(comment);
        logger.info(value);
    }
}
