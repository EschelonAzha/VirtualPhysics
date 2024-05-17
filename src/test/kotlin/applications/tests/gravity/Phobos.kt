package applications.tests.gravity

import applications.tests.dictionary.atoms.City
import symmetrical.physics.subatomic.balanced.Particle

class Phobos : Particle() {// Anything that ultimately extends Particle can feel the effects of Gravity
    lateinit var city:City
    fun with(mars:Mars) : Phobos {
        orbit(mars)   // Phobos orbits the Sun

        city = gravitate(City::class) as City   // Since Phobos orbits Mars, and Mars orbits
                                                // the Sun, we can pull the City from orbit
                                                // of the sun without passing it as parameter


        /*
            In addition to gravitate, you can use "gravitateAll" which returns all instances of "City" that are found in the scope

            You can also use "pull(City::class) which actually pulls the variable and removes it from Sun and moves
            it to here.
         */
        return this
    }
}