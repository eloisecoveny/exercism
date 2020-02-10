object SpaceAge {

  def onEarth(seconds: Double): Double = (seconds / EarthYearInEarthYears)

  def onMercury(seconds: Double): Double = calculateAgeInEarthYears(seconds, MercuryYearInEarthYears)

  def onMars(seconds: Double): Double = calculateAgeInEarthYears(seconds, MarsYearInEarthYears)

  def onVenus(seconds: Double): Double = calculateAgeInEarthYears(seconds, VenusYearInEarthYears)

  def onJupiter(seconds: Double): Double = calculateAgeInEarthYears(seconds, JupiterYearInEarthYears)

  def onSaturn(seconds: Double): Double = calculateAgeInEarthYears(seconds, SaturnYearInEarthYears)

  def onUranus(seconds: Double): Double = calculateAgeInEarthYears(seconds, UranusYearInEarthYears)

  def onNeptune(seconds: Double): Double = calculateAgeInEarthYears(seconds, NeptuneYearInEarthYears)

  val EarthYearInEarthYears = 31557600
  val MercuryYearInEarthYears = 0.2408467
  val MarsYearInEarthYears = 1.8808158
  val VenusYearInEarthYears = 0.61519726
  val JupiterYearInEarthYears = 11.862615
  val SaturnYearInEarthYears = 29.447498
  val UranusYearInEarthYears = 84.016846
  val NeptuneYearInEarthYears = 164.79132

  def calculateAgeInEarthYears(ageInSeconds: Double, orbitsInEarthYears: Double) = {
    (ageInSeconds / EarthYearInEarthYears) / orbitsInEarthYears
  }

}