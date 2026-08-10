import { useState, useCallback } from "react";
import { fetchWeather } from "@/services/weatherApi";
import type { WeatherData } from "@/utils/formatWeather";

interface UseWeatherReturn {
  weather: WeatherData | null;
  isLoading: boolean;
  error: string | null;
  searchCity: (city: string) => Promise<void>;
  clearError: () => void;
}

export function useWeather(): UseWeatherReturn {
  const [weather, setWeather] = useState<WeatherData | null>(null);
  const [isLoading, setIsLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  const searchCity = useCallback(async (city: string) => {
    setIsLoading(true);
    setError(null);

    try {
      const data = await fetchWeather(city);
      setWeather(data);
    } catch (err) {
      const message = err instanceof Error ? err.message : "Failed to fetch weather";
      setError(message);
    } finally {
      setIsLoading(false);
    }
  }, []);

  const clearError = useCallback(() => {
    setError(null);
  }, []);

  return {
    weather,
    isLoading,
    error,
    searchCity,
    clearError,
  };
}
