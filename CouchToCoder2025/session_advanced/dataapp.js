async function loadChart() {
    try {
        const cuisineResponse = await fetch("http://localhost:3002/cuisine-data");
        const cuisineData = await cuisineResponse.json();

        const xValues = Object.keys(cuisineData);
        const yValues = Object.values(cuisineData);

        // optionally we can use colours here 
        new Chart("myChart", {
            type: "pie",
            data: {
                labels: xValues,
                datasets: [{
                    data: yValues
                }]
            },
            options: {
                title: {
                    display: true,
                    text: "Cuisine Popularity"
                }
            }
        });
    } catch (error) {
        console.error("Error loading chart: ", error);
    }
}

loadChart();

