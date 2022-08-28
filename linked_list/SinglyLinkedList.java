package linked_list;

public class SinglyLinkedList {
	//head, tail dummy로 했을 때의 문제점 고치기.
	/*
	 * [Class] Node
	 *   1) 개요
	 *     - SinglyLinkedList의 data를 담는 노드
	 *     - 각 노드는 다음 노드를 가리키고 있어야 함
	 *     - data type은 정수라고 가정
	 *   2) 필수 operation
	 *     - 생성자
	 *     - getData(): 현재 노드가 가지고 있는 data를 반환하는 함수
	 *     - getNext(): 현재 노드가 가리키고 있는 Node를 반환하는 함수
	 *     - setNext(): 현재 노드의 가리키고 있는 Node를 설정하는 함수
	 */
	
	private static class Node {
		//node일 때는 안되고 this일 때 되는 이유 찾기.
		private int data;	// Node에서 저장하는 data
		private Node next;	// Node가 가리키고 있는 다음 노드
		
		/* [필수] 생성자 */
		public Node(int d) {
			// 구현
			data = d;
			next = null;
		}
		
		/* [필수] getData() */
		public int getData() {
			// 구현
			return this.data;
		}
		
		/* [필수] getNext() */
		public Node getNext() {
			// 구현
			return this.next;
		}
		
		/* [필수] setNext() */
		public void setNext(Node n) {
			// 구현
			this.next = n;
			return;
		}
	}
	
	/*
	 * [Class] SinglyLinkedList
	 *   1) 개요
	 *     - LinkedList의 첫 번째 노드를 가리키는 head와 마지막 노드를 가리키는 tail이 존재
	 *       -> head/tail을 dummy 노드로 만들어도 좋고, 데이터를 가진 노드로 만들어도 좋음
	 *     - data를 처음/마지막에 추가, 삭제하는 함수를 만들면 됨
	 *   2) 필수 operation
	 *     - getFirst(): linked list의 첫 번째 노드의 data를 반환하는 함수
	 *     - getLast(): linked list의 마지막 노드의 data를 반환하는 함수
	 *     - addFirst(): linked list의 맨 앞에 데이터를 추가
	 *     - addLast(): linked list의 맨 뒤에 데이터를 추가
	 *   3) 추가 operation
	 *     - removeFirst(): linked list의 맨 앞의 노드를 삭제(메모리 해제 필수!)
	 *     - printList(): linked list의 모든 데이터를 출력
	 */
	
	private Node head;	// data의 첫 부분을 가리키는 노드
	private Node tail;	// data의 마지막 부분을 가리키는 노드
	private int size;	// 리스트의 크기를 출력하는 노드 (필요시 사용)
	
	/* [필수] 생성자
	* DUMMY로 구현하*/

	public SinglyLinkedList() {
		// 구현
		this.head = new Node(-1);
		this.tail = new Node(-1);
		this.size = 0;
	}
	
	/* 필요시 구현 */
	//this.size와 size()의 차이점.
	public int size() {
		// 구현
		return this.size;
	}
	
	/* 필요시 구현 */
	public boolean isEmpty() {
		// 구현
		return (this.size == 0);
	}
	
	/* 
	 * [필수] getFirst()
	 *   - 노드가 아니라 데이터를 반환해야 함
	 *   - 만약 없을 경우 -1 리턴
	 */
	public int getFirst() {
		// 구현
		if (size()==0){
			return -1;
		}
		return this.head.getNext().data;
	}
	
	/* [필수] getLast() */
//	O(n)
	public int getLast() {
		// 구현
		if (size()==0){
			return -1;
		}
		Node last = head;
		for(int i = 0; i<size();i++){
			last = last.getNext();
		}
		return last.data;
	}
	
	/* 
	 * [필수] addFirst()
	 *  o(1)
	 */
	public void addFirst(int data) {
		// 구현
		// NEW NODE ->
		Node newNode = new Node(data);
		if(size() == 0){
			head.setNext(newNode);
			newNode.setNext(tail);
		}else{
			newNode.setNext(head.getNext());
			head.setNext(newNode);
		}
		size++;
	}
	
	/* [필수] addLast() O(N) */
	public void addLast(int data) {
		// 구현
		Node newNode = new Node(data);
		if(size() == 0){
			head.setNext(newNode);
			newNode.setNext(tail);
		}else{
			newNode.setNext(tail);
			Node curnode = head;
			while(curnode.getNext() != tail){
				curnode = curnode.getNext();
			}
			curnode.setNext(newNode);
		}
		size++;
	}
	
	/*
	 *  removeFirst()
	 *    - 첫 번째 노드를 삭제하고 data를 반환
	 *    - 만약 없을 경우 -1 리턴
	 */
	public int removeFirst() {
		// 구현
		if (size() == 0) {
			return -1;
		}
		// r에는 참조가 아닌 데이터가 저장되는가?
		Node remNode = head.next;
		int r = remNode.data;
		head.setNext(head.next.getNext());
		remNode = null;
		return r;
	}
	
	/*
	 * printList() : 재귀함수나 반복문으로 구현
	 *   - 형식은 다음과 같이 구현 (마지막 개행 포함)
	 *   > 1 2 3 4 5 
	 */
	public void printList() {
		// 구현
		Node r = head;
		for(int i = 0; i<size(); i++){
			r = r.getNext();
			System.out.println(r);
		}
	}
}
