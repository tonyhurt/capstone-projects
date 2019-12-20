# Lecture Code Walkthrough

We're going to write tests for a component, namely the Todo List component that we saw in the last lecture. This component has a lot of moving parts to it and we want to make sure that we have tests in place to verify that it's working correctly.

Open the component in VSCode and show that it is complete. Run the `npm run serve` command and show that the component works.

Show that unit tests in Vue live in the `tests/unit` folder and are named after the component, `ProductReview.spec.js` in this example.

## Writing Unit Tests

We're going to write a number of unit tests. `ProductReview.spec.js` has a number of tests already written. You want each test to test one specific thing, and those things fall into roughly three categories: DOM changes, component data changes, and logic. A button click in the component might change all three of those aspects, but a test should only test one of those things at a time.

The first test `'should show a review on the UI'` is a test making sure that a change to the data is reflected in the DOM. So this is a DOM change test. In this test, we set the data for the `reviews` and then verify that the review shows up in the UI by selecting DOM elements and verifying their content.

The second test `'should filter reviews when filter is set'` is a test that makes sure the filter will properly limit which reviews are shown. Here again, we set the data on the component (this time both reviews and the filter) and make sure the DOM is updated properly again, only showing the reviews that match the filter.

The next two tests are testing the `showForm` toggle, the first testing that it properly show/hides the link for the toggle and the next that it properly show/hides the form itself. This is another DOM change test, since now we're making sure that elements on the screen are properly reacting to data changes.

The next test `'should fill out a newReview object when form is filled'` could be considered a data change test. Now we are setting values in the DOM and making sure that our component's data is properly updated.

We then have a `'Methods'` section, where we are specifically testing the logic in the methods of our application. Many of these tests follow a common pattern; set the data of the component, call the method, verify that the method did as desired.

First, we test `'should add a new review when addNewReview is called'`. In this test we set the `newReview` data property, call the `addNewReview()` method and then verify that the data was added to our `reviews` array.

Next, we test `'should clear the form and close the form when resetForm is called'`. Again, we're really just testing the side effects of the methods on the component's data, not that the DOM has been changed. That was already tested in the first group of tests.

We then have some tests for the `numberOfReviews()` method. Since we have multiple tests for this method, we can group them together in a `describe()` so that the display together in the results.

First, we test `'should return a proper count of reviews'` and make sure that the method returns the correct results. We also test it with `'should return 0 when there are no reviews'` to make sure that if there are no reviews at all that the method still works. This test was actually written because that bug was found in the code after it was written. This test was added so that the error could be fixed and verified that it wouldn't happen again in the future if something changed.

The next group of tests is testing the computed properties. These will be written in class. They are in the `final-lecture`. Testing computed properties is done by setting the underlying data property and then verifying the computed property is the correct value.

``` JavaScript
    it('should return only count of one star reviews from numberOfOneStarReviews', () => {
      wrapper.setData({ reviews: testReviews });
      wrapper.vm.numberOfOneStarReviews.should.equal(1);
    });
```

All tests are defined with the `it()` method. A description of the test is given as a string in the first argument and an anonymous method is the second argument, which is where our test code will live.

We can then test the computed properties by setting code:

``` javascript
      wrapper.setData({ reviews: testReviews });
```

And verifying the results:

``` javascript
      wrapper.vm.numberOfOneStarReviews.should.equal(1);
```

Work through the other computed properties to show how to test them.

``` javascript
    it('should return only count of two star reviews from numberOfTwoStarReviews', () => {
      wrapper.setData({ reviews: testReviews });
      wrapper.vm.numberOfTwoStarReviews.should.equal(2);
    });
    it('should return only count of three star reviews from numberOfThreeStarReviews', () => {
      wrapper.setData({ reviews: testReviews });
      wrapper.vm.numberOfThreeStarReviews.should.equal(3);
    });
    it('should return only count of four star reviews from numberOfFourStarReviews', () => {
      wrapper.setData({ reviews: testReviews });
      wrapper.vm.numberOfFourStarReviews.should.equal(0);
    });
    it('should return only count of five star reviews from numberOfFiveStarReviews', () => {
      wrapper.setData({ reviews: testReviews });
      wrapper.vm.numberOfFiveStarReviews.should.equal(2);
    });

    it('should have only filtered reviews in filteredReviews', () => {
      wrapper.setData({ reviews: testReviews, filter: 2 });
      wrapper.vm.filteredReviews.length.should.equal(2);
      wrapper.vm.filteredReviews[0].reviewer.should.equal('TEST3');
      wrapper.vm.filteredReviews[1].reviewer.should.equal('TEST5');
    });

    it('should have all reviews in filteredReviews when filter is zero', () => {
      wrapper.setData({ reviews: testReviews, filter: 0 });
      wrapper.vm.filteredReviews.length.should.equal(8);
    });

    it('should have average review total in averageRating', () => {
      wrapper.setData({
        reviews: [
          {
            reviewer: 'TEST1',
            rating: 1
          },
          {
            reviewer: 'TEST2',
            rating: 5
          }
        ]
      });

      wrapper.vm.averageRating.should.equal(3);
    });

    it('should have zero for averageRating if no reviews', () => {
      wrapper.setData({ reviews: [] });
      wrapper.vm.averageRating.should.equal(0);
    });
```