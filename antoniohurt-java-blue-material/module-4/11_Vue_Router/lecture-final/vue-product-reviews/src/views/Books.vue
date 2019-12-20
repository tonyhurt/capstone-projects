<template>
  <div class="books">
      <h1>Related Books</h1>
      <books-list />
  </div>
</template>

<script>
import BooksList from '@/components/BooksList.vue'

export default {
    name: 'books',
    components: {
        BooksList
    }
}
</script>

<style>
    .books {
        margin-top: 20px;
    }
</style>