package solid

import java.math.BigDecimal


/**** If a class B is subclass of class A then every object of A then every object of Class
a can we replaced with Class B . In layman terms a subclass should extend the parent capability
not narrow it down.  *****/


abstract class Account {
    abstract fun deposit(amount: BigDecimal?)

    /**
     * Reduces the balance of the account by the specified amount
     * provided given amount > 0 and account meets minimum available
     * balance criteria.
     *
     * @param amount
     */
    abstract fun withdraw(amount: BigDecimal?)
}

class BankingAppWithdrawalService(private val account: Account) {
    fun withdraw(amount: BigDecimal?) {
        account.withdraw(amount)
    }
}


class FixedTermDepositAccount : Account() {
    override fun deposit(amount: BigDecimal?) {
        // Deposit into this account
    }

    override fun withdraw(amount: BigDecimal?) {
        throw UnsupportedOperationException("Withdrawals are not supported by FixedTermDepositAccount!!")
    }
}


fun main() {
    val myFixedTermDepositAccount: Account = FixedTermDepositAccount()
    myFixedTermDepositAccount.deposit(BigDecimal(1000.00))

    val withdrawalService = BankingAppWithdrawalService(myFixedTermDepositAccount)
    withdrawalService.withdraw(BigDecimal(100.00))
}
