# Weather App

A React weather dashboard for students, commuters, and travellers who want a fast, clean city weather view. This project ports the vanilla `WeatherApp/` MVP into a component-based React + Vite app with Tailwind CSS, following the vanilla → React plan (split UI into components, lift state into hooks, keep mock data behind a service layer).

## Features

- **Search City** — Enter a city name or tap a quick chip (London, Tokyo, Sydney) to load weather
- **View Current Weather** — Show temperature, condition, humidity, wind speed, and feels-like
- **Animate Conditions** — Drive the weather orb for sunny, cloudy, rainy, and stormy states
- **View 5-Day Forecast** — Render daily cards with temperature and condition
- **Save / Toggle Favourites** — Pin or unpin cities with LocalStorage; chips act as search shortcuts
- **Remove Favourites** — Delete a saved city from the favourites list
- **Validate Input** — Reject empty or invalid city names inside `SearchBar`
- **Show Loading / Errors** — `useWeather` loading state plus a dismissible error banner in `App`
- **Stay Responsive** — Stack layout on phones; side-by-side dashboard from `lg` breakpoints up

## Vanilla → React changes

| Vanilla (`WeatherApp/`) | React (`weather-app/`) |
| --- | --- |
| `index.html` sections | `App.jsx` + `src/components/*.jsx` |
| `styles.css` layout / cards | Tailwind utilities + shared `.panel` in `globals.css` |
| Orb + ambient motion CSS | Kept in `globals.css` (too motion-heavy for utilities alone) |
| `script.js` DOM queries / `renderWeather` | JSX props + React state re-renders |
| `let currentWeather` / favourites globals | `useWeather` + `useFavourites` hooks |
| Inline `weatherData` + `getWeather` | `utils/constants.ts` + `utils/formatWeather.ts` |
| Favourites LocalStorage helpers | `utils/favorites.ts` |
| No dedicated API boundary | `services/weatherApi.ts` (mock now; live API later) |
| Open `index.html` in a browser | `npm run dev` via Vite |

## UI

### Desktop (`lg` and up)

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

### Mobile (stacked)

```text
┌──────────────────────────┐
│ Weather App              │
│ Short hero copy          │
│ SEARCH CITY              │
│ [input] [Check]          │
│ [London][Tokyo][Sydney]  │
├──────────────────────────┤
│ CURRENT WEATHER          │
│ London      [Save city]  │
│ [orb] 21°C Cloudy        │
│ Humidity | Wind | Feels  │
├──────────────────────────┤
│ FAVOURITE CITIES         │
│ [London ×] [Tokyo ×] …   │
├──────────────────────────┤
│ 5-DAY FORECAST           │
│ [Mon][Tue]  (2-col grid) │
│ [Wed][Thu][Fri]          │
└──────────────────────────┘
```

Mobile layout notes:

- Hero + search stack in one column (`grid-cols-1` until `lg`)
- Weather card and favourites stack; forecast sits full-width below
- Forecast uses a 2-column grid on small screens, 5 columns from `sm` up
- Tighter padding / type scale on phones; orb shrinks under `max-width: 640px` in `globals.css`

| Screen / Component | File | Purpose |
| --- | --- | --- |
| Home page | `src/App.jsx` | Layout, ambient background, wires hooks to UI |
| Search bar | `src/components/SearchBar.jsx` | City input, quick chips, client validation |
| Weather card | `src/components/WeatherCard.jsx` | Current conditions + save toggle |
| Weather orb | `src/components/WeatherOrb.jsx` | Sunny / cloudy / rainy / stormy markup |
| Forecast section | `src/components/ForecastCard.jsx` | Five-day outlook |
| Favourites section | `src/components/FavouriteCities.jsx` | LocalStorage chips + remove |
| Error / loading UI | `src/App.jsx` + `useWeather` | Banner and loading panel |

## Data Model

| Field | Type | Description |
| --- | --- | --- |
| `city` | `string` | Display name of the selected city |
| `temperature` | `number` | Current temperature in °C |
| `condition` | `string` | Text label (e.g. Cloudy, Sunny) |
| `humidity` | `number` | Humidity percentage |
| `windSpeed` | `number` | Wind speed in km/h |
| `feelsLike` | `number` | Feels-like temperature in °C |
| `type` | `"sunny" \| "cloudy" \| "rainy" \| "stormy"` | Orb animation key |
| `forecast` | `{ day: string; temperature: number; condition: string }[]` | Five daily forecast entries |

Defined in `src/utils/formatWeather.ts`. Example:

```ts
const weather = {
  city: "London",
  temperature: 21,
  condition: "Cloudy",
  humidity: 70,
  windSpeed: 12,
  feelsLike: 20,
  type: "cloudy",
  forecast: [
    { day: "Mon", temperature: 21, condition: "Cloudy" },
    { day: "Tue", temperature: 19, condition: "Light rain" }
  ]
};
```

## File Storage Format

Favourites are stored in the browser as JSON under the key `weather-favourites`.

```json
["London", "Tokyo", "Sydney"]
```

- Delimiter / format: JSON array of city name strings
- Strategy: `localStorage.getItem` / `setItem` through `src/utils/favorites.ts`, exposed to the UI by `src/hooks/useFavourites.ts`

## Tech Stack

```text
Frontend: React 19 (JSX UI) + TypeScript hooks / utils / services
Bundler: Vite 7
Styling: Tailwind CSS v4 + globals.css (orb + ambient blobs)
Storage: LocalStorage
Data: Seeded / generated demo weather (live API not connected yet)
Deployment: Vite static build (Vercel later)
```

## API Used

No live weather API is connected yet. Weather comes from:

