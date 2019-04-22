package com.mrhu.hibernate.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TreeTest {

	@Test
	public void testTree() {
		Tree root = new Tree();
		Tree child1 = new Tree();
		Tree child2 = new Tree();
		Tree child3 = new Tree();
		Tree child4 = new Tree();
		Tree child5 = new Tree();
		
		/**
		 *    root
		 *     |------+
		 *     c1     c2
		 *     |	  |------+
		 *     c3     c4     c5
		 */
		
		root.getChild().add(child1);
		root.getChild().add(child2);
		child1.getChild().add(child3);
		child2.getChild().add(child4);
		child4.getChild().add(child5);
		
	}

}
