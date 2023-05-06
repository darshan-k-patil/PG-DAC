package tester;

import java.util.HashSet;

import com.app.core.*;

public class TestAccountSet {

	public static void main(String[] args) {
//first wrong output
//then override equals added but same wrong o/p 
//after that override hashCode also added then correct output
		BankAccount a1 = new BankAccount(101, "Rama", AccountType.SAVING, 12000);
		BankAccount a2 = new BankAccount(10, "Vijaya", AccountType.CURRENT,6000);
		BankAccount a3 = new BankAccount(101, "Anand", AccountType.SAVING, 12000);
		BankAccount a4 = new BankAccount(67, "Rama", AccountType.SAVING, 10000);
		//create empty HS of accounts
				HashSet<BankAccount> accounts=new HashSet<>();//size=0;init capa=16,load factor=0.75
				System.out.println("Added "+accounts.add(a1));//t hc=1
				System.out.println("Added "+accounts.add(a2));//t hc=1, eq=1
				System.out.println("Added "+accounts.add(a3));//f hc=1, eq=1
				System.out.println("Added "+accounts.add(a4));//t hc=1, eq=2
				System.out.println("size "+accounts.size());
				for(BankAccount a : accounts)
					System.out.println(a);
//				System.out.println(a1.equals(a3));//t
//				System.out.println(a1.hashCode()+" "+a3.hashCode());//diff
	}
}
