# INSERT, UPDATE, DELETE, Transactions, Constraints, and Referential Integrity

## Problem Statement

Today we will learn how to use INSERT, UPDATE, and DELETE statements.

## Lesson  Objectives

- Inserts
- Deletes
- Updates
- Constraints and referential integrity
- Transactions

## Notes and Examples


### **INSERT**

```
INSERT INTO table_name (column1, column2, ..., column_n)
VALUES (value1, value2, ... value_n);

INSERT INTO table_name VALUES (value1, value2, ... value_n);
```


### **UPDATE**

```
UPDATE table_name
SET column = value
WHERE column = value;
```

- *What could happen if we update without the where clause?*

### **DELETE**

```sql
DELETE FROM table_name
WHERE column=value;
```

- *What could happen if we delete without the where clause?*

<div class="caution note">Don't forget the WHERE clause!!! It can have disastrous consequences.</div>



### **Referential Integrity**
- We learned that databases can have relationships established between tables using primary and foreign keys.

<div class="definition note">

**Referential integrity** ensures that relationships between tables remain consistent.</div>

- We enforce referential integrity and other rules by applying constraints to our tables.

### Table Constraints

<div class="definition note">

A **constraint** is associated with a table and defines properties that the column data must comply with.</div>

- Types of Constraints
	1. **NOT NULL**
	2. **UNIQUE**
	3. **PRIMARY KEY** - allows FKs to establish a relationship, and enforces NOT NULL and UNIQUE,
	4. **FOREIGN KEY** - enforces valid PK values, and limits deletion of the PK row if FK row exists
	5. **CHECK** - specifies acceptable values that can be entered in the column
	6. **DEFAULT** - provides a default value for the column


### **TRANSACTION**

- If we make multiple INSERT, UPDATE, or DELETE statements and want them to be considered as an *all or nothing*, then we consider it a **transaction**.

<div class="definition note">

A **transaction** is a single unit of work. When it is successful, it should be "committed". If an error is encountered at any point it should be cancelled or **rolled back**.</div>

<div class="analogy note">If we transfer money from one bank account to another and there's a failure depositing it after it withdraws, we wouldn't want our account to be out the money too.</div>

- **The ACID Test** to determine whether a series of actions is a transaction, they need to have the following characteristics.
	1. **A**tomicity: Within a transaction, a series of database operations all occur or none occur.
		- A withdrawl from savings should not recorded unless the deposit to checking was successful.
	2. **C**onsistency: The completed transaction leaves things remaining in a consistent state at the end. Any rules in place before the transaction still pass after the transaction.
		- $100 cannot be withdrawn from one account and never deposited to the other account. The consistency (balance) before the transaction must be the same after the transaction.
	3. **I**solation: Ensures that the concurrent execution of a transaction results as if the operations were executed serially.
		- Prevents two customers from transferring the same $100 at the same time.
		- If two customers transfer the same $ from their account to their friend's account concurrently, the database should treat them as sequential operations.
		- A typical system will revert to the last known good state.
	4. **D**urability: Once a transaction has been committed it will remain so, even during a power loss, crash, or an error.
		- This is generally handled through journaling.

**Postgres**
```
START TRANSACTION

COMMIT

ROLLBACK
```

**MS SQL**
```
BEGIN TRANSACTION

COMMIT TRANSACTION

ROLLBACK TRANSACTION
```
