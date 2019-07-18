package com.qa.persistence.repository;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Default
@Transactional(value = TxType.SUPPORTS)
public class DatabaseRepository implements AccountRepository {
	
	private JSONUtil json = new JSONUtil();
	
	// Some of this code will be re-factored during the next exercise. I will need to start converting JSON
	
    @PersistenceContext(unitName = "primary")
    private EntityManager em;
	
//	@Transactional(value = TxType.SUPPORTS)
//	public String findAnAccount(String firstName) {
//		
//		Account searchResult = em.find(Account.class, firstName);
//		System.out.println(searchResult);
//		return null;
//	}
	
	public String getAllAccounts() {
		
        TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a ORDER BY a.ID DESC", Account.class);
        System.out.println(query.getResultList());

		return json.getJSONForObject(query.getResultList());
	}

	@Transactional(value = TxType.REQUIRED)
	public String createAccount(String account) {
		
		
		Account a = json.getObjectForJSON(account, Account.class);
		em.persist(a);
		
		return SUCCESS;
	}

	@Transactional(value = TxType.REQUIRED)
	public String deleteAccount(int id) {
		
		Account toRem = em.find(Account.class, id);
		em.remove(toRem);

		return SUCCESS;
	}

	@Transactional(value = TxType.REQUIRED)
	public String updateAccount(int id, String account) {
		
		Account newAccount = json.getObjectForJSON(account, Account.class);
		Account existing = em.find(Account.class, id);
		
		existing.setAccountNumber(newAccount.getAccountNumber());
		existing.setFirstName(newAccount.getFirstName());
		existing.setLastName(newAccount.getLastName());
		
		em.persist(existing);

		return SUCCESS;
	}
	
	public List<Account> findAccountsByFirstName(String firstName) {
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a WHERE a.firstName = :firstName",
				Account.class);
		query.setParameter("firstName", firstName);
		return query.getResultList();
	}

}
