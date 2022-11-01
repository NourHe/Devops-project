package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProduitServiceImplMock{
//    @Mock
//    ProduitRepository produitRepository;
//    @InjectMocks
//    ProduitServiceImpl produitService;
//    Produit produit= new Produit(1L,"P1","libelleP1",12.5f,new Date(),new Date());
//
//    @Mock
//    StockRepository stockRepository;
//    @InjectMocks
//    StockServiceImpl StI;
//    Stock stock=new Stock("S1",2,2);
//    List<Produit> produitList=new ArrayList<Produit>(){
//        {
//        add(new Produit(2L,"P2","libelleP2",7.2f,new Date(),new Date()));
//        add(new Produit(3L,"P3","libelleP3",18.23f,new Date(),new Date()));
//    }
//    };
//    @Test
//    void retrieveAllProduits() {
//        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
//        Produit produit=produitService.retrieveProduit(2L);
//        Assertions.assertNotNull(produit);
//    }
//    @Test
//    void retrieveProduit() {
//        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
//        Produit produit = produitService.retrieveProduit(2L);
//        Assertions.assertNotNull(produit);
//    }
//    @Test
//    void addProduit() {
//        Produit produit = new Produit(4L,"P4","libelleP4",10f,new Date(),new Date());
//        Mockito.when(produitRepository.save(ArgumentMatchers.any(Produit.class))).thenReturn(produit);
//        Produit created = produitService.addProduit(produit);
//        Assertions.assertSame(created,produit);
//        Mockito.verify(produitRepository).save(produit);
//    }
////    @Test
////    void updateProduit() {
////        Produit produit = new Produit(5L,"P5","libelleP5",18.6f,new Date(),new Date());
////        Mockito.when(produitRepository.save(ArgumentMatchers.any(Produit.class))).thenReturn(produit);
////        Produit updated = produitService.updateProduit(produit);
////        Assertions.assertNotNull(updated);
////        Mockito.verify(produitRepository).save(Mockito.any(Produit.class));
////    }
//    @Test
//    void deleteProduit() {
//
//        Produit produit = new Produit(4L,"P4","libelleP4",10f,new Date(),new Date());
//        Mockito.lenient().when(produitRepository.findById(produit.getIdProduit())).thenReturn(Optional.of(produit));
//        produitService.deleteProduit(produit.getIdProduit());
//        Mockito.verify(produitRepository).deleteById(produit.getIdProduit());
//    }
//    @Test
//    void assignProduitToStock() {
//        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
//        Produit produit = produitService.retrieveProduit(1L);
//        Assertions.assertNotNull(produit);
//
//        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
//        Stock stock1 = StI.retrieveStock(0L);
//        Assertions.assertNotNull(stock1);
//    }
    private Produit produit ;
    @Mock
    ProduitRepository produitRepository=Mockito.mock(ProduitRepository.class);

    @InjectMocks
    ProduitServiceImpl produitService;

    Produit produit1 = new Produit(null, "1111111111", "PRODUIT1", 5, null, null, null, null, null);

    List<Produit> prodlist = new ArrayList<Produit>() {

        {
            add(new Produit(1L, "123456789", "Biscuit", 5, null, null, null, null, null));
            add(new Produit(2L, "55522233", "Javel", 5, null, null, null, null, null));
            add(new Produit(3L, "456897321", "Tv", 5, null, null, null, null, null));
        }};


    @Test
    void addProduitTest()
    {
        System.out.println("***** addProduitTest Mockito *****");
        for (Produit p:prodlist) {
            produitService.addProduit(p);
            Mockito.verify(produitRepository, Mockito.times(1)).save(p);
        }
        System.out.println("***** addProduitTest Mockito: success *****");
    }

    @Test
    void retrieveAllProduitstest() {
        System.out.println("***** retrieveAllProduitstest Mockito *****");
        Mockito.when(produitService.retrieveAllProduits()).thenReturn(prodlist);
        List<Produit> produitList1 = produitService.retrieveAllProduits();
        Assertions.assertEquals(3, produitList1.size());
        System.out.println(" retrieveAllProduitstest Mockito : success");
    }


    @Test
    void TestDeleteProduit(){

        System.out.println("*********TestDeleteProduit Mockito*********");

        produit1.setIdProduit(2L);
        Mockito.lenient().when(produitRepository.findById(produit1.getIdProduit())).thenReturn(Optional.of(produit1));
        produitService.deleteProduit(2L);
        Mockito.verify(produitRepository).deleteById(produit1.getIdProduit());

        System.out.println("*******TestDeleteProduit Mockito : success*********");

    }
}
