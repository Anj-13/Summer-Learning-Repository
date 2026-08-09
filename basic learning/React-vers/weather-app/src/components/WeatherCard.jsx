import WeatherOrb from "./WeatherOrb";
import { formatDate } from "@/utils/formatWeather";

export default function WeatherCard({
  weather,
  isFavorite,
  onToggleFavorite,
  date = new Date(),
}) {
  if (!weather) return null;

  const { city, temperature, condition, humidity, windSpeed, feelsLike, type } = weather;
  const formattedDate = formatDate(date);

  return (
    <article className="panel p-3.5 sm:p-6 lg:p-8" aria-labelledby="weatherCity">
      <div className="flex items-center justify-between gap-2.5 sm:items-start sm:gap-4.5">
        <div>
          <span className="section-kicker">Current weather</span>
          <h2
            id="weatherCity"
            className="mt-1 text-[1.28rem] leading-[1.05] font-bold tracking-[-0.03em] sm:mt-2 sm:text-[2rem] lg:text-[3.2rem]"
          >
            {city}
          </h2>
          <p id="weatherDate" className="mt-0.5 text-[0.8rem] text-muted sm:mt-2 sm:text-base">
            {formattedDate}
          </p>
        </div>
        <button
          type="button"
          onClick={() => onToggleFavorite(city)}
          className={`min-h-[34px] whitespace-nowrap rounded-xl px-3 text-[0.8rem] font-bold text-white transition-all duration-[180ms] hover:-translate-y-0.5 hover:shadow-lift sm:min-h-[46px] sm:rounded-2xl sm:px-5.5 sm:text-base ${
            isFavorite ? "bg-coral" : "bg-storm hover:bg-[#173847]"
          }`}
        >
          {isFavorite ? "Saved" : "Save city"}
        </button>
      </div>

      {/* Keep orb + temp side-by-side on phone so the card stays short */}
      <div className="my-2.5 grid grid-cols-[88px_1fr] items-center gap-3 sm:my-6 sm:grid-cols-[150px_1fr] sm:gap-6 lg:grid-cols-[220px_1fr] lg:gap-10">
        <WeatherOrb weatherType={type} />
        <div>
          <p className="mb-0.5 text-[2.85rem] leading-[0.85] font-bold tracking-[-0.05em] sm:mb-1 sm:text-[4.5rem] lg:text-[8.5rem]">
            {temperature}
            <sup className="text-[0.28em] font-medium tracking-normal">°C</sup>
          </p>
          <p className="text-[0.95rem] font-bold text-muted sm:text-xl lg:text-[1.35rem]">{condition}</p>
        </div>
      </div>

      <div className="grid grid-cols-3 gap-1.5 sm:gap-3">
        <div className="rounded-[14px] border border-line bg-white/62 p-2 sm:rounded-[22px] sm:p-4">
          <span className="block text-[0.68rem] text-muted sm:text-[0.9rem]">Humidity</span>
          <strong className="mt-0.5 block text-[0.9rem] font-bold sm:mt-2 sm:text-xl lg:text-[1.45rem]">{humidity}%</strong>
        </div>
        <div className="rounded-[14px] border border-line bg-white/62 p-2 sm:rounded-[22px] sm:p-4">
          <span className="block text-[0.68rem] text-muted sm:text-[0.9rem]">Wind speed</span>
          <strong className="mt-0.5 block text-[0.9rem] font-bold sm:mt-2 sm:text-xl lg:text-[1.45rem]">{windSpeed} km/h</strong>
        </div>
        <div className="rounded-[14px] border border-line bg-white/62 p-2 sm:rounded-[22px] sm:p-4">
          <span className="block text-[0.68rem] text-muted sm:text-[0.9rem]">Feels like</span>
          <strong className="mt-0.5 block text-[0.9rem] font-bold sm:mt-2 sm:text-xl lg:text-[1.45rem]">{feelsLike}°C</strong>
        </div>
      </div>
    </article>
  );
}