1. Seeded cities in `src/utils/constants.ts` (`london`, `tokyo`, `sydney`, `nairobi`, `paris`)
2. Deterministic generated data for other valid city names (`formatWeather.ts`)
3. `src/services/weatherApi.ts` as the fetch boundary (short mock delay today)

Planned next: OpenWeatherMap or WeatherAPI behind the same service file, with the key in an env variable such as `VITE_OPENWEATHER_API_KEY`.

## Project Structure

```text
weather-app/
  index.html
  package.json
  vite.config.js
  jsconfig.json
  postcss.config.mjs
  public/
    bg-gradient.svg
  src/
    main.jsx
    App.jsx
    globals.css
    components/
      SearchBar.jsx
      WeatherCard.jsx
      WeatherOrb.jsx
      ForecastCard.jsx
      FavouriteCities.jsx
    hooks/
      useWeather.ts
      useFavourites.ts
    services/
      weatherApi.ts
    utils/
      constants.ts
      formatWeather.ts
      favorites.ts
```

| Path | Purpose |
| --- | --- |
| `index.html` | Vite HTML shell + Inter font |
| `src/main.jsx` | `createRoot` entry; imports `globals.css` |
| `src/App.jsx` | Page composition, London initial load, error banner |
| `src/components/SearchBar.jsx` | Search form and quick-city chips |
| `src/components/WeatherCard.jsx` | Current weather + favourite toggle |
| `src/components/WeatherOrb.jsx` | Condition orb elements |
| `src/components/ForecastCard.jsx` | 5-day forecast panel |
| `src/components/FavouriteCities.jsx` | Favourites list and remove |
| `src/hooks/useWeather.ts` | Weather / loading / error state |
| `src/hooks/useFavourites.ts` | Favourites state synced to LocalStorage |
| `src/services/weatherApi.ts` | Weather data access (mock) |
| `src/utils/constants.ts` | Seeded city map + default favourites |
| `src/utils/formatWeather.ts` | Types, validation, get / generate weather |
| `src/utils/favorites.ts` | LocalStorage helpers |
| `src/globals.css` | Tailwind `@theme`, `.panel`, orb + ambient CSS, mobile orb rules |
| `public/bg-gradient.svg` | Soft page background |
| `vite.config.js` | React plugin + `@/` alias |
| `jsconfig.json` | Editor path alias for `@/*` |
| `postcss.config.mjs` | Tailwind PostCSS plugin |

## How to Run

**Prerequisites:** Node.js 18 or higher, and a modern browser (Chrome, Edge, Firefox, or Safari).

1. Open a terminal in the `weather-app` folder.
2. Install dependencies:

```bash
npm install
```

3. Start the development server:

```bash
npm run dev
```

4. Open the local URL shown in the terminal (usually `http://localhost:5173`).
5. Resize the browser or use device tools to check the stacked mobile layout.

Optional production commands:

```bash
npm run build
npm run preview
```

## Screenshots

React screenshots are not checked in yet. Add them under `Screenshot/` when ready:

- Homepage / desktop dashboard — *pending*
- Mobile stacked layout — *pending*

## Edge Cases Handled

- Empty search → validation message in `SearchBar`
- Invalid characters / too-short names → format error message
- Extra spaces around the city name → trimmed before lookup
- Duplicate favourite → add is a no-op in `favorites.ts`
- Unknown but valid city name → generated demo weather
- Empty favourites list → empty-state copy in `FavouriteCities`
- Page refresh → favourites remain via LocalStorage
- Service failure → dismissible error banner in `App`
- Narrow viewports → single-column stack + smaller orb / type

## Future Improvements

- Connect OpenWeatherMap or WeatherAPI in `weatherApi.ts`
- Hide API key in environment variables
- Treat unknown cities as errors when using a live API
- Add geolocation weather
- Add dark mode
- Add hourly forecast
- Add weather-based clothing advice
- Add weather alerts
- Capture desktop and mobile screenshots for this README
- Deploy on Vercel
- Optional later: move the Vite shell to Next.js App Router (keep components / hooks)

## Development Log

### [2026-08-02 19:55]

- **Done:**
  - Scaffolded React + Vite app beside vanilla `WeatherApp/`
  - Mapped HTML sections to components from the vanilla → React plan (`SearchBar`, `WeatherCard`, `ForecastCard`, `FavouriteCities`, `WeatherOrb`)
  - Moved data / favourites logic into `utils` + `hooks` + `services/weatherApi.ts`
- **In progress:**
  - Porting visual design from vanilla CSS into Tailwind
- **Left:**
  - Layout parity with vanilla dashboard
  - Ambient blob visibility
  - README for the React app

### [2026-08-02 20:20]

- **Done:**
  - Wired Tailwind v4 `@theme` tokens and `.panel` / `section-kicker` shared styles
  - Fixed dashboard grid so weather + favourites sit side by side and forecast is full-width below (vanilla layout)
  - Restored floating ambient blobs (z-index layering) and page background SVG
  - Added loading / error UI and London initial load via `useWeather`
- **In progress:**
  - Mobile compactness pass
- **Left:**
  - Docs cleanup
  - Live API

### [2026-08-02 21:20]

- **Done:**
  - Tuned mobile layout (stacked columns, smaller hero type, compact orb under 640px, forecast 2-col on phones)
  - Cleaned unused Next leftovers; kept Vite-only deps
  - Updated this README for the React tree, vanilla → React mapping, desktop + mobile UI, and development log
- **In progress:**
  - None for this documentation pass
- **Left:**
  - Live weather API + env key
  - React desktop / mobile screenshots
  - Deploy
