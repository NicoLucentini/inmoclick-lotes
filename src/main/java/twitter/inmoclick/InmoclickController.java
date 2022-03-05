package twitter.inmoclick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twitter.users.DuplicateUserException;
import twitter.users.User;

@RestController
@RequestMapping("/propiedades")
public class InmoclickController {

    @Autowired
    private InmoclickConsumer consumer;

    @GetMapping("/lotes")
    public ResponseEntity listLotes(){
        try {
            var res = consumer.listLotes();
            return  ResponseEntity.status(200).body(res);
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/casas")
    public ResponseEntity listCasas(){
        try {
            var res = consumer.listCasas();
            return  ResponseEntity.status(200).body(res);
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/departamentos")
    public ResponseEntity listDepartamentos(){
        try {
            var res = consumer.listDepartamentos();
            return  ResponseEntity.status(200).body(res);
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
