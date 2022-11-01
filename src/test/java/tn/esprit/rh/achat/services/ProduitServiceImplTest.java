//package tn.esprit.rh.achat.services;
//
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import tn.esprit.rh.achat.entities.Produit;
//import tn.esprit.rh.achat.repositories.ProduitRepository;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
//class ProduitServiceImplTest {
//    @Autowired
//    IProduitService produitService;
//
//    @Test
//    @Order(1)
//    void retrieveAllProduits() {
//        List<Produit> produitList=produitService.retrieveAllProduits();
//        Assertions.assertEquals(0,produitList.size());
//    }
//
////    @Test
////    void addProduit() {
////    }
////
////    @Test
////    void deleteProduit() {
////    }
////
////    @Test
////    void updateProduit() {
////    }
////
////    @Test
////    void retrieveProduit() {
////    }
////
////    @Test
////    void assignProduitToStock() {
////    }
//}