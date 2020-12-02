package labTrees;

public class AmoebaFamily {
	Amoeba ancestor;
	public AmoebaFamily(String s) {
		this.ancestor= new Amoeba(s);
	}
	public Amoeba getAmoeba(String s,Amoeba x) throws Exception {
		if(x!=null) {
			if(x.name!=s) {
				Amoeba[] u=new Amoeba[x.children.size()];
				for(int i=0;i<x.children.size();i++) {
					u[i] =getAmoeba(s,x.children.get(i));
					
				}
				for(int i=0;i<u.length;i++) {
					if(u[i]!=null)
						return u[i];
				}
			}else return x;
				
		}
		return null;
		
	}
	public void addChild(String parentName,String childName) {
		try {
		Amoeba i=this.ancestor;
		i=this.getAmoeba(parentName, this.ancestor);
		Amoeba temp=new Amoeba(childName);
		i.children.add(temp);
		temp.parent=i;
		Amoeba temp2=null;
		for(int j=0;j<i.children.size();j++) {
			temp2=i.children.get(j);
			if(temp2!=temp) {
			temp2.sibling.add(temp);
			temp.sibling.add(temp2);
			}
				
		}
	}catch(Exception e) {
		System.out.print("someerror happn");
	}
		}
	private int getDepth(Amoeba X) {
		if(X==null) return 0;
		int maxDepth=0;
		for(Amoeba it:X.children) {
			maxDepth=Math.max(maxDepth, getDepth(it));
		}
		return 1+maxDepth;
			
		
	}
	public int getGenerations(AmoebaFamily F) {
		return getDepth(F.ancestor);
		
	}
	private void postOrderTraversal(Amoeba X) {
		if(X!=null) {
			System.out.println(X.name);
			for(int i=0;i<X.children.size();i++) {
				postOrderTraversal(X.children.get(i));
			}
		}
	}
	public void print() {
		postOrderTraversal(this.ancestor);
	}
	public static void main(String args[]) {
		AmoebaFamily abdejlilFamily=new AmoebaFamily("lotfi");
		System.out.println(abdejlilFamily.ancestor.name);
		Amoeba temp=new Amoeba("lboh");

		abdejlilFamily.ancestor.children.add(temp);
		temp.parent=abdejlilFamily.ancestor;
		temp=new Amoeba("ezzdin");
		abdejlilFamily.ancestor.children.add(temp);
		temp.parent=abdejlilFamily.ancestor;
		System.out.println(temp.sibling);
		temp.sibling.addAll(temp.parent.children);
		temp.sibling.remove(temp);
		System.out.println(temp.parent.children);
		try {
		System.out.println(abdejlilFamily.getAmoeba("ezzdin", abdejlilFamily.ancestor).name);
		
		System.out.println("that node does not exist");
		abdejlilFamily.addChild("ezzdin", "farah");	
		abdejlilFamily.addChild("farah", "sarra");
		System.out.println(abdejlilFamily.getAmoeba("farah", abdejlilFamily.ancestor).name);
		}catch(Exception e) {
			System.out.print("somethig happnd");
		}
		System.out.print(abdejlilFamily.getGenerations(abdejlilFamily));
		abdejlilFamily.print();
		//System.out.print(abdejlilFamily.ancestor.children.getFirst().name);

		//abdejlilFamily.ancestor.children.add(new Amoeba("lboh"));
		//abdejlilFamily.ancestor.children.getFirst().parent=abdejlilFamily.ancestor;
	
		/*abdejlilFamily.ancestor.children.add(new Amoeba("asma"));
		abdejlilFamily.ancestor.children.getFirst().sibling.add(
				abdejlilFamily.ancestor.children.getLast());
		abdejlilFamily.ancestor.children.getLast().sibling.add(
				abdejlilFamily.ancestor.children.getFirst());*/
		
		
	}
}
