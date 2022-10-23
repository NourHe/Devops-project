package rh.achat.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;

import tn.esprit.rh.achat.services.ReglementServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ReglementServiceImplMock {
	@Mock
    ReglementRepository regRepository;
    @InjectMocks
    ReglementServiceImpl RegImp;

    Reglement regl = new Reglement(10.5f, 3.2f,Boolean.TRUE, new Date());
    List<Reglement> listReglement = new ArrayList<Reglement>() {
        {
            add(new Reglement(17.5f, 8.2f,Boolean.TRUE, new Date()));
            add(new Reglement(19.5f, 45.2f,Boolean.FALSE, new Date()));
        }
    };

    @Test
    void retrieveReglement() {
        Mockito.when(regRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(regl));
        Reglement reg1 = RegImp.retrieveReglement(0L);
        Assertions.assertNotNull(reg1);
    }
}
