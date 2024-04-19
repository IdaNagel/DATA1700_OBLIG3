package oblig3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HomeController {

    @Autowired
    private oblig3.BillettRepository rep;

    @PostMapping ("/lagre")
    public void lagreBillett (Billett innbillett){
        rep.lagreBillett(innbillett);
    }

    @GetMapping ("/hentBillett")
    public List<Billett> hentBillett(){
        return rep.hentAlleBilletter();
    }

    @GetMapping ("/slettBilletter")
    public void slettAlle() {
        rep.slettAlleKunder();
    }
}
