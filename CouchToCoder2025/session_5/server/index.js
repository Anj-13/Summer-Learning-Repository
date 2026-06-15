const express = require("express");
const app = express();
const port = 3001;

const fs = require("fs");
const path = require("path");

const cors = require("cors"); //cors package
app.use(cors()); // it would running the package cors

app.use(express.json());

const recipesFilePath = path.join(__dirname, "recipes.json");

app.get("/", (request, response) => {
    response.send("Hello World! home page"); // Send "Hello World!" as the response to GET requests at the root URL
});

app.get("/recipes", (request, response) => {
    // read in the json file to get the recipes
    fs.readFile(recipesFilePath, "utf-8", (err, data) => {
        /*we read in the file throught the filepath, encoding is added as secutiy measure
        * the err variable holds erros if there are any
        * data variable holds the data from the file
        */
        const recipes = JSON.parse(data); // Parse the JSON data from the file into a JavaScript object
        response.json(recipes); // Send the recipes array as a JSON response to GET requests at the /recipe URL

    })

});

app.post("/recipes", (request, response) => {

    const newRecipe = request.body;

    fs.readFile(recipesFilePath, 'utf8', (err, data) => {
        const recipes = JSON.parse(data); // Parse the existing JSON array 
        recipes.push(newRecipe); // Add the new object to the array 
        console.log(recipes)
        // Write the updated array back to the file 
        fs.writeFile(recipesFilePath, JSON.stringify(recipes), () => { });
    });
    response.send("Recipe added, storing your favourite dishes")
});

app.listen(port, () => {
    console.log("Server is running on on http://localhost:"+ port);
});

