﻿using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using BankTellerExercise.Classes;

namespace BankTellerExerciseTests.Classes
{
    [TestClass]
    public class BankCustomerTests
    {
        [TestMethod]
        public void NewCustomerHasNoAccounts()
        {
            BankCustomer customer = new BankCustomer();

            Assert.AreEqual(0, customer.Accounts.Length);
        }

        [TestMethod]
        public void CustomerAddAccount()
        {
            BankCustomer customer = new BankCustomer();

            Assert.AreEqual(0, customer.Accounts.Length);

            customer.AddAccount(new BankAccount("", ""));

            Assert.AreEqual(1, customer.Accounts.Length);
        }

        [TestMethod]
        public void BalancesLessThan25K_NotVIP()
        {
            BankCustomer customer = new BankCustomer();

            BankAccount thousandAccount = new BankAccount("","", 1000M); //$1000
            BankAccount twentyFourThousandAcct = new BankAccount("", "", 24000M);

            customer.AddAccount(thousandAccount);
            Assert.IsFalse(customer.IsVip);

            customer.AddAccount(twentyFourThousandAcct);
            Assert.IsTrue(customer.IsVip);
        }
    }
}
