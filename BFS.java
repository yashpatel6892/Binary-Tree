import java.util.Stack;


public class BFS {

	public static Tree_node root = null;
	public static void main(String[] args) {
		
		insert(5);
		insert(3);
		insert(8);
		insert(1);
		insert(4);
		insert(6);
		insert(9);
		
		System.out.print("BFS: ");
		BFS(root);
		System.out.print("\ninorder:");
		inorder_iterative(root);
		System.out.print("\nPreorder: ");
		preorder_iterative(root);
		System.out.print("\nPostorder: ");
		postorder_iterative(root);
		System.out.println("\nHeight :"+Height(root));
		System.out.println("IsBalanced :"+isBalanced(root));
		System.out.println("Diameter :"+diameter(root));
		
		

	}
	
	private static int diameter(Tree_node root2) {
		
		if(root2==null)
		{
			return 0;
		}
		int left_height = Height(root2.left);
		int right_height = Height(root2.right);
		
		int left_diameter = diameter(root2.left);
		int right_diameter = diameter(root2.right);
		return Math.max(left_height+right_height+1, Math.max(left_diameter, right_diameter));
		
		
	}

	private static boolean isBalanced(Tree_node root2) {
	
		if(root2==null)
		{
			return true;
		}
		int left_height = Height(root2.left);
		int right_height = Height(root2.right);
		
		if(Math.abs(left_height-right_height)<=1 && isBalanced(root2.left) && isBalanced(root2.right))
		{
			return true;
		}
		return false;
	}

	private static int Height(Tree_node root2) {
		if(root2 == null)
		{
			return 0;
		}
		int left = Height(root2.left);
		int Right = Height(root2.right);
		
		return Math.max(left, Right)+1;
		
	}

	private static void postorder_iterative(Tree_node root2) {
		
		Stack<Tree_node> s1 = new Stack<>();
		Stack<Tree_node> s2 = new Stack<>();
		if(root2 == null)
		{
			return ;
		}
		s1.push(root2);
		
		while(!s1.isEmpty())
		{
			root2 = s1.pop();
			s2.push(root2);
			if(root2.left != null)
			{
				s1.push(root2.left);
			}
			if(root2.right!=null)
			{
				s1.push(root2.right);
			}
		}
		
		while(!s2.isEmpty())
		{
			root2 = s2.pop();
			System.out.print(root2.value+"  ");
		}
		
		
	}

	private static void preorder_iterative(Tree_node root2) {
		
		Stack<Tree_node> s = new Stack<Tree_node>();
		if(root2==null)
		{
			return ;
		}
		
		s.push(root2);
		while(!s.isEmpty())
		{
			root2 = s.pop();
			System.out.print(root2.value+"  ");
			
			if(root2.right!=null)
			{
				s.push(root2.right);
			}
			if(root2.left!=null)
			{
				s.push(root2.left);
			}
		}
		
	}

	private static void inorder_iterative(Tree_node root2) {
		Stack<Tree_node> s = new Stack<>();
		
		boolean check = false;
		
		while(!check)
		{
			if(root2!=null)
			{
				s.push(root2);
				root2 = root2.left;
			}
			else
			{
				if(!s.isEmpty())
				{
					root2 = s.peek();
					s.pop();
					System.out.print(root2.value+"  ");
					root2 = root2.right;
				}
				else
				{
					check = true;
				}
			}
		}
		
	}

	private static void BFS(Tree_node root2) {
		
		
		QueueOprations q = new QueueOprations();
		if(root2== null)
		{
			return ;
		}
		q.enqueu(root2);
		while(!q.isEmpty())
		{
			Tree_node temp= q.front();
			System.out.print(temp.value+"  ");
			if(temp.left!=null)
			{
			q.enqueu(temp.left);
			}
			if(temp.right!=null)
			{
			q.enqueu(temp.right);
			}
			q.enqueue();
		}
		
		
	}
	private static void inorder(Tree_node root2) {

		if(root2==null) return ;
		inorder(root2.left);
		System.out.println(root2.value);
		inorder(root2.right);
	}
	private static void insert(int i) {
	
		Tree_node new_node  = new Tree_node(null, null, null, i,false);
		Tree_node x = root;
		Tree_node y = null;
		
		while(x != null)
		{
			y = x;
			if(x.value > i )
			{
				x = x.left;
			}
			else
			{
				x = x.right;
			}
		}
		
		new_node.parent = y ;
		
		if(y == null)
		{
			root  = new_node;
		}
		else if(y.value > i)
		{
			y.left = new_node;
		}
		else
		{
			y.right = new_node;
		}
	}

}
