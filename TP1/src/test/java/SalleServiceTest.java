import entities.Salle;
import services.SalleService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class SalleServiceTest {

    private SalleService salleService;
    private Salle salle;




    @Before
    public void setUp() {
        salleService = new SalleService();
        salle = new Salle();
        salle.setCode("A101");
        salleService.create(salle);
    }
    @After
    public void tearDown() {
        Salle foundSalle = salleService.findById(salle.getId());
        if (foundSalle != null) {
            salleService.delete(foundSalle);
        }
    }
    @Test
    public void tesCreate() {
        assertNotNull("Salle should not be null", salle.getId());
    }
    @Test
    public void testFindById(){
        Salle foundSalle = salleService.findById(salle.getId());
        assertNotNull("Salle should not be found", foundSalle);
        assertEquals("Found salle should match",salle.getCode(),foundSalle.getCode());
    }
    @Test
    public void testUpdate() {
        salle.setCode("B202");
        boolean result = salleService.update(salle);
        assertTrue("Salle should not be updated", result);
        Salle updatedSalle = salleService.findById(salle.getId());
        assertEquals("Found salle should match","B202",updatedSalle.getCode());
    }

    @Test
    public void testDelete() {
        boolean result = salleService.delete(salle);
        assertTrue("Salle should not be deleted", result);
        Salle foundSalle = salleService.findById(salle.getId());
        assertNull("Found salle should not be deleted", foundSalle);
    }
    @Test
    public void testFindAll() {
        List<Salle> salles = salleService.findAll();
        assertNotNull("Salles should not be null", salles);
        assertTrue("Salles should not be empty", salles.size() > 0);
    }

}

