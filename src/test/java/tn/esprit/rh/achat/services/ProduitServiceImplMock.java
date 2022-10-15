package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProduitServiceImplMockTest{
//    private Long idProduit;
//    private String codeProduit;
//    private String libelleProduit;
//    private float prix;
//    @Temporal(TemporalType.DATE)
//    private Date dateCreation;
//    @Temporal(TemporalType.DATE)
//    private Date dateDerniereModification;
    @Mock
    ProduitRepository produitRepository;
    @InjectMocks
    ProduitServiceImpl produitService;

    Produit produit= new Produit(1L,"P1","libelleP1",12.5f,new Date(),new Date());
    List<Produit> produitList=new ArrayList<Produit>(){
        {
        add(new Produit(2L,"P2","libelleP2",7.2f,new Date(),new Date()));
        add(new Produit(3L,"P3","libelleP3",18.23f,new Date(),new Date()));
    }
    };
    @Test
    void retrieveAllProduits() {
        Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
        Produit produit1=produitService.retrieveProduit(2L);
        Assertions.assertNotNull(produit1);
    }
}
