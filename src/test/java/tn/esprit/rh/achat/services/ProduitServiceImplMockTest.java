package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProduitServiceImplMockTest {

    private Produit produit ;
    @Mock
    ProduitRepository produitRepository=Mockito.mock(ProduitRepository.class);

    @InjectMocks
    ProduitServiceImpl produitService;

    Produit produit1 = new Produit(null, "P", "PRODUIT1", 5, null, null, null, null, null);

    List<Produit> prodlist = new ArrayList<Produit>() {

        {
            add(new Produit(1L, "P1", "Biscuit", 5, null, null, null, null, null));
            add(new Produit(2L, "P1", "Javel", 5, null, null, null, null, null));
            add(new Produit(3L, "P1", "Tv", 5, null, null, null, null, null));
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
