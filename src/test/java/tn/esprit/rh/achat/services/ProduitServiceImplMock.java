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
    @Mock
    ProduitRepository produitRepository;
    @InjectMocks
    ProduitServiceImpl produitService;
    Produit produit= new Produit(1L,"P1","libelleP1",12.5f,new Date(),new Date());

    @Mock
    StockRepository stockRepository;
    @InjectMocks
    StockServiceImpl StI;
    Stock stock=new Stock("S1",2,2);
    List<Produit> produitList=new ArrayList<Produit>(){
        {
        add(new Produit(2L,"P2","libelleP2",7.2f,new Date(),new Date()));
        add(new Produit(3L,"P3","libelleP3",18.23f,new Date(),new Date()));
    }
    };
    @Test
    void retrieveAllProduits() {
        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        Produit produit=produitService.retrieveProduit(2L);
        Assertions.assertNotNull(produit);
    }
    @Test
    void retrieveProduit() {
        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        Produit produit = produitService.retrieveProduit(2L);
        Assertions.assertNotNull(produit);
    }
    @Test
    void addProduit() {
        Produit produit = new Produit(4L,"P4","libelleP4",10f,new Date(),new Date());
        Mockito.when(produitRepository.save(ArgumentMatchers.any(Produit.class))).thenReturn(produit);
        Produit created = produitService.addProduit(produit);
        Assertions.assertSame(created,produit);
        Mockito.verify(produitRepository).save(produit);
    }
//    @Test
//    void updateProduit() {
//        Produit produit = new Produit(5L,"P5","libelleP5",18.6f,new Date(),new Date());
//        Mockito.when(produitRepository.save(ArgumentMatchers.any(Produit.class))).thenReturn(produit);
//        Produit updated = produitService.updateProduit(produit);
//        Assertions.assertNotNull(updated);
//        Mockito.verify(produitRepository).save(Mockito.any(Produit.class));
//    }
    @Test
    void deleteProduit() {

        Produit produit = new Produit(4L,"P4","libelleP4",10f,new Date(),new Date());
        Mockito.lenient().when(produitRepository.findById(produit.getIdProduit())).thenReturn(Optional.of(produit));
        produitService.deleteProduit(produit.getIdProduit());
        Mockito.verify(produitRepository).deleteById(produit.getIdProduit());
    }
    @Test
    void assignProduitToStock() {
        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        Produit produit = produitService.retrieveProduit(1L);
        Assertions.assertNotNull(produit);

        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        Stock stock1 = StI.retrieveStock(0L);
        Assertions.assertNotNull(stock1);
    }

}
