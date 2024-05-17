package applications.tests.gravity

import symmetrical.physics.subatomic.balanced.Particle

class Mars : Particle() { // Anything that ultimately extends Particle can feel the effects of Gravity

    fun with(sun:Sun) : Mars {
        orbit(sun)     // Mars orbits the Sun
        return this
    }
}