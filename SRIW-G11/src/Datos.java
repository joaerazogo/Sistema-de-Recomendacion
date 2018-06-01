
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

import virtuoso.jena.driver.VirtGraph;
import virtuoso.jena.driver.VirtuosoQueryExecution;
import virtuoso.jena.driver.VirtuosoQueryExecutionFactory;

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
	


	private ArrayList<Ciudad> datos() {
		//Acá se conecta con virtuoso, falta completar el jdbc
		VirtGraph grafo = new VirtGraph ("onto","jdbc:virtuoso://x:1111", "dba", "dba");  
		ArrayList<Ciudad> ciudades;
		String sparqlQuery = "PREFIX onto:<http://www.SRIW-G11/ontology/>"  			
				+ "PREFIX foaf:<http://www.SRIW-G11/ontology/>"
				+ "SELECT DISTINCT ?nombre ?descripcion ?ubicacion ?telefono "
				+ "WHERE {"  			
				+ "?x onto:descripcion ?descripcion,"									
				+ "onto:ubicacion ?ubicacion,"										
				+ "onto:telefono ?ntelefono,"
				+ "foaf:name ?nombre."										
				;
		
		Query query = QueryFactory.create(sparqlQuery);	
		VirtuosoQueryExecution vquery = VirtuosoQueryExecutionFactory.create (query, grafo);
		try {

			ResultSet results = vquery.execSelect();
			ciudades = new ArrayList<Ciudad>();
			while ( results.hasNext() ) {
                QuerySolution soln = results.nextSolution();
                String nombre = soln.getLiteral("nombre").getString();
                String descripcion = soln.getLiteral("descripcion").getString();
                String ubicacion = soln.getLiteral("ubicacion").getString();
                String telefono = soln.getLiteral("telefono").getString();
                //ciudades.add(new Ciudad(nombre, descripcion, ubicacion, telefono));
        	}
		}finally {
			vquery.close();
		}
		return ciudades;
	}
	
	private void CargarDatos(java.awt.event.ActionEvent evt){
		ArrayList<Ciudad> puntos = datos();
		this.setVisible(false);
		//(new Calificar(puntos, vquery)).setVisible(true);
	}
}

