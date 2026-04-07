package bit.turing.ant_url.controller;

import bit.turing.ant_url.entity.AntUrl;
import bit.turing.ant_url.service.AntUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AntUrlController {

    @Autowired
    private AntUrlService antUrlService;

    @GetMapping("/shortener/{alias}")
    public ResponseEntity<?> getAntUrl(@PathVariable String alias){
        return ResponseEntity
                .ok()
                .body(antUrlService.findByAlias((alias)));
    }

    @PostMapping("/shortener")
    public ResponseEntity<?> postAntUrl(
            @RequestBody AntUrl antUrl
    ){
        return ResponseEntity
                .ok()
                .body(antUrlService.create(antUrl));
    }
}
