package modelJMS;

import com.google.gson.Gson;
import model.Trama;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Productor {

    public Productor() {

    }

    public void enviarMensaje(String cola) throws JMSException {

        //Creando el connection factory indicando el host y puerto, en la trama el failover indica que reconecta de manera
        // automatica
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

        //Crea un nuevo hilo cuando hacemos a conexión, que no se detiene cuando
        // aplicamos el metodo stop(), para eso tenemos que cerrar la JVM o
        // realizar un close().
        Connection connection = factory.createConnection("admin", "admin");
        connection.start();

        // Creando una sesión no transaccional y automatica.
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Creamos o nos connectamos a la una cola, por defecto ActiveMQ permite
        // la creación si no existe. Si la cola es del tipo Queue es acumula los mensajes, si es
        // del tipo topic es en el momento.

        Queue queue = session.createQueue(cola);
//        Topic topic = session.createTopic(cola);


        // Creando el objeto de referencia para enviar los mensajes.
        MessageProducer producer = session.createProducer(queue);


//        String mensaje = mensajeEnviar;


        // Creando un simple mensaje de texto y enviando.

    }
}
