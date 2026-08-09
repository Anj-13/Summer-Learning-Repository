import { useState } from "react";

const QUICK_CITIES = ["London", "Tokyo", "Sydney"];

export default function SearchBar({ onSearch, isLoading }) {
  const [city, setCity] = useState("");
  const [error, setError] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    const trimmed = city.trim();

    if (!trimmed) {
      setError("Please enter a city name.");
      return;
    }

    if (!/^[a-zA-Z\s.-]{2,}$/.test(trimmed)) {
      setError("Use a valid city name with letters, spaces, periods, or hyphens.");
      return;
    }

    setError("");
    onSearch(trimmed);
    setCity("");
  };

  const handleQuickSearch = (cityName) => {
    setError("");
    onSearch(cityName);
  };

  return (
    <form
      onSubmit={handleSubmit}
      autoComplete="off"
      className="rounded-[20px] border border-line bg-white/55 p-3 sm:rounded-[28px] sm:p-5"
    >
      <label
        htmlFor="cityInput"
        className="mb-2 block text-[0.78rem] font-bold tracking-[0.1em] text-ink uppercase sm:mb-2.5"
      >
        Search city
      </label>
      <div className="grid grid-cols-[1fr_auto] gap-2 sm:gap-2.5">
        <input
          id="cityInput"
          name="city"
          type="search"
          value={city}
          onChange={(e) => setCity(e.target.value)}
          placeholder="Try London, Tokyo"
          aria-describedby="search-message"
          disabled={isLoading}
          className="w-full rounded-xl border border-transparent bg-white px-3 py-2.5 outline-none transition-all placeholder:text-placeholder focus:border-sea/45 focus:shadow-[0_0_0_4px_rgba(13,125,143,0.1)] sm:rounded-2xl sm:px-4 sm:py-3.5"
        />
        <button
          type="submit"
          disabled={isLoading}
          className="min-h-[42px] rounded-xl bg-storm px-3.5 text-sm font-bold text-white transition-all duration-[180ms] hover:-translate-y-0.5 hover:bg-[#173847] hover:shadow-lift disabled:cursor-not-allowed disabled:opacity-50 sm:rounded-2xl sm:px-5.5 sm:text-base"
        >
          {isLoading ? "Loading..." : "Check"}
        </button>
      </div>
      <div className="mt-2.5 flex flex-wrap gap-1.5 sm:mt-3.5 sm:gap-2" aria-label="Suggested cities">
        {QUICK_CITIES.map((name) => (
          <button
            key={name}
            type="button"
            onClick={() => handleQuickSearch(name)}
            disabled={isLoading}
            className="rounded-full border border-line bg-white/72 px-2.5 py-1 text-[0.82rem] text-ink transition-all duration-[180ms] hover:-translate-y-0.5 hover:border-sea/35 disabled:cursor-not-allowed disabled:opacity-50 sm:px-3.5 sm:py-2 sm:text-base"
          >
            {name}
          </button>
        ))}
      </div>
      {error && (
        <p
          id="search-message"
          className="mt-2.5 min-h-[1.2em] text-[0.88rem] font-semibold text-coral"
          role="status"
          aria-live="polite"
        >
          {error}
        </p>
      )}
    </form>
  );
}
