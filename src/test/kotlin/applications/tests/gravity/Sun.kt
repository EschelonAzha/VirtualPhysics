package applications.tests.gravity

import applications.tests.dictionary.atoms.City
import symmetrical.physics.subatomic.balanced.Particle

class Sun : Particle() {// Anything that ultimately extends Particle can feel the effects of Gravity

    val city:City = City()    // Sun has a field called city


    init {
        gravity.attract(city)    // city is pulled by the gravitational field of the Sun

    }
}