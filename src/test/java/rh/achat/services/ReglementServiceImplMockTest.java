package rh.achat.services;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import tn.esprit.rh.achat.AchatApplication;
import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;

import tn.esprit.rh.achat.services.ReglementServiceImpl;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@SpringBootTest(classes=AchatApplication.class)
@ExtendWith(MockitoExtension.class)
public class ReglementServiceImplMockTest {
	@Mock
    ReglementRepository reglementRepository;
    @InjectMocks
    ReglementServiceImpl reglementService;
    
    private MockMvc mockMvc;
   
    Reglement regl1 = new Reglement(10.5f, 3.2f,Boolean.TRUE, new Date());
   
    List<Reglement> listReglement = new ArrayList<Reglement>() {
        {
            add(new Reglement(17.5f, 8.2f,Boolean.TRUE, new Date()));
            add(new Reglement(19.5f, 45.2f,Boolean.FALSE, new Date()));
        }
    };

    @Test
    void retrieveReglement() {
        Mockito.when(reglementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(regl1));
        Reglement reg1 = reglementService.retrieveReglement(2L);
        Assertions.assertNotNull(reg1);
    }
    
    
    @Test
    void addReglementTestMock() {
    	Reglement regl2 = new Reglement(20.520f, 320.20f,Boolean.TRUE, new Date());
        Mockito.when(reglementRepository.save(ArgumentMatchers.any(Reglement.class))).thenReturn(regl2);
        Reglement created = reglementService.addReglement(regl2);
        Assertions.assertSame(created,regl2);
        Mockito.verify(reglementRepository).save(regl2);
    }
   /* @Test
    void deleteReglement() {      
    	Mockito.when( reglementService.deleteReglement(10001L)).thenReturn("SUCCESS");
        mockMvc.perform(MockMvcRequestBuilders.delete("/applications", 10001L))
                .andExpect(status().isOk());
    }
    
    
   */ 
    
 /*   @Test
  void deleteReglementTestMock() {

    	Reglement regl3 = new Reglement(20.70f, 70.70f,Boolean.TRUE, new Date());
    	Mockito.lenient().when(reglementRepository.findById(regl3.getIdReglement())).thenReturn(Optional.of(regl3));

        reglementService.deleteReglement(regl3.getIdReglement());
       

        verify(reglementRepository).deleteById(regl3.getIdReglement());
    }
    

    @Test
   	    void updateReglementTestMock() {
   	    
    	Reglement regl4 = new Reglement(20.70f, 70.70f,Boolean.TRUE, new Date());
    	regl4.setIdReglement(25L);
   	       Mockito.lenient().when(reglementRepository.findById(regl4.getIdReglement())).thenReturn(Optional.of(regl4));
         when(reglementRepository.save(regl4)).thenReturn(regl4);
         reglementService.updateReglement(regl4);
           Mockito.verify(reglementRepository).save(regl4);

       }
*/
    
   
    
    
    
    
    
    
    
    
}
