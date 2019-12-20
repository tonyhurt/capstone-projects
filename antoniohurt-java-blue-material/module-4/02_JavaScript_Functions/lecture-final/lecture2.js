function greeting() {
    console.log("Hello World");
}

/* Spread Operator Example */
function multipleNumbers(x, y, z) {
    return x * y * z;
}

const args = [1, 2, 3];

console.log( multipleNumbers(...args) );

const args2 = [1, 2, 3, 4, 5, 6, 7];

console.log( multipleNumbers(...args2) );

function addLetters(a, b, c, d) {
    console.log(a + b + c + d);
}

const str = "Hello";
addLetters(...str);

/*
 Anonymous Functions
*/

const doubleSum = function (x, y) {
    const val = (x + y) * 2;
    return val;
}
console.log('Double: ' + doubleSum(2, 4) );
const x = doubleSum;

console.log('X: ' + x(5, 6) );

const tripleSum = (x, y) => {
    const val = (x + y) * 3;
    return val;
}
console.log("Triple: " + tripleSum(2, 3));

/*
    Array Reduce
*/
const arr = [1, 2, 3, 4, 5,6, 7, 8, 9, 10];

const sum = arr.reduce( (sum, value) => {
    return sum + value;
});

console.log(`Sum = ${sum}`);

/*
    Long form code that shows reduce is doing
*/
function sumAllNumbers(numbersToSum) {
    let sum = 0;
    for (let i = 0; i < numbersToSum.length; i++) {
        sum += numbersToSum[i];
    }
    return sum;
}

console.log(`Sum long way = ${sumAllNumbers(arr)}`);

const stringArr = ["Hello ", "John, ", "Andrew, ", "Steve ", "and Rachelle"];

const reducedStr = stringArr.reduce ( (sum, value) => {
    return sum + value;
});
console.log(reducedStr);

const reduceFunc = (sum, value) => { return sum + value; };
console.log( arr.reduce (reduceFunc) );
console.log( stringArr.reduce (reduceFunc) );

/* 
    Filter Examples
*/
const longNames = stringArr.filter ( (name) => {
    return name.length > 7;
});
console.table(longNames);

/*
    Map Examples
*/
let doubledArr = arr.map( (number) => {
    return number * 2;
});
console.table(doubledArr);

const longMapNames = stringArr.map ( name => {
    if (name.length > 7) {
        return name + " AAAA";
    } else {
        return '';
    }
});
console.table(longMapNames);


/*
    Anonymous Functions in our methods
*/

function doMath(x, y, func) {
    const result = func(x, y);
    console.log("The result is " + result);
}

doMath(2, 4, (x, y) => {return x + y; });
doMath(2, 4, (x, y) => {return x / y; });
doMath(2, 4, (x, y) => {return x - y; });
doMath(-20, 5, (x, y) => {
    const absDistance = Math.abs(x - y);
    const power3 = Math.pow(absDistance, 3);
    return power3;
});


function filterThenMap(array, filterFunc) {
    return array.filter(filterFunc).map( (num) => {
        return 'A' + num;
    });
}

console.table( filterThenMap(arr, (val) => { return val % 2 === 0 }) );
console.table( filterThenMap(arr, (val) => { return val % 2 !== 0 }) );


console.table ( stringArr.reduceRight( (sum, value) => {
    return sum += value;
})
);

const names = ['John', 'Andrew', 'Steve', 'Carson', 'Rachelle'];
const namesOutput = names.reduce( (sum, val, i, array) => {
    return `${sum}, ${(i == array.length - 1) ? "and " : ""}${val}`;
}); 
console.table(namesOutput);

const namesOutputSimple = names.reduce( (sum, val, i, array) => {
    let retStr = sum + ", ";
    if (i == array.length - 1) {
        retStr += "and ";
    }
    retStr += val;
    return retStr;
});
console.table(namesOutput);
