package applications.tests.gravity

import applications.tests.dictionary.atoms.City
import symmetrical.physics.subatomic.balanced.Particle

class Deimos : Particle() {   // Anything that ultimately extends Particle can feel the effects of Gravity
    lateinit var city:City
    fun with(mars:Mars) : Deimos {
        orbit(mars)

        city = gravitate(City::class) as City   // Since Phobos orbits Mars, and Mars orbits
                                                // the Sun, we can pull the City from orbit
                                                // of the sun without passing it as parameter
        return this
    }
}