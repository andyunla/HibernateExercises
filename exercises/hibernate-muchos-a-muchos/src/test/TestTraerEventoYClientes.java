package test;

import java.util.Set;
import datos.Cliente;
import datos.Evento;
import funciones.LoggerWrapper;
import negocio.EventoABM;
/*
 * Test que trae un evento específico y sus clientes
 */
public class TestTraerEventoYClientes {
    public static void main(String[] args) {
        String className = TestTraerEventoYClientes.class.getName();
        LoggerWrapper logger = LoggerWrapper.getInstance(className, true); // El 2do parámetro es para que hibernate no muestre los logs
        EventoABM eventoABM = new EventoABM();
        long idEvento = 1;
        logger.info("Traer clientes del Evento idEvento=" + idEvento + "\n\n");
        try {
            Evento evento = eventoABM.traerEvento(idEvento);
            logger.info("Evento: " + evento);
            int cont = 1;
            Set<Cliente> clientes = evento.getClientes();
            for (Cliente c : clientes) {
                System.out.println("Cliente " + cont + " - " + c);
                cont++;
            }
        } catch(Exception e) {
            logger.error(e.getMessage());
        }
    }
}
