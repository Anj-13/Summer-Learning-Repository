const FORECAST_ACCENTS = ["#8fd6e8", "#f7c948", "#ef6f5e", "#b7d66d", "#0d7d8f"];

export default function ForecastCard({ forecast }) {
  if (!forecast || forecast.length === 0) return null;

  return (
    <section className="panel mt-2.5 p-3.5 sm:mt-[22px] sm:p-[clamp(22px,3.5vw,32px)]" aria-labelledby="forecastTitle">
      <div className="flex flex-col items-start">
        <span className="section-kicker">Planning view</span>
        <h2
          id="forecastTitle"
          className="mt-1 text-[1.28rem] leading-[1.05] font-bold tracking-[-0.03em] sm:mt-2 sm:text-[2rem] lg:text-[3.2rem]"
        >
          5-day forecast
        </h2>
      </div>
      {/* Keep all 5 days in one row on phone — matches laptop dashboard */}
      <div className="mt-2.5 grid grid-cols-5 gap-1.5 sm:mt-5.5 sm:gap-3.5">
        {forecast.map((day, index) => (
          <div
            key={`${day.day}-${index}`}
            className="relative overflow-hidden rounded-[14px] border border-line bg-white/62 p-2 sm:min-h-[190px] sm:rounded-[22px] sm:p-4.5"
            style={{ "--accent": FORECAST_ACCENTS[index % FORECAST_ACCENTS.length] }}
          >
            <span
              className="pointer-events-none absolute inset-x-0 bottom-0 h-1 sm:h-1.5"
              style={{ background: "var(--accent)" }}
              aria-hidden="true"
            />
            <span className="block text-[0.68rem] text-muted sm:text-[0.9rem]">{day.day}</span>
            <p className="mt-0.5 text-[0.68rem] font-bold text-muted sm:mt-2.5 sm:text-base">{day.condition}</p>
            <strong className="mt-1.5 block text-[1.15rem] font-bold tracking-[-0.04em] sm:mt-4.5 sm:text-4xl">
              {day.temperature}°
            </strong>
          </div>
        ))}
      </div>
    </section>
  );
}
