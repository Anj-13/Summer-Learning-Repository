const recipeList = document.querySelector("ul");

const titleTag = document.createElement("h1");
titleTag.textContent = "Spaghetti Carbonara";
const timeTag = document.createElement("p");
timeTag.textContent = "Time: 30";
const cuisineTag = document.createElement("p");
cuisineTag.textContent = "Cuisine: Italian"
const ingredientListTag = document.createElement("ul");
const ingredientListElementTag = document.createElement("li");
ingredientListElementTag.textContent = "Get all ingredients";
ingredientListTag.appendChild(ingredientListElementTag);

const stepListTag = document.createElement("ul");
const stepListElementTag = document.createElement("li");
stepListElementTag.textContent = "Do all the steps";
stepListTag.appendChild(stepListElementTag);

const recipe = document.createElement("div");
recipe.appendChild(titleTag)
recipe.appendChild(timeTag)
recipe.appendChild(cuisineTag)
recipe.appendChild(ingredientListTag)
recipe.appendChild(stepListTag)


recipeList.appendChild(recipe) 