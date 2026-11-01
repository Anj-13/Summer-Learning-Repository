const weatherData = {
  london: {
    city: "London",
    temperature: 21,
    condition: "Cloudy",
    humidity: 70,
    windSpeed: 12,
    feelsLike: 20,
    type: "cloudy",
    forecast: [
      ["Mon", 21, "Cloudy"],
      ["Tue", 19, "Light rain"],
      ["Wed", 23, "Sunny"],
      ["Thu", 22, "Cloudy"],
      ["Fri", 18, "Rain"]
    ]
  },
  tokyo: {
    city: "Tokyo",
    temperature: 29,
    condition: "Sunny",
    humidity: 58,
    windSpeed: 9,
    feelsLike: 31,
    type: "sunny",
    forecast: [
      ["Mon", 29, "Sunny"],
      ["Tue", 30, "Sunny"],
      ["Wed", 27, "Cloudy"],
      ["Thu", 26, "Rain"],
      ["Fri", 28, "Clear"]
    ]
  },
  sydney: {
    city: "Sydney",
    temperature: 18,
    condition: "Light rain",
    humidity: 76,
    windSpeed: 17,
    feelsLike: 17,
    type: "rainy",
    forecast: [
      ["Mon", 18, "Rain"],
      ["Tue", 20, "Cloudy"],
      ["Wed", 21, "Sunny"],
      ["Thu", 19, "Breezy"],
      ["Fri", 22, "Clear"]
    ]
  },
  nairobi: {
    city: "Nairobi",
    temperature: 24,
    condition: "Sunny",
    humidity: 46,
    windSpeed: 10,
    feelsLike: 24,
    type: "sunny",
    forecast: [
      ["Mon", 24, "Sunny"],
      ["Tue", 25, "Clear"],
      ["Wed", 23, "Cloudy"],
      ["Thu", 24, "Sunny"],
      ["Fri", 22, "Rain"]
    ]
  },
  paris: {
    city: "Paris",
    temperature: 22,
    condition: "Cloudy",
    humidity: 62,
    windSpeed: 11,
    feelsLike: 21,
    type: "cloudy",
    forecast: [
      ["Mon", 22, "Cloudy"],
      ["Tue", 24, "Sunny"],
      ["Wed", 21, "Rain"],
      ["Thu", 19, "Cloudy"],
      ["Fri", 23, "Sunny"]
    ]
  }
};

const elements = {
  form: document.querySelector("#searchForm"),
  input: document.querySelector("#cityInput"),
  message: document.querySelector("#message"),
  city: document.querySelector("#weatherCity"),
  date: document.querySelector("#weatherDate"),
  temperature: document.querySelector("#temperature"),
  condition: document.querySelector("#condition"),
  humidity: document.querySelector("#humidity"),
  windSpeed: document.querySelector("#windSpeed"),
  feelsLike: document.querySelector("#feelsLike"),
  forecast: document.querySelector("#forecastGrid"),
  save: document.querySelector("#saveFavourite"),
  favourites: document.querySelector("#favouritesList"),
  empty: document.querySelector("#emptyFavourites"),
  orb: document.querySelector("#weatherOrb")
};

let currentWeather = weatherData.london;
const storedFavourites = localStorage.getItem("weather-favourites");
let favourites = storedFavourites
  ? JSON.parse(storedFavourites)
  : ["London", "Tokyo", "Sydney"];

if (!storedFavourites) {
  localStorage.setItem("weather-favourites", JSON.stringify(favourites));
}

function titleCase(value) {
  return value
    .trim()
    .toLowerCase()
    .split(/\s+/)
    .map(word => word.charAt(0).toUpperCase() + word.slice(1))
    .join(" ");
}

function generatedWeather(city) {
  const seed = [...city].reduce((total, letter) => total + letter.charCodeAt(0), 0);
  const conditions = [
    { label: "Sunny", type: "sunny" },
    { label: "Cloudy", type: "cloudy" },
    { label: "Light rain", type: "rainy" },
    { label: "Storm clouds", type: "stormy" }
  ];
  const picked = conditions[seed % conditions.length];
  const base = 14 + (seed % 18);
  const days = ["Mon", "Tue", "Wed", "Thu", "Fri"];

  return {
    city,
    temperature: base,
    condition: picked.label,
    humidity: 42 + (seed % 45),
    windSpeed: 6 + (seed % 20),
    feelsLike: base + ((seed % 5) - 2),
    type: picked.type,
    forecast: days.map((day, index) => {
      const condition = conditions[(seed + index) % conditions.length].label;
      return [day, base + ((index % 3) - 1), condition];
    })
  };
}

