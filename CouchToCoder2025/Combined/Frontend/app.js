document.addEventListener("DOMContentLoaded", async () => {
   const response = await fetch("http://localhost:3003/recipes");
   const recipes = await response.json();
   for (let recipe of recipes) {
      // Create the container that will hold the recipe details
      const recipeList = document.querySelector("#recipe-list");
      // need put # to select by id

      const recipeContainer = document.createElement("div");
      // document is basically the counterpart of the entire HTML page
      /* 3 steps to create the page content:
         1. Create the elements
         2. give the element content
         3. Append it to the parent elements
      */
      // Create the name tag (h3), add text to it, glue it to the container
      const nameTag = document.createElement("h3");
      nameTag.innerText = recipe.name;
      // -------------------------------------------------------------------
      recipeContainer.appendChild(nameTag);
      // -------------------------------------------------------------------

      // Same with cuisine (p) and time (p)
      const cuisineTag = document.createElement("p");
      cuisineTag.innerText = recipe.cuisine;
      // -------------------------------------------------------------------
      recipeContainer.appendChild(cuisineTag);
      // -------------------------------------------------------------------

      const timeTag = document.createElement("p");
      timeTag.innerText = recipe.time;
      // -------------------------------------------------------------------
      recipeContainer.appendChild(timeTag);
      // -------------------------------------------------------------------

      const ingredientListTag = document.createElement("ul");
      for (let ingredient of recipe.ingredients) {
         const ingredientListItemTag = document.createElement("li");
         ingredientListItemTag.innerText = ingredient;
         ingredientListTag.appendChild(ingredientListItemTag);
      }

      recipeContainer.appendChild(ingredientListTag);
      // -------------------------------------------------------------------
      recipeContainer.appendChild(document.createElement("br"));
      // -------------------------------------------------------------------
      // Create the ordered list element for the steps of the recipes

      const stepListTag = document.createElement("ol");

      // Create the list item for the steps list
      for (let step of recipe.steps) {
         const stepListItemTag = document.createElement("li");
         stepListItemTag.innerText = step;
         stepListTag.appendChild(stepListItemTag);
      }

      // -------------------------------------------------------------------
      recipeContainer.appendChild(stepListTag);
      // -------------------------------------------------------------------

      recipeList.appendChild(recipeContainer);
   } // just to check the error

   // adding new recipe
   const newrecipeForm = document.querySelector("form");
   newrecipeForm.addEventListener("submit", (event) => {
      event.preventDefault();

      const newRecipe = {};

      newRecipe.name = event.target.name.value;
      newRecipe.cuisine = event.target.cuisine.value;
      newRecipe.time = event.target.time.value;

      const ingredientText = event.target.ingredients.value;
      newRecipe.ingredients = ingredientText.split(/\r?\n/);

      const stepsText = event.currentTarget.steps.value;
      newRecipe.steps = stepsText.split(/\r?\n/);

      fetch('http://localhost:3001/recipes', {
         method: 'POST', // Specify the request method 
         headers: {
            'Content-Type': 'application/json'  
         },
         body: JSON.stringify(newRecipe)
      })

   })

})

