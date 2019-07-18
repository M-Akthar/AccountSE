package com.qa.persistence.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Transactional(value = TxType.REQUIRED)
public class DatabaseRepository implements AccountRepository {
	
	private JSONUtil json = new JSONUtil();
	
	// Some of this code will be re-factored during the next exercise. I will need to start converting JSON
	
    @PersistenceContext(unitName = "primary")
    private EntityManager em;
	
	@Transactional(value = TxType.SUPPORTS)
	public String findAnAccount(String firstName) {
		
		Account searchResult = em.find(Account.class, firstName);
		System.out.println(searchResult);
		return null;
	}
	
	@Transactional(value = TxType.SUPPORTS)
	public String getAllAccounts() {
		
        TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a ORDER BY a.ID DESC", Account.class);
        System.out.println(query.getResultList());

		return null;
	}

	public String createAccount(String account) {
		
		
		Account a = json.getObjectForJSON(account, Account.class);
		em.persist(a);
		
		return null;
	}

	public String deleteAccount(String account) {
		Account toDel = json.getObjectForJSON(account, Account.class);
		Account toRem = em.find(Account.class, toDel.getId());
		em.remove(toRem);

		return null;
	}

	public String updateAccount(int id, int accountNumber, String firstName, String lastName) {
		
		Account existing = em.find(Account.class, id);
		existing.setAccountNumber(accountNumber);
		existing.setFirstName(firstName);
		existing.setLastName(lastName);
		
		em.persist(existing);

		return null;
	}

}
