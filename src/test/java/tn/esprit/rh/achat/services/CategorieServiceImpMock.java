package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CategorieServiceImpMock {

    @Mock
    CategorieProduitRepository categorieRepository;
    @InjectMocks
    CategorieProduitServiceImpl StI;

    CategorieProduit categorieProduit = new CategorieProduit("libelleStock1", "10");
    List<CategorieProduit> listCategories = new ArrayList<CategorieProduit>() {
        {
            add(new CategorieProduit("libelleStock2","2"));
            add(new CategorieProduit("libelleStock3","5"));
        }
    };


    @Test
    void retrieveCategorie() {
        Mockito.when(categorieRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(categorieProduit));
        CategorieProduit categorieProduit1 = StI.retrieveCategorieProduit(0L);
        Assertions.assertNotNull(categorieProduit1);
    }

    @Test
    void retrieveAllCategorie()
    {
        Mockito.when(categorieRepository.findAll()).thenReturn(listCategories);
        List<CategorieProduit> list = StI.retrieveAllCategorieProduits();
        Assertions.assertNotNull(list);
    }

}