package tn.esprit.rh.achat.services;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.rh.achat.entities.Operateur;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class OperateurServiceImplTest {
	
	
	@Autowired
    IOperateurService Ot;

    @Test
    @Order(1)
    void retrieveAllOperateurs() {
        List<Operateur> listUsers = Ot.retrieveAllOperateurs();
        //assertEquals(0, listUsers.size());
        assertNotNull(listUsers);
    }

    @Test
    void addOperateur() {
        Operateur r1 = new Operateur();
        r1.setNom("Operateur1");
        r1.setPassword("secret123");
        r1.setPrenom("Telecm");
        Operateur savedOperateur1= Ot.addOperateur(r1);
        assertEquals(r1.getNom(), savedOperateur1.getNom());
    }

    @Test
    void retrieveOperateur() {
        assertNotNull(Ot.retrieveOperateur(1L));
    }

   

}
