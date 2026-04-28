package es.unican.is2;

import java.awt.Dimension;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VistaAgenteIT {

    private FrameFixture ventana;
    private VistaAgente gui;

    @BeforeEach
    public void setUp() {
        ClientesDAO clientesDAO = new ClientesDAO();
        SegurosDAO segurosDAO = new SegurosDAO();
        
        GestionSeguros gestio = new GestionSeguros(clientesDAO, segurosDAO);
        gui = new VistaAgente(gestio);
        ventana = new FrameFixture(gui);
        ventana.show(new Dimension(450, 341));
    }

    @AfterEach
    public void tearDown() {
        if (ventana != null) {
            ventana.cleanUp();
        }
    }

    @Test
    public void testConsultaCliente_ClienteExistente_VariosSeguros_SinMinusvalia() {
        ventana.textBox("txtDNICliente").setText("11111111A");
        ventana.button("btnBuscar").click();

        ventana.textBox("txtNombreCliente").requireText("Juan");
        ventana.textBox("txtTotalCliente").requireText("1820.0");
        ventana.list().requireItemCount(3);
    }

    @Test
    public void testConsultaCliente_ClienteNoExistente() {
        ventana.textBox("txtDNICliente").setText("99999999Z");
        ventana.button("btnBuscar").click();

        ventana.textBox("txtNombreCliente").requireText("Error en BBDD");
        ventana.textBox("txtTotalCliente").requireText("");
        ventana.list().requireItemCount(0);
    }

    @Test
    public void testConsultaCliente_FalloBBDD() {
        ventana.cleanUp();
        ventana = null;
        IClientesDAO clientesDAO = new ClientesDAO();
        ISegurosDAO segurosDAO = new SegurosDAO();
        
        GestionSeguros gestion = new GestionSeguros(clientesDAO, segurosDAO) {
            @Override
            public Cliente cliente(String dni) throws DataAccessException {
                throw new DataAccessException();
            }
        };

        VistaAgente vista = new VistaAgente(gestion);
        FrameFixture v = new FrameFixture(vista);
        v.show(new Dimension(450, 341));
        
        v.textBox("txtDNICliente").enterText("11111111A");
        v.button("btnBuscar").click();
        
        v.textBox("txtNombreCliente").requireText("Error en BBDD");
        v.list().requireItemCount(0);
        v.textBox("txtTotalCliente").requireEmpty();
        v.cleanUp();
    }
}