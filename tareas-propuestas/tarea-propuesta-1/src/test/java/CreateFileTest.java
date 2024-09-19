import ies.puerto.CreateFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateFileTest {

    CreateFile createFile;

    String mensaje = "Mensaje como parámetro";

    @BeforeEach
    public void beforeEach() {
        createFile = new CreateFile();
    }

    @Test
    public void crearEscribirFileTest(){

        Assertions.assertTrue(createFile.crearEscribirFile(mensaje), "No se ha creado/escrito el archivo");
    }
}
