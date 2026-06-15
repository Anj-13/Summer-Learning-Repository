// console.log("Hello World!");

// console.log(12+5*10);
// can use ctrl+click on toUpperCasse() to see the method
// console.log("hello world!".toUpperCase());

let message = "hello world".toUpperCase();
// tab to autocomplete
console.log(message);
// const is a constant variable  

const firstName = "first";
const lastName = "lastnameinsert";
const fullName = firstName + " " + lastName;

const num1 = 9;
const num2 = 9;
const result = num1 + num2;

console.log(fullName + "\n" + result);

console.log((14 > 12) && "cat" === "cat"); // 3 equal sign is better

// control flow = boolean/conditional operation
let age = 18;
if (age >= 18) {
    console.log("yes");
} else if (age < 10) {
    console.log("wait for few year grasshopper...");
} else {
    console.log("no");
}

let age2 = 13;
const haveParentConsent = true;
if (age >= 18) {
    console.log("yes");
} else if (age <= 18 && haveParentConsent) {
    console.log("yes with consent");
} else {
    console.log("no");
}

if (age >= 18 || haveParentConsent) {
    console.log("can apply");
}
// camel casing is used for variable e.g. lowerUppercaseAtTheStartS

// Lesson 1: finished 