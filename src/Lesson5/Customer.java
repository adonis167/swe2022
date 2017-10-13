package Lesson5;

public class Customer {
    static class Deposit implements DepositRequest {

        private final Customer customer;
        private final Money money;
        private final Account account;

        Deposit(Customer c, Money m, Account a) {
            this.customer = c;
            this.money = m;
            this.account = a;
        }

        @Override
        public Account getDepositAccount() {
            return this.account;
        }

        @Override
        public Customer getCustomer() {
            return this.customer;
        }

        @Override
        public Money getMoney() {
            return this.money;
        }
    }
    public boolean deposit(Banker b, Currency c, int q) {
        return b.requestDeposit(new Deposit(this, new Money(c, q), new Account()));
    }
}
