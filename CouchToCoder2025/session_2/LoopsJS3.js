// loops is just having instruction with end
const numbers = [1,2,3,4,5,6,7,8,9];

// for (tempVar of numbers) { // sensible naming would be singular version of pural variable
//     console.log(tempVar);
// };

// for (tempVar of numbers) {
//     console.log(tempVar*2); // this is to show that we can modify code block in for loop
// };

/* it is a common practice to put the desired result
 * in a seperate array to get the result.
 */
// const evenNumbers = [];

// for (tempVar of numbers) {
//     if(tempVar % 2 === 0) {
//         evenNumbers.push(tempVar);
//     }
// };

// console.log(evenNumbers);

/* ************************************************** */
// loop through object
const employees = [
    {
        name: "John Doe",
        salary: 60000,
        department: "marketing"
    },
    {
        name: "Alice Cooper",
        salary: 75000,
        department: "engineering"
    },
    {
        name: "Seamus Finnigan",
        salary: 85000,
        department: "logistics"
    }
 ]

 for (employee of employees) {
    console.log(employee.name);
 }

 let total = 0;

 for (employee of employees) {
    total += employee.salary;
 }

 const average = total/ employees.length;
 const pplWithMoreThanAverageSalary = [];

 console.log(average);

 for(employee of employees) {
    if(employee.salary > average) {
        // console.log(employee.name, " has a salary more than the average")
        pplWithMoreThanAverageSalary.push(employee.name);
    }
 }

 console.log(pplWithMoreThanAverageSalary);