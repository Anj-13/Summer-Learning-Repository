import { getWeather, validateCity, type WeatherData } from "@/utils/formatWeather";

/**
 * Data layer (plan: services/weatherApi).
 * Still uses the same mock data as vanilla WeatherApp.
 * Later: swap the body for a real OpenWeather fetch + formatWeather mapper.
 * Use VITE_OPENWEATHER_API_KEY in .env when you add a live API.
 */
export async function fetchWeather(city: string): Promise<WeatherData> {
  const { valid, error } = validateCity(city);
  if (!valid) {
    throw new Error(error);
  }

  // Simulate network latency so loading UI is visible
  await new Promise((resolve) => setTimeout(resolve, 300));

  return getWeather(city);
}
