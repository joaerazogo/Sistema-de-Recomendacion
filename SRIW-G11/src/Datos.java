
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.commons.lang3.StringUtils;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Literal;
import org.apache.jena.rdf.model.Model;

import javax.swing.JButton;

public class Datos extends JFrame {

	private JPanel contentPane;
	QueryExecution qexec;

	/**
	 * Create the frame.
	 */
	public Datos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 315, 160);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCargarDatos = new JButton("Cargar datos a calificar");
		btnCargarDatos.setBounds(67, 55, 179, 29);
		contentPane.add(btnCargarDatos);
		btnCargarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargarDatos(e);
			}
		});
		this.setLocationRelativeTo(null);
	}
	

	
	private ArrayList<Ciudad> datosCalificar() {
		Model model = Ciudad.getModel();
		ArrayList<Ciudad> puntosWifi;
		String sparqlQueryString1 = "PREFIX base:<http://www.sistemarecomendacion.com/sitiosWifi#>"  //Prefijo propio de la ontologia
				+ "SELECT DISTINCT ?municipio ?nombrePuntoWIFI ?tipo ?temperatura "
				+ "WHERE {"  			
				+ "?departamento base:tiene ?municipio."							//Primera relacion objeto1->tiene->objeto2
				+ "?municipio base:tiene ?puntoWIFI."								//Primera relacion objeto2->tiene->objeto3
				+ "?departamento base:name ?nombreDepartamento."
				+ "?puntoWIFI base:name ?nombrePuntoWIFI."
				+ "?puntoWIFI base:tipo ?tipo."	
				+ "?puntoWIFI base:temperatura ?temperatura." 										//En nuestra ontologia es posible que exista un 4to
				;
		
		Query q = QueryFactory.create(sparqlQueryString1);											//ya que solo los puntosWIFI tienen este tipo de 
		qexec = QueryExecutionFactory.create(q,model);
		//Validar la cantidad de filas
		try {

			ResultSet results = qexec.execSelect();
			ciudades = new ArrayList<Ciudad>();
			//ResultSetFormatter.out(System.out,results);
			while ( results.hasNext() ) {
				if(ciudades.size() == 4) {
					QuerySolution soln = results.nextSolution();
	                String nombre = soln.getLiteral("nombrePuntoWIFI").getString();
	                String tipo = soln.getLiteral("tipo").getString();
	                String temperatura = soln.getLiteral("temperatura").getString();
	                ciudades.add(new Ciudad(nombre, tipo, temperatura));
					break;
				}
                QuerySolution soln = results.nextSolution();
                String nombre = soln.getLiteral("nombrePuntoWIFI").getString();
                String tipo = soln.getLiteral("tipo").getString();
                String temperatura = soln.getLiteral("temperatura").getString();
                ciudades.add(new Ciudad(nombre, tipo, temperatura));
        	}
		}finally {
			qexec.close();
		}
		return ciudades;
	}
	
	private void CargarDatos(java.awt.event.ActionEvent evt){
		ArrayList<Ciudad> puntosCalificar = datosCalificar();
		this.setVisible(false);
		(new Calificar(puntosCalificar, qexec)).setVisible(true);
	}
}
