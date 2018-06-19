package com.zl.demo.javase;

public class MyLinkedList<E>  {
	
	int size = 0;
	int modCount = 0;
	Node<E> first;
	Node<E> last;
	
	public MyLinkedList() {
		
	}
	
	public boolean add(E item) {
		linkLast(item);
		return true;
	}
	
	public void add(E item, int index) {
		checkPositionIndex(index);
		if (index == this.size) 
			linkLast(item);
		else
			linkBefore(item, node(index));
	}
	
	public boolean remove(Object o) {
		if (o == null) {
			for (Node<E> x = this.first; x != null; x = x.next) {
				if (x.item == null) {
					unlink(x);
					return true;
				}
			}
		} else {
			for (Node<E> x = this.first; x != null; x = x.next) {
				if (o.equals(x.item)) {
					unlink(x);
					return true;
				}
			}
		}
		return false;
	}
	
	public E remove(int index) {
		checkPositionIndex(index);
		return unlink(node(index));
	}
	
	void checkPositionIndex(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException();
	}
	
	void checkElementIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
	}
	
	E unlink(Node<E> node) {
		Node<E> preNode = node.pre;
		Node<E> nextNode = node.next;
		E element = node.item;
		if (preNode == null) {
			first = nextNode;
		} else {
			preNode.next = nextNode;
			node.pre = null;
		}
		
		if (nextNode == null) {
			last = preNode;
		} else {
			nextNode.pre = preNode;
			node.next = null;
		}
		node.item = null;
		size--;
		modCount++;
		return element;
	}
	
	void linkBefore(E item, Node<E> succ) {
		Node<E> p = succ.pre;
		Node<E> newNode = new Node(p, item, succ);
		if (p == null)
			first = newNode;
		else {
			p.next = newNode;
		}
		size++;
		modCount++;
	}
	
	void linkLast(E item) {
		Node<E> l = last;
		Node<E> newNode = new Node(l, item, null);
		last = newNode;
		if (l == null) {
			first = newNode;
		} else {
			l.next = newNode;
		}
		size++;
		modCount++;
	}
	
	Node<E> node(int index) {
		if (index < this.size >> 1) {
			Node<E> node = this.first;
			for (int i = 0; i < index; i++) {
				node = node.next;
			}
			return node;
		}
		Node<E> node = this.last;
		for (int i = this.size -1; i > index; i--)
			node = node.pre;
		return node;
	}
	
	public E get(int index) {
		checkElementIndex(index);
		return node(index).item;
	}
	
	private static class Node<E> {
		E item;
		Node<E> pre;
		Node<E> next;
		
		Node (Node<E> pre, E item, Node<E> next) {
			this.item = item;
			this.pre = pre;
			this.next = next;
		}
	}
	
	public void show() {
		for (Node<E> x = this.first; x != null; x = x.next)
			System.out.println(x.item);
	}
	
	public static void main(String[] args) {
		MyLinkedList<String> linkedList = new MyLinkedList<>();
		for (int i = 0; i < 20; i++) {
			linkedList.add("VB" + i);
		}
		linkedList.add("last", 20);
		linkedList.add("first", 0);
		linkedList.remove("VB19");
		linkedList.remove(0);
		linkedList.remove(19);
		System.out.println(linkedList.size);
		linkedList.show();
		for (int i = 0; i < linkedList.size; i++) {
			System.out.println(linkedList.get(i));
		}
	}
}

