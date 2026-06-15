// arrays in JS is very flexible and dynamic in their size
// string, number, or boolean can be put in the arrays
const ingredients = ["chicken", "butter", "salt", "pepper"];

// to access the data in the arrays, is by using index
console.log(ingredients[0]);

ingredients[0] = "tofu"; // reassign variable
console.log(ingredients[0]);

ingredients.push("oregano"); // push will add the item at the end of the arrays
// alt+shift+down duplicate the line
ingredients.push("mozzarella");

const lastIngredients = ingredients.pop();
console.log(lastIngredients);