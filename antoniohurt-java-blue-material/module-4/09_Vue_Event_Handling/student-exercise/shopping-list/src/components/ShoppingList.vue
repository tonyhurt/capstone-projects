<template>
    <div class="shopping-list">
        <h1>My Shopping List</h1>
        <ul>
            <li v-for="item in groceries" v-bind:key="item.name" v-bind:class="{ completed: item.completed }">
                    <input type="checkbox" @click="changeStatus(item.name)"/>

                {{item.name}} 
                <i class="far fa-check-circle" v-bind:class="{ completed: item.completed }"></i>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
    data() {
    return {
        groceries: [
            { item: 1, name: 'Oatmeal', completed: false },
            { item: 2, name: 'Milk', completed: false },
            { item: 3, name: 'Bananas', completed: false },
            { item: 4, name: 'Strawberries', completed: false },
            { item: 5, name: 'Turkey', completed: false },
            { item: 6, name: 'Bread', completed: false },
            { item: 7, name: 'Water', completed: false },
            
        ]
    }
    },
    methods: {

    }
}
</script>

<style>
.shopping-list {
    width:450px;
    background: #fff;
    margin: 50px auto;
    font-family: 'Roboto Condensed', sans-serif;
    border-radius: 10px;
}
h1 {
    background:#f2f2f2;
    color:#5c8578;
    padding:10px;
    font-size:24px;
    text-transform: uppercase;
    text-align: center;
    margin-bottom: 0px;
    border-top-left-radius: 10px;
    border-top-right-radius: 10px;
}
ul {
    list-style-type: none;
    margin:0px;
    padding:0px;
}
li {
    font-size: 24px;
    border-bottom:1px solid #f2f2f2;
    padding:10px 20px;
}
li:last-child{
    border:0px;
}
li.completed {
    text-decoration: line-through;
    color:darkgrey;
}
i.far.fa-check-circle { 
    float:right;
    color: darkgray;
}

i.far.fa-check-circle.completed {
    color:green;
}
input[type="checkbox"] {
    font-size:40px;
    vertical-align: middle;
    margin-top:0px;
}
</style>
