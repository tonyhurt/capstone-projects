/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils'
import ShoppingList from '@/components/ShoppingList.vue'
import chai from 'chai';
chai.should()

describe('ShoppingList.vue', () => {
  
    /** @type Wrapper */
    let wrapper;

    beforeEach( () => {
        wrapper = shallowMount(ShoppingList);
    });

    it('should be a Vue instance', () => {
        wrapper.isVueInstance().should.be.true;
    });

    it('should render an unordered list', () => {
      wrapper.find('ul').should.exist;
    });

    it('should render a list with more than 1 item', () => {
      wrapper.findAll('li').length.should.greaterThan(1);
    });

    it('should render a list that contains at least 1 item with the class completed', () => {
      wrapper.findAll('li.completed').length.should.greaterThan(0);
    });

})