function getWeather(cityName) {
  const normalized = cityName.trim().toLowerCase();
  return weatherData[normalized] || generatedWeather(titleCase(cityName));
}

function setMessage(text, type = "error") {
  elements.message.textContent = text;
  elements.message.style.color = type === "success" ? "#0d7d8f" : "#ef6f5e";
}

function renderWeather(weather) {
  currentWeather = weather;
  elements.city.textContent = weather.city;
  elements.date.textContent = new Intl.DateTimeFormat("en", {
    weekday: "long",
    month: "long",
    day: "numeric"
  }).format(new Date());
  elements.temperature.textContent = weather.temperature;
  elements.condition.textContent = weather.condition;
  elements.humidity.textContent = `${weather.humidity}%`;
  elements.windSpeed.textContent = `${weather.windSpeed} km/h`;
  elements.feelsLike.textContent = `${weather.feelsLike}°C`;
  elements.orb.className = `weather-orb ${weather.type}`;
  elements.save.textContent = favourites.includes(weather.city) ? "Saved" : "Save city";

  elements.forecast.innerHTML = weather.forecast
    .map(([day, temp, condition], index) => {
      const accents = ["#8fd6e8", "#f7c948", "#ef6f5e", "#b7d66d", "#0d7d8f"];
      return `
        <article class="forecast-card" style="--accent: ${accents[index]}">
          <span>${day}</span>
          <strong>${temp}°</strong>
          <p>${condition}</p>
          <div class="mini-line" aria-hidden="true"><i></i><i></i><i></i><i></i></div>
        </article>
      `;
    })
    .join("");
}

function saveFavourites() {
  localStorage.setItem("weather-favourites", JSON.stringify(favourites));
}

function renderFavourites() {
  elements.favourites.innerHTML = "";
  elements.empty.style.display = favourites.length ? "none" : "block";

  favourites.forEach(city => {
    const pill = document.createElement("button");
    pill.className = "favourite-pill";
    pill.type = "button";
    pill.dataset.city = city;
    pill.innerHTML = `<span>${city}</span><span class="remove" aria-label="Remove ${city}">×</span>`;
    elements.favourites.appendChild(pill);
  });
}

function handleSearch(cityName) {
  const city = cityName.trim();

  if (!city) {
    setMessage("Please enter a city name.");
    return;
  }

  if (!/^[a-zA-Z\s.-]{2,}$/.test(city)) {
    setMessage("Use a valid city name with letters, spaces, periods, or hyphens.");
    return;
  }

  const weather = getWeather(city);
  renderWeather(weather);
  setMessage(`${weather.city} weather loaded.`, "success");
}

elements.form.addEventListener("submit", event => {
  event.preventDefault();
  handleSearch(elements.input.value);
});

document.querySelectorAll("[data-city]").forEach(button => {
  button.addEventListener("click", () => {
    elements.input.value = button.dataset.city;
    handleSearch(button.dataset.city);
  });
});

elements.save.addEventListener("click", () => {
  if (favourites.includes(currentWeather.city)) {
    setMessage(`${currentWeather.city} is already saved.`, "success");
    return;
  }

  favourites = [currentWeather.city, ...favourites].slice(0, 8);
  saveFavourites();
  renderFavourites();
  renderWeather(currentWeather);
  setMessage(`${currentWeather.city} added to favourites.`, "success");
});

elements.favourites.addEventListener("click", event => {
  const pill = event.target.closest(".favourite-pill");
  if (!pill) return;

  if (event.target.classList.contains("remove")) {
    favourites = favourites.filter(city => city !== pill.dataset.city);
    saveFavourites();
    renderFavourites();
    renderWeather(currentWeather);
    setMessage(`${pill.dataset.city} removed from favourites.`, "success");
    return;
  }

  elements.input.value = pill.dataset.city;
  handleSearch(pill.dataset.city);
});

renderWeather(currentWeather);
renderFavourites();
