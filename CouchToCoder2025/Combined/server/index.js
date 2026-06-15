const express = require("express");
const app = express();
const port = 3003;

const fs = require("fs");
const path = require("path");

const cors = require("cors"); 
app.use(cors());

app.use(express.json());

const recipesFilePath = path.join(__dirname, "CombinrRecipes.json");

app.get("/", (request, response) => {
    response.send("Hello World! home page");
});

app.get("/recipes", (request, response) => {
    
    fs.readFile(recipesFilePath, "utf-8", (err, data) => {
        const recipes = JSON.parse(data);
        response.json(recipes);

    })

});

app.post("/recipes", (request, response) => {

    const newRecipe = request.body;

    fs.readFile(recipesFilePath, 'utf8', (err, data) => {
        const recipes = JSON.parse(data);
        recipes.push(newRecipe);
        console.log(recipes)
        
        fs.writeFile(recipesFilePath, JSON.stringify(recipes), () => { });
    });
    response.send("Recipe added, storing your favourite dishes")
});

app.get("/cuisine-data", (request, response) => {
    fs.readFile(recipesFilePath, 'utf8', (err, data) => {
        const recipes = JSON.parse(data);
        const counts = recipes.reduce((accumulator, recipe) => {
            const currentCuisine = recipe.cuisine;
            if (accumulator[currentCuisine]) {
                accumulator[currentCuisine] = accumulator[currentCuisine] + 1;
            }
            else {
                accumulator[currentCuisine] = 1;
            }
            return accumulator;
        }, {});
        console.log(counts);
        response.json(counts);
    });
});

app.listen(port, () => {
    console.log("Server is running on on http://localhost:" + port);
});

