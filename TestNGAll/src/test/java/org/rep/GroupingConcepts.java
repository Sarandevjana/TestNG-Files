package org.rep;

import org.testng.annotations.Test;

public class GroupingConcepts {
     @Test(groups= {"Apple"})
	 private void apple1() {
	System.out.println("Apple testing");
	 }
     @Test(groups= {"Apple"})
	 private void apple2() {
		 System.out.println("Apple testing");	 
	 }
     @Test(groups= {"Moto"})
	   private void moto1() {
		System.out.println("Moto Testing");
}
     @Test(groups= {"Moto"})
	   private void moto2() {
			System.out.println("Moto Testing"); 
	   }
     @Test(groups= {"VIVO"})
	   private void vivo1() {
	   System.out.println("Vivo testing");

	}
     @Test(groups= {"VIVO"})
	   private void vivo2() {
		   System.out.println("Vivo testing");
		}
     @Test(groups= {"Lenovo"})
	   private void lenovo1() {
	     System.out.println("lenovo Testing ");

	}
     @Test(groups= {"Lenovo"})
	   private void lenovo2() {
		     System.out.println("lenovo Testing ");

		}
}
