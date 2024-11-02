package parcial1DSoftware.demo.Services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import parcial1DSoftware.demo.Entities.DnaMutante;
import parcial1DSoftware.demo.Repositories.DnaMutanteRepository;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DnaMutanteServiceTest {

    @InjectMocks
    private DnaMutanteService dnaMutanteService;

    @Mock
    private DnaMutanteRepository dnaMutanteRepository;

    private long initialMutanteCount;
    private long initialHumanoCount;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // Resetea los contadores para cada prueba
        dnaMutanteService.contadorMutanteDna = 0;
        dnaMutanteService.contadorHumanoDna = 0;
    }

    @Test
    void testEsMutante_CuandoEsMutante() {
        String[] dna = {"ATGCGA", "AAGTCA", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        boolean result = dnaMutanteService.esMutante(dna);

        assertTrue(result);
        // Cambiar a Long
        assertEquals(Long.valueOf(1), dnaMutanteService.getEstadisticas().get("count_mutant_dna"));
        assertEquals(Long.valueOf(0), dnaMutanteService.getEstadisticas().get("count_human_dna"));
    }


    @Test
    void testEsMutante_CuandoEsHumano() {
        String[] dna = {"GTACAA", "AGTTGC", "CCTGTA", "CTTAAA", "AAATGT", "TGTCAG"};
        boolean result = dnaMutanteService.esMutante(dna);

        assertFalse(result);
        // Cambiar a Long
        assertEquals(Long.valueOf(0), dnaMutanteService.getEstadisticas().get("count_mutant_dna"));
        assertEquals(Long.valueOf(1), dnaMutanteService.getEstadisticas().get("count_human_dna"));
    }


    @Test
    void testGetEstadisticas() {
        String[] mutanteDna = {"ATGCGA", "AAGTCA", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};
        String[] humanoDna = {"GTACAA", "AGTTGC", "CCTGTA", "CTTAAA", "AAATGT", "TGTCAG"};

        dnaMutanteService.esMutante(mutanteDna);
        dnaMutanteService.esMutante(humanoDna);

        Map<String, Object> stats = dnaMutanteService.getEstadisticas();
        assertEquals(Long.valueOf(1), stats.get("count_mutant_dna")); // Cambiar a Long
        assertEquals(Long.valueOf(1), stats.get("count_human_dna")); // Cambiar a Long
        assertEquals(1.0, stats.get("ratio"));
    }

    @Test
    void testDelete() throws Exception {
        DnaMutante dnaMutante = new DnaMutante();
        dnaMutante.setId(1L);

        when(dnaMutanteRepository.existsById(1L)).thenReturn(true);

        boolean result = dnaMutanteService.delete(1L);
        assertTrue(result);
        verify(dnaMutanteRepository).deleteById(1L);
    }

    @Test
    void testDeleteAll() throws Exception {
        boolean result = dnaMutanteService.deleteAll();
        assertTrue(result);
        verify(dnaMutanteRepository).deleteAll();
    }
}
