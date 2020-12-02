package labTrees;
import java.util.*;
public class Amoeba {
	Amoeba parent;
	LinkedList <Amoeba> children;
	LinkedList <Amoeba> sibling;
	String name;
	public Amoeba(String s) {
		this.name=s;
		this.parent=null;
		this.children=new LinkedList<Amoeba>();
		this.sibling=new LinkedList<Amoeba>();
	}
}
