import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.ProjectConfig;
import model.Comment;
import service.CommentService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // we need to pass comment as parameter for publishing comment
        Comment comment = new Comment();
        comment.setText("Demo comment for test");
        comment.setauthor("Risham");

        CommentService service = context.getBean(CommentService.class);
        service.publishComment(comment);
    }
}
