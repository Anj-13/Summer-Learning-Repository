export default function FavouriteCities({ favorites, onSelectCity, onRemoveCity }) {
  const hasFavorites = favorites && favorites.length > 0;

  const handlePillClick = (event, city) => {
    if (event.target.closest("[data-remove]")) {
      onRemoveCity(city);
      return;
    }
    onSelectCity(city);
  };

  return (
    <aside
      className="panel flex flex-col p-3.5 sm:p-[clamp(22px,3.5vw,32px)]"
      aria-labelledby="favouritesTitle"
    >
      <div className="flex flex-col items-start gap-0">
        <span className="section-kicker">LocalStorage</span>
        <h2
          id="favouritesTitle"
          className="mt-1 text-[1.28rem] leading-[1.05] font-bold tracking-[-0.03em] sm:mt-2 sm:text-[2rem] lg:text-[3.2rem]"
        >
          Favourite cities
        </h2>
      </div>

      {hasFavorites && (
        <div className="mt-2.5 flex flex-wrap gap-1.5 sm:mt-[22px] sm:gap-2.5">
          {favorites.map((city) => (
            <button
              key={city}
              type="button"
              data-city={city}
              onClick={(event) => handlePillClick(event, city)}
              className="inline-flex items-center gap-1.5 rounded-full border border-line bg-white/72 px-2.5 py-1 text-[0.82rem] text-ink transition-all duration-[180ms] hover:-translate-y-0.5 hover:border-sea/35 sm:gap-2 sm:px-3.5 sm:py-2 sm:text-base"
            >
              <span>{city}</span>
              <span
                data-remove
                className="grid h-4 w-4 place-items-center rounded-full bg-coral text-[0.7rem] leading-none text-white sm:h-5 sm:w-5 sm:text-[0.78rem]"
                aria-label={`Remove ${city}`}
              >
                ×
              </span>
            </button>
          ))}
        </div>
      )}

      {!hasFavorites && (
        <p className="mt-2 text-[0.8rem] leading-snug text-muted sm:mt-[18px] sm:text-base sm:leading-[1.45]">
          No favourites yet. Save a city to pin it here.
        </p>
      )}

      <p className="mt-2 text-[0.8rem] leading-snug text-muted sm:mt-[18px] sm:text-base sm:leading-[1.45]">
        Favourite chips behave like quick search shortcuts.
      </p>
    </aside>
  );
}
