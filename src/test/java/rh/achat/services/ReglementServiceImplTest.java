package rh.achat.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;

import tn.esprit.rh.achat.AchatApplication;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.services.IReglementService;


@SpringBootTest(classes=AchatApplication.class)
//@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ReglementServiceImplTest {
	@Autowired
    IReglementService Rs;

  @Test
    @Order(1)
    void retrieveAllReglement() {
        List<Reglement> listReglement = Rs.retrieveAllReglements();
        
        assertNotNull(listReglement);
    }

    @Test
    @Order(2)
    void addReglement() {
    	Reglement r1 = new Reglement();
        r1.setMontantPaye(9999);
        r1.setMontantRestant(1111);
        r1.setDateReglement(new Date());
        r1.setPayee(Boolean.FALSE);
        Reglement savedReglement= Rs.addReglement(r1);
        assertEquals(r1.getMontantPaye(), savedReglement.getMontantPaye());
    }

  @Test
    @Order(3)
    void retrievieReglemnt() {
	  assertNotNull(Rs.retrieveReglement(3L));
}
@Test
@Order(4)
void DeleteReglement() {
	Rs.deleteReglement(1L);
	Assertions.assertNull(Rs.retrieveReglement(1L));
	} 


}
