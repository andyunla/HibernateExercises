package test;

import datos.Cliente;
import datos.Evento;
import funciones.LoggerWrapper;
import negocio.ClienteABM;
import negocio.EventoABM;
/*
 * Test que elimina un evento de un cliente dado
 */
public class TestEliminarEventoDeCliente {
    public static void main(String[] args) {
        String className = TestEliminarEventoDeCliente.class.getName();
        LoggerWrapper logger = LoggerWrapper.getInstance(className, true); // El 2do parámetro es para que hibernate no muestre los logs
        ClienteABM clienteABM = new ClienteABM();
        EventoABM eventoABM = new EventoABM();
        int dni = 14000000;
        long idEvento = 2;
        try {
            Cliente cliente = clienteABM.traer(dni);
            Evento evento = eventoABM.traerEvento(idEvento);
            logger.info("Eliminar evento con id: " + idEvento + " del Cliente: \n" + cliente + "\n\n");
            boolean eliminado = cliente.eliminar(evento);
            if (eliminado) {
                clienteABM.modificar(cliente);
                logger.info("Cliente actualizado satisfactoriamente");
            } else {
                logger.warning("ERROR: No se pudo eliminar el evento al cliente.");
            }
        } catch(Exception e) {
            logger.error(e.getMessage());
        }
    }
}
