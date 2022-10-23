package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OperateurServiceImplMock {

	    @Mock
	    OperateurRepository OperateurRepository;
	    
	    @InjectMocks
	    OperateurServiceImpl StI;

	    Operateur Operateur = new Operateur("Op1", "surname1", "pwd1");
	    List<Operateur> listOperateurs = new ArrayList<Operateur>() {
	        {
	            add(new Operateur("Op2", "surname2", "pwd2"));
	            add(new Operateur("Op3", "surname3", "pwd3"));
	        }
	    };

	    @Test
	    void retrieveOperateur() {
	        Mockito.when(OperateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(Operateur));
	        Operateur Operateur1 = StI.retrieveOperateur(0L);
	        Assertions.assertNotNull(Operateur1);
	    }
	}

