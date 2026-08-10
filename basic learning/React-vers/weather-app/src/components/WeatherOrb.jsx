export default function WeatherOrb({ weatherType = "sunny" }) {
  const type = ["sunny", "cloudy", "rainy", "stormy"].includes(weatherType)
    ? weatherType
    : "sunny";

  return (
    <div className={`weather-orb ${type}`} aria-hidden="true">
      <span className="sun-core" />
      <span className="cloud cloud-a" />
      <span className="cloud cloud-b" />
      <span className="rain rain-a" />
      <span className="rain rain-b" />
      <span className="rain rain-c" />
    </div>
  );
}
