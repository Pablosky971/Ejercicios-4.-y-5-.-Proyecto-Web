package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.entidad.Persona;

/**
 * Servlet implementation class PrimerServlet.
 */
// Un servlet es capaz de procesar peticiones HTTP.
//Las anotaciones en Java proporcionan funcionalidad.
// �Qu� hace exactamente la anotaci�n @WebServlet?
	// 1. Da de alta un objeto (y solo uno) de la clase PrimerServlet (Patr�n Singleton: objeto �nico).
	// 2. Mapear dicho objeto creado a la direcci�n /PrimerServlet.


	
// M�todo din�mico: solo existe si existe el objeto.
// M�todo est�tico: existe aun no existiendo el objeto.

// El ciclo de vida del Servlet es hasta que se pierda la referencia. Lo mantiene referenciado TomCat, que ha creado una referencia y el objeto PrimerServlet para mantenerlo
// con vida. Este concepto se denomina "inversi�n de control", este concepto dice que el programador no se encarga de mantener el ciclo de vida del objeto, sino otra entidad,
// que nuestro caso es Tomcat. Tomcat crea un objeto de este tipo y lo mantiene en memoria durante toda la ejecuci�n del programa. El programador lo �nico que hace es programar
// el objeto.

// El objeto Servlet ser� el mismo para todos los clientes.

@WebServlet("/PrimerServlet") // Recurso al que est� asociado este servlet. Es la manera de mapearlo.
public class PrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int contador = 0;
       
	
   
   // HTTP
	// GET /PrimerServlet http 1.1
	
	// Los servlets tendr�n dos objetos asociados: la request y la response. Ser�n creados e inyectados para poder trabajar con las peticones y las respuestas, abstray�ndome de este tipo de c�digo. 
	
	// Los objetos Request y Response tambi�n son creados mediante IoC (inveris�n del control), pero en este caso el ciclo de vida que aplica Tomcat a estos objetos es que vivir�n durante toda una
	// petici�n HTTP y luego morir�n :( :(
	
	// El otro concepto que se aplica aqu�, es el de ID (Inyecci�n de dependencias).
	// Este concepto nos dice que, cuando necesitemos un objeto para realizar una funcionalidad y no queremos crearlo, podemos pedirle a un ente qu enos proporcione dicho objeto.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Si la petici�n es GET.
		
		response.getWriter().append("Hola PrimerServlet DoGet" + contador++).append(request.getContextPath());
		
		
		// �Cu�l es el ciclo de vida de un objeto de Java?
				// El ciclo de vida de un objeto en Java.
//					1. Nace con el new();
//					2. Muere cuando se quede desreferenciado.
				// Para eliminar un objeto: p=null. De est� forma, el objeto p quedar� desreferenciado.
				// El Garbage collector es un programa que pasa cada cierto tiempo y elimina objetos desreferenciados.
				
				// �Cu�l es el ciclo de vida de una referencia en Java?
				// Respuesta: desde que declaras la referencia, hasta donde acaba el bloque donde se declar�.
				
				// Un bloque en Java es un grupo de sentencias. Para crearlo se alamacena entre {}.
		
		Persona p1=null;
		{ // Bloque
		Persona p = new Persona(); // Crear objeto persona. Se accede a los objetos mediante su referencia.
		p.setNombre("Tony Stark");
		p.getNombre();
		
		
		} // Aqu� morir� la referencia, y por lo tanto el objeto quedar� desreferenciado y morir� en un futuro cuando se pase el Garbage Collector
		
		Persona p = new Persona(); // Est� vacio. Es un objeto distinto al anterior contenido en el bloque anteriormente definido.
	}

	

	   // HTTP
		// POST /PrimerServlet http 1.1
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Si la petici�n es POST.
		
		
		response.getWriter().append("Hola PrimerServlet DoPost" +  contador++).append(request.getContextPath());
	}

}
