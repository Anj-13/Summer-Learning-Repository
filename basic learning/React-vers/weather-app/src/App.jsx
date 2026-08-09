import { useEffect } from "react";
import SearchBar from "./components/SearchBar";
import WeatherCard from "./components/WeatherCard";
import ForecastCard from "./components/ForecastCard";
import FavouriteCities from "./components/FavouriteCities";
import { useWeather } from "./hooks/useWeather";
import { useFavorites } from "./hooks/useFavourites";

export default function App() {
  const { weather, isLoading, error, searchCity, clearError } = useWeather();
  const { favorites, addFavorite, removeFavorite, isFavorites } = useFavorites();

  // Vanilla app started with London already loaded
  useEffect(() => {
    searchCity("London");
  }, [searchCity]);

  const handleSearch = (city) => {
    searchCity(city);
  };

  const handleToggleFavorite = (city) => {
    if (isFavorites(city)) {
      removeFavorite(city);
    } else {
      addFavorite(city);
    }
  };

  const handleSelectFavorite = (city) => {
    searchCity(city);
  };

  const handleRemoveFavorite = (city) => {
    removeFavorite(city);
  };

  return (
    <div className="relative min-h-screen overflow-x-hidden font-sans text-ink">
      {/* Background layers sit behind content */}
      <div className="page-bg" aria-hidden="true" />
      <div className="ambient ambient-a" aria-hidden="true" />
      <div className="ambient ambient-b" aria-hidden="true" />
      <div className="ambient ambient-c" aria-hidden="true" />
      <div className="ambient ambient-d" aria-hidden="true" />

      <div className="relative z-10 mx-auto max-w-[1220px] px-2 py-2.5 sm:px-4 sm:py-10 lg:py-14">
        <main>
          <section className="panel grid grid-cols-1 items-center gap-3 p-3.5 sm:gap-7 sm:p-6 lg:grid-cols-[1.2fr_420px] lg:p-10">
            <div className="relative pt-1 sm:pt-2">
              <div className="mb-2 h-1.5 w-1.5 rounded-full bg-coral sm:mb-3.5 sm:h-2.5 sm:w-2.5" aria-hidden="true" />
              <h1 className="mb-2 text-[1.95rem] leading-none font-bold tracking-[-0.04em] sm:mb-4 sm:text-[2.8rem] lg:text-[5.1rem]">
                Weather App
              </h1>
              <p className="max-w-[560px] text-[0.86rem] leading-snug text-muted sm:text-base sm:leading-relaxed lg:text-[1.05rem]">
                Search any city, scan current conditions, save favourites locally,
                and preview a simple five-day outlook
              </p>
            </div>

            <SearchBar onSearch={handleSearch} isLoading={isLoading} />
          </section>

          {error && (
            <div
              className="mt-5 flex items-center justify-between rounded-2xl border border-coral/30 bg-coral/10 p-4 text-coral"
              role="alert"
            >
              <span className="font-semibold">{error}</span>
              <button
                type="button"
                onClick={clearError}
                className="text-2xl leading-none transition-opacity hover:opacity-70"
                aria-label="Dismiss error"
              >
                ×
              </button>
            </div>
          )}

          {/* Matches vanilla: weather + favourites side by side, forecast full-width below */}
          <section className="mt-2.5 grid grid-cols-1 gap-2.5 sm:mt-[22px] sm:gap-[22px] lg:grid-cols-[minmax(0,1.45fr)_minmax(280px,0.75fr)]">
            {isLoading && !weather ? (
              <div className="panel p-8 text-center text-muted">
                <p className="text-lg">Loading weather…</p>
              </div>
            ) : weather ? (
              <WeatherCard
                weather={weather}
                isFavorite={isFavorites(weather.city)}
                onToggleFavorite={handleToggleFavorite}
              />
            ) : (
              <div className="panel p-8 text-center text-muted">
                <p className="text-lg">Search for a city to see weather information</p>
              </div>
            )}

            <FavouriteCities
              favorites={favorites}
              onSelectCity={handleSelectFavorite}
              onRemoveCity={handleRemoveFavorite}
            />
          </section>

          {weather && <ForecastCard forecast={weather.forecast} />}
        </main>
      </div>
    </div>
  );
}
