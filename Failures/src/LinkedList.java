public class LinkedList 
{ 
	Node head;
	public void insert(int data)
	{
		Node node=new Node();
		node.data=data;
		node.next=null;
	
		if(head==null)
		{
			head=node;
		}
		else
		{
		    Node n=head;
		    while(n.next!=null)
		    {
		    	n=n.next;
		    	
		    }
		    n.next=node;
		}
	}
	public void show()
	{  
		Node n1=head;
		Node n2=head;
		while(true)	
		{ 
			if(n1!=null && n1.next==null)
			{
			n1=n1.next;	
			n2=n2.next;
			}
			else break;
			 
		}
		
		System.out.println(n2.data);
	}	
}