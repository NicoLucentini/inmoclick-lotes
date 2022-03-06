package twitter.inmoclick;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/propiedades")
public class InmoclickController {

    @Autowired
    private InmoclickConsumer consumer;

    @GetMapping("/lotes")
    public ResponseEntity listLotes(){
        try {
            //var res = consumer.listLotes();
            var res = consumer.lotes;
            return  ResponseEntity.status(200).body(res);
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Autowired
    LotesLoader lotesLoader;

    @GetMapping("/load")
    public ResponseEntity listLotesLoad(){
        try {


            lotesLoader.run();

            return  ResponseEntity.ok("Ok");
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/casas")
    public ResponseEntity listCasas(){
        try {
            //var res = consumer.listCasas();
            var res = consumer.casas;
            return  ResponseEntity.status(200).body(res);
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/departamentos")
    public ResponseEntity listDepartamentos(){
        try {
            //var res = consumer.listDepartamentos();
            var res = consumer.departamentos;
            return  ResponseEntity.status(200).body(res);
        }
        catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
