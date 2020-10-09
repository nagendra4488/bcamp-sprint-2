package com.capg.ewallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.ewallet.errors.AccountAlreadyExistsException;
import com.capg.ewallet.errors.AccountNotFoundException;
import com.capg.ewallet.errors.InvalidAmountException;
import com.capg.ewallet.model.TransferData;
import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.WalletTransaction;
import com.capg.ewallet.model.WalletTransactionList;
import com.capg.ewallet.model.WalletUser;
import com.capg.ewallet.service.AccountMsService;

@RestController
@CrossOrigin(origins= {"http://localhost:4200"})
@RequestMapping("/ewallet")

public class AccountMsController {

	@Autowired
	AccountMsService accountMsService;

	/**
	 * This method is used to adding amount to existing account.
	 * 
	 * @param accountId,accountBalance :This are the paramters to add the amount
	 *                                 into account
	 * @return WalletAccount : This returns the accountId,Balance an exception which
	 *         is handled globally
	 */

	@PostMapping("/users/addamount")

	public WalletAccount addAmount(@RequestBody WalletAccount walletAccount)
			throws AccountNotFoundException, InvalidAmountException {
		return accountMsService.addAmount(walletAccount);
	}

	@GetMapping("/public/getallaccount")

	public List<WalletAccount> getAllWalletAccount() throws AccountNotFoundException {
		return accountMsService.getAllWalletAccount();

	}

	
	@GetMapping("/users/getaccount/id/{accountId}")

	public WalletAccount getOneWalletAccount(@PathVariable int accountId) throws AccountNotFoundException {
		return accountMsService.getOneWalletAccount(accountId);

	}

	@GetMapping("/public/getalltransactions")
	public List<WalletTransaction> getAllWalletTransaction() {
		return accountMsService.getAllWalletTransaction().getWalletTransaction();
	}

	@GetMapping("/public/getonetransactions/id/{id}")
	public List<WalletTransaction> getOneWalletTransaction(@PathVariable("id") int accountId) {
		return accountMsService.getOneWalletTransaction(accountId);
	}

}
