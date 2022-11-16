package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieProduit;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class CategorieServiceImpTest {

    @Autowired
    ICategorieProduitService St;

    @Test
    @Order(1)
    void retrieveAllCategorie() {
        List<CategorieProduit> listUsers = St.retrieveAllCategorieProduits();
        //assertEquals(0, listUsers.size());
        assertNotNull(listUsers);
    }

    @Test
    void addCategorie() {
        CategorieProduit s1 = new CategorieProduit();
        s1.setLibelleCategorie("stock test");
        s1.setCodeCategorie("5");
        CategorieProduit savedCategorie= St.addCategorieProduit(s1);
        assertEquals(s1.getLibelleCategorie(), savedCategorie.getLibelleCategorie());
    }


    @Test
    void retrieveCategorie() {
        assertNotNull(St.retrieveCategorieProduit(1L));
    }



}