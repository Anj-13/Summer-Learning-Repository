# Weather App

A browser-based weather dashboard for students, commuters, and travellers who want a fast, clean city weather view without opening a full weather site.

## Features

- **Search City** — Enter a city name or tap a quick chip (London, Tokyo, Sydney) to load weather
- **View Current Weather** — Show temperature, condition, humidity, wind speed, and feels-like
- **Animate Conditions** — Update the weather orb for sunny, cloudy, rainy, and stormy states
- **View 5-Day Forecast** — Display daily cards with temperature and condition
- **Save Favourites** — Pin cities with LocalStorage and reopen them as search shortcuts
- **Remove Favourites** — Delete a saved city from the favourites list
- **Validate Input** — Reject empty searches and invalid city-name formats with a status message
- **Stay Responsive** — Keep the layout readable on desktop and mobile widths



## UI

```text
┌─────────────────────────────────────────────────────────────┐
│  Weather App                         SEARCH CITY            │
│  Search any city, scan current…      [Try London, Tokyo] [Check]
│                                      [London] [Tokyo] [Sydney]  │
├──────────────────────────────┬──────────────────────────────┤
│  CURRENT WEATHER             │  LOCALSTORAGE                │
│  London          [Save city] │  Favourite cities            │
│  Saturday, …                 │  [London ×] [Tokyo ×] …      │
│  [orb]  21°C  Cloudy         │  Favourite chips behave like │
│  Humidity | Wind | Feels like│  quick search shortcuts.     │
├──────────────────────────────┴──────────────────────────────┤
│  PLANNING VIEW — 5-day forecast                             │
│  [Mon 21°] [Tue 19°] [Wed 23°] [Thu 22°] [Fri 18°]          │
└─────────────────────────────────────────────────────────────┘
```


| Screen / Component | Purpose                                           |
| ------------------ | ------------------------------------------------- |
| Home page          | Search a city and show the weather result         |
| Search bar         | User enters a city name and submits               |
| Weather card       | Current temperature, condition, and animated icon |
| Forecast section   | Daily forecast cards                              |
| Favourites section | Saved cities (LocalStorage)                       |
| Status message     | Validation feedback for empty or invalid input    |




## Data Model


| Field         | Type                              | Description                                             |
| ------------- | --------------------------------- | ------------------------------------------------------- |
| `city`        | `string`                          | Display name of the selected city                       |
| `temperature` | `number`                          | Current temperature in °C                               |
| `condition`   | `string`                          | Text label (e.g. Cloudy, Sunny)                         |
| `humidity`    | `number`                          | Humidity percentage                                     |
| `windSpeed`   | `number`                          | Wind speed in km/h                                      |
| `feelsLike`   | `number`                          | Feels-like temperature in °C                            |
| `type`        | `string`                          | Orb animation key: `sunny`, `cloudy`, `rainy`, `stormy` |
| `forecast`    | `Array<[string, number, string]>` | Five days: `[day, temp, condition]`                     |


Example shape:

```js
const weather = {
  city: "London",
  temperature: 21,
  condition: "Cloudy",
  humidity: 70,
  windSpeed: 12,
  feelsLike: 20,
  type: "cloudy",
  forecast: [
    ["Mon", 21, "Cloudy"],
    ["Tue", 19, "Light rain"]
  ]
};
```



## File Storage Format

Favourites are stored in the browser as JSON under the key `weather-favourites`.

```json
["London", "Tokyo", "Sydney"]
```

- Delimiter / format: JSON array of city name strings
- Strategy: `localStorage.getItem` / `setItem` on load, save, and remove



## Tech Stack

```text
Frontend: HTML, CSS, JavaScript (vanilla)
Styling: Custom CSS (Figma-aligned dashboard)
Storage: LocalStorage
Data: Demo / seeded city data (no live API yet)
Deployment: Open index.html locally
```

> The planning doc (`WeatherAppBasic.md`) targets React / Next.js, Tailwind, and OpenWeatherMap or WeatherAPI. This folder is the vanilla MVP UI;



## API Used

No live weather API is connected yet. Weather comes from:

1. Seeded cities in `script.js` (`london`, `tokyo`, `sydney`, `nairobi`, `paris`)
2. Deterministic generated data for other valid city names

Planned for a later iteration: OpenWeatherMap or WeatherAPI, with the API key kept in environment variables.

## Project Structure


| Path                     | Purpose                                                      |
| ------------------------ | ------------------------------------------------------------ |
| `index.html`             | Page shell: hero, search, weather card, favourites, forecast |
| `styles.css`             | Layout, tokens, responsive rules, orb / ambient animations   |
| `script.js`              | Search, render, favourites, mock weather data                |
| `assets/bg-gradient.svg` | Soft page background gradient                                |
| `assets/weather-orb.svg` | Optional orb artwork asset                                   |
| `WeatherAppBasic.md`     | basicPlan / discovery and build checklist                    |




## How to Run

**Prerequisites:** A modern browser (Chrome, Edge, Firefox, or Safari).

1. Open the project folder `WeatherApp`.
2. Open `index.html` in the browser
  (double-click, or use a simple local server if you prefer).

Optional local server from the repo root:

```bash
cd WeatherApp
npx --yes serve .
```

Then open the URL printed in the terminal (often `http://localhost:3000`).

## Screenshots



### Homepage / dashboard

Weather App homepage dashboard

### Mobile layout

Weather App mobile layout

## Edge Cases Handled

- Empty search → validation message asking for a city name
- Invalid characters / too-short names → format error message
- Extra spaces around the city name → trimmed before lookup
- Duplicate favourite → blocked with a status message
- Unknown but valid city name → generated demo weather (not a hard “city not found” error yet)
- Empty favourites list → empty-state copy is shown
- Page refresh → favourites remain via LocalStorage



## Future Improvements

- Connect OpenWeatherMap or WeatherAPI
- Add loading and API failure states
- Treat unknown cities as errors when using a live API
- Add geolocation weather
- Add dark mode
- Add hourly forecast
- Add weather-based clothing advice
- Add weather alerts
- Deploy on Vercel and link from a portfolio
- Port / align fully with React + Tailwind (see sibling `weather-app/`)



## Development Log



### [2026-07-18 18:30]

- **Done:**
  - Built single-page dashboard UI from Figma nodes (hero, search, weather card, favourites, forecast)
  - Added seeded city data, search validation, and LocalStorage favourites
  - Wired CSS weather-orb animations and ambient background motion
- **In progress:**
  - Polishing condition animations (sunny / cloudy / rainy)
- **Left:**
  - Live weather API
  - Loading / API error states
  - README and deployment checklist items



### [2026-07-21 09:40]

- **Done:**
  - Restored CSS-based sunny / cloudy / rainy / stormy orb animations (static SVG had broken sunny/cloudy motion)
  - Compared implementation against `WeatherAppBasic.md` MVP checklist
- **In progress:**
  - Documenting the vanilla MVP
- **Left:**
  - README (this file)
  - Real API + env-based keys



### [2026-08-02 20:45]

- **Done:**
  - Added `README.md` from `WeatherAppBasic.md` scope and `Template.md` structure
  - Embedded homepage and mobile screenshots from `Screenshot/`
- **In progress:**
  - None for this vanilla folder doc pass
- **Left:**
  - OpenWeatherMap / WeatherAPI integration
  - Hide API key in environment variables

