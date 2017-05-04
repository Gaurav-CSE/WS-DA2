import java.util.Iterator;
import java.util.Map;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.NodeIterator;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.vocabulary.RDF;
public class HelloWorld {

public static final String RDF_FILE = "http://dbpedia.org/data/Roger_Federer.rdf";
public static void main( String[] args ) {

Model model = ModelFactory.createDefaultModel();
model.read(RDF_FILE);
 // model.write(System.out,"N3");

 // show all the namespaces in the model
 Iterator prefixNsPairs =
 model.getNsPrefixMap().entrySet().iterator();
while ( prefixNsPairs.hasNext() ) {
Map.Entry entry = (Map.Entry)(prefixNsPairs.next());
 System.out.print("prefix:" + entry.getKey());
 System.out.println(", namespace:" + entry.getValue());
 }

 // show all the classes and their instances
 System.out.println("the following types/classes have been used in this RDF document(with their instances):");
 NodeIterator classes =
 model.listObjectsOfProperty(RDF.type);
while ( classes.hasNext() ) {
 Resource typeRes = (Resource)(classes.next());
 System.out.println("(class/type)" + typeRes.getURI());
 ResIterator resources =
 model.listResourcesWithProperty(RDF.type,typeRes);
 while ( resources.hasNext() ) {
 Resource instanceRes = resources.nextResource();
if ( instanceRes.isAnon() ) {
 System.out.println(" [anonymous instance] " +
 instanceRes.getId());
} else {
	System.out.println(" [instance] " +
	instanceRes.getURI());
	}
}
 }
 }
}
