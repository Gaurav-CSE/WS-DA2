import java.util.Iterator;
import java.util.Map;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.vocabulary.OWL;
import com.hp.hpl.jena.vocabulary.RDF;
public class HelloWorld {
public static final String RDF_FILE = "http://dbpedia.org/data/Roger_Federer.rdf";

public static void main( String[] args ) {
Model model = ModelFactory.createDefaultModel();
model.read(RDF_FILE);

 // show all instances that have a owl:sameAs property
 System.out.println("\nfollowing instances have owl:sameAs property:");
 StmtIterator statements = model.listStatements
 ((Resource)null,OWL.sameAs,(RDFNode)null);
 while ( statements.hasNext() ) {
 Statement statement = statements.nextStatement();
Resource subject = statement.getSubject();
if ( subject.isAnon() ) {
 System.out.print(" (" + subject.getId() + ")");
 } else {
 System.out.print(" (" + subject.getURI() + ")");
 }
 System.out.print(" OWL.sameAs ");
 Resource object = (Resource)(statement.getObject());
 if ( object.isAnon() ) {
 System.out.print("(" + object + ")");
 } else if ( object.isLiteral() ) {
 System.out.print("(" + object.toString() + ")");
} else if ( object.isResource() ) {
 System.out.print("(" + object.getURI() + ")");
 }
 System.out.println();
 }

 }
 }
