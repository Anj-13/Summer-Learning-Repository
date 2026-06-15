/* Objects helps with complexity of items
 * Objects are usually refer to or shown like this e.g Hashmap
 * This way we can use or reuse it in other languages
 * An object is individual thing with more data about a single thing,
    similar behavior but different way to exscute it.
*/
const employee = {
    firstName: "Test",
    lastName: "Thing",
    jobTitle: "Project Manager",
    salary: 60000,
    currentProjects: ["FacebookForCats", "AmazonButBetter", "Notflix", "InstaGram"]
};
/* "Key: value" left hand side would always be type of a string 
 * Object can use all different dataType and collections
 * It will have all the properties for us to interact
*/
// console.log(employee); // to print it out

// to access it is using [] and putting string value of the Key

// console.log(employee["firstName"]);

// or to use dot notation to access it

// console.log(employee.lastName);

// to modify the value by using similar way of arrays modification
employee.firstName = "Second";

// console.log(employee.firstName);

/******************************************** */

// it can even have a nested object in a const

const england = {
    population: 6000000,
    capital: {
        // nested object inside a object
        capital: "London",
        population: 1000000,
    }
};

// useful thing to assign a new value that is not in the object
employee.department = "engineering";
// we can use this way to put it in the object which would display in the print statement

// console.log(employee);
// to remove an item, it is using delete operator
// delete employee.salary

// Another way less common way is to use Object.keys() to look up
console.log(Object.keys(employee)); // to get arrays of keys