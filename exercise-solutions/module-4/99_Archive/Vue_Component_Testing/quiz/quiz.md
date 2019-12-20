1. What is this test testing?

    ```javascript
    wrapper.find('select[name=role]').setValue('admin');
    wrapper.vm.role.should.equal('admin');
    ```

    a. Setting `admin` data property should change the `admin` text field
    b. Setting the `role` dropdown to `admin` should set the `role` data property to `admin` *
    c. An admin is allowed to change the `role` data property
    d. Setting the select to `role` should change the `admin` property to `role`

2. What is this test testing?

    ```javascript
    wrapper.setData({'sameAddress': true});
    wrapper.find('#billingAddress').exists().should.be.false;
    ```

    a. Setting `sameAddress` data property to `true` should show the `#billingAddress` element.
    b. Showing the `#billingAddress` element should set the `sameAddress` data property to true.
    c. Hiding the `#billingAddress` element should set the `sameAddress` property to true.
    d. Setting `sameAddress` data property to `true` should hide the `#billingAddress` element. *

3. What is this test testing?

    ```javascript
    wrapper.setData({'creditCardNumber': '6111111111111111'});
    wrapper.find('button[type=submit]').attributes().should.not.include.key('disabled');
    ```

    a. Setting the `creditCardNumber` field to a number should disable the submit button.
    b. Disabling the submit button should set the `creditCardNumber` field to 6111111111111111
    c. Setting the `creditCardNumber` field to a number should enable the submit button. *
    d. Enabling the submit button should set the `creditCardNumber` field to 6111111111111111

4. What is this test testing?

    ```javascript
    wrapper.setData({
        enabled: true
    });

    wrapper.vm.closeForm();

    // Check to make sure all the data got set back
    wrapper.vm.enabled.should.be.false;
    ```

    a. Setting the `enabled` data property to `true` should call the `closeForm()` method.
    b. Setting the `enabled` data property to `true` should actually set the `enabled` data property to `false`.
    c. Calling the `closeForm()` method should set the `enabled` data property to `false`. *
    d. Calling the `closeForm()` method should set the `enabled` data property to `true`.

5.  E2E testing stands for:

    a. Everything-to-everything testing
    b. Enterprise-to-enterprise testing
    c. End-to-end testing *
    d. Entegration testing
    c. ES6-to-ES5 testing

6.  End-to-end testing is testing that:

    a. verifies that the application is working as expected just by using the main interface of the application *
    b. tests the database and the interface, but none of the code in between
    c. tests each piece of the application individually so that we know it will work when used together
    d. tests just the interface and not any of the code behind it
    e. tests just the database part of the application