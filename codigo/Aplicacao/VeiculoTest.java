
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VeiculoTest {

	

    @BeforeEach
    void setUp() throws Exception {
    	List<Rota> listaDeRotas = new ArrayList<Rota>();
    }

    
    @Test
    void addRota(double distanciaTotal, LocalDate data) {
    	Rota rota = new Rota(100, data);
//    	listaDeRotas.add(rota);
    }


}
