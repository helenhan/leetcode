package com.helen.datastructure;

import java.util.Stack;

public class BinaryTreeIterate {

	public BinaryTreeIterate() {
		// TODO Auto-generated constructor stub
	}

	protected Node root;

	public BinaryTreeIterate(Node root) {
		this.root = root;
	}

	public Node getRoot() {
		return root;
	}

	/** ������ */
	public static Node init() {
		Node a = new Node("A");
		Node b = new Node("B", null, a);
		Node c = new Node("C");
		Node d = new Node("D", b, c);
		Node e = new Node("E");
		Node f = new Node("F", e, null);
		Node g = new Node("G", null, f);
		Node h = new Node("H", d, g);
		return h;// root
	}

	/** ���ʽڵ� */
	public static void visit(Node p) {
		System.out.print(p.getVal() + " ");
	}

	/** �ݹ�ʵ��ǰ����� */
	protected static void preorder(Node p) {
		if (p != null) {
			visit(p);
			preorder(p.getLeft());
			preorder(p.getRight());
		}
	}

	/** �ݹ�ʵ��������� */
	protected static void inorder(Node p) {
		if (p != null) {
			inorder(p.getLeft());
			visit(p);
			inorder(p.getRight());
		}
	}

	/** �ݹ�ʵ�ֺ������ */
	protected static void postorder(Node p) {
		if (p != null) {
			postorder(p.getLeft());
			postorder(p.getRight());
			visit(p);
		}
	}

	/** �ǵݹ�ʵ��ǰ����� */
	protected static void iterativePreorder(Node p) {
		Stack<Node> stack = new Stack<Node>();
		if (p != null) {
			stack.push(p);
			while (!stack.empty()) {
				p = stack.pop();
				visit(p);
				if (p.getRight() != null)
					stack.push(p.getRight());
				if (p.getLeft() != null)
					stack.push(p.getLeft());
			}
		}
	}

	/** �ǵݹ�ʵ��ǰ�����2 */
	protected static void iterativePreorder2(Node p) {
		Stack<Node> stack = new Stack<Node>();
		Node node = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {// ѹ�����е���ڵ㣬ѹ��ǰ������
				visit(node);
				stack.push(node);
				node = node.getLeft();
			}
			if (stack.size() > 0) {//
				node = stack.pop();
				node = node.getRight();
			}
		}
	}

	/** �ǵݹ�ʵ�ֺ������ */
	protected static void iterativePostorder(Node p) {
		Node q = p;
		Stack<Node> stack = new Stack<Node>();
		while (p != null) {
			// ��������ջ
			for (; p.getLeft() != null; p = p.getLeft())
				stack.push(p);
			// ��ǰ�ڵ������ӻ������Ѿ����
			while (p != null && (p.getRight() == null || p.getRight() == q)) {
				visit(p);
				q = p;// ��¼��һ��������ڵ�
				if (stack.empty())
					return;
				p = stack.pop();
			}
			// ��������
			stack.push(p);
			p = p.getRight();
		}
	}

	/** �ǵݹ�ʵ�ֺ������ ˫ջ�� */
	protected static void iterativePostorder2(Node p) {
		Stack<Node> lstack = new Stack<Node>();
		Stack<Node> rstack = new Stack<Node>();
		Node node = p, right;
		do {
			while (node != null) {
				right = node.getRight();
				lstack.push(node);
				rstack.push(right);
				node = node.getLeft();
			}
			node = lstack.pop();
			right = rstack.pop();
			if (right == null) {
				visit(node);
			} else {
				lstack.push(node);
				rstack.push(null);
			}
			node = right;
		} while (lstack.size() > 0 || rstack.size() > 0);
	}

	/** �ǵݹ�ʵ�ֺ������ ��ջ�� */
	protected static void iterativePostorder3(Node p) {
		Stack<Node> stack = new Stack<Node>();
		Node node = p, prev = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.getLeft();
			}
			if (stack.size() > 0) {
				Node temp = stack.peek().getRight();
				if (temp == null || temp == prev) {
					node = stack.pop();
					visit(node);
					prev = node;
					node = null;
				} else {
					node = temp;
				}
			}

		}
	}

	/** �ǵݹ�ʵ�ֺ������4 ˫ջ�� */
	protected static void iterativePostorder4(Node p) {
		Stack<Node> stack = new Stack<Node>();
		Stack<Node> temp = new Stack<Node>();
		Node node = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				temp.push(node);
				stack.push(node);
				node = node.getRight();
			}
			if (stack.size() > 0) {
				node = stack.pop();
				node = node.getLeft();
			}
		}
		while (temp.size() > 0) {
			node = temp.pop();
			visit(node);
		}
	}

	/** �ǵݹ�ʵ��������� */
	protected static void iterativeInorder(Node p) {
		Stack<Node> stack = new Stack<Node>();
		while (p != null) {
			while (p != null) {
				if (p.getRight() != null)
					stack.push(p.getRight());// ��ǰ�ڵ�������ջ
				stack.push(p);// ��ǰ�ڵ���ջ
				p = p.getLeft();
			}
			p = stack.pop();
			while (!stack.empty() && p.getRight() == null) {
				visit(p);
				p = stack.pop();
			}
			visit(p);
			if (!stack.empty())
				p = stack.pop();
			else
				p = null;
		}
	}

	/** �ǵݹ�ʵ���������2 */
	protected static void iterativeInorder2(Node p) {
		Stack<Node> stack = new Stack<Node>();
		Node node = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.getLeft();
			}
			if (stack.size() > 0) {
				node = stack.pop();
				visit(node);
				node = node.getRight();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTreeIterate tree = new BinaryTreeIterate(init());
		System.out.print(" Pre-Order:");
		preorder(tree.getRoot());
		System.out.println();
		System.out.print("  In-Order:");
		inorder(tree.getRoot());
		System.out.println();
		System.out.print("Post-Order:");
		postorder(tree.getRoot());
		System.out.println();
		System.out.print(" Pre-Order:");
		iterativePreorder(tree.getRoot());
		System.out.println();
		System.out.print("Pre-Order2:");
		iterativePreorder2(tree.getRoot());
		System.out.println();
		System.out.print("  In-Order:");
		iterativeInorder(tree.getRoot());
		System.out.println();
		System.out.print(" In-Order2:");
		iterativeInorder2(tree.getRoot());
		System.out.println();
		System.out.print(" Post-Order:");
		iterativePostorder(tree.getRoot());
		System.out.println();
		System.out.print("Post-Order2:");
		iterativePostorder2(tree.getRoot());
		System.out.println();
		System.out.print("Post-Order3:");
		iterativePostorder3(tree.getRoot());
		System.out.println();
		System.out.print("Post-Order4:");
		iterativePostorder4(tree.getRoot());
		System.out.println();

	}

}

class Node {
	String val;
	Node left;
	Node right;

	Node(String x) {
		val = x;
	}

	Node(String x, Node left, Node right) {
		this.val = x;
		this.left = left;
		this.right = right;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
