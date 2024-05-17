package applications.tests.gravity

import symmetrical.physics.subatomic.balanced.Particle

class VTestGravity {
    private var sun     : Sun
    private var mars    : Mars
    private var phobos  : Phobos   // 1st moon of Mars
    private var deimos  : Deimos   // 2nd moon of Mars

    /*
        To better understand the concept of gravity in the context of object-oriented programming, consider the following analogy using celestial bodies:
Imagine you have four objects representing the Sun, Mars, Phobos, and Deimos. The goal is to share information between these objects without polluting them with unnecessary data. In this case, the city field is needed by the two moons (Phobos and Deimos) but not by Mars. Without using a gravitational pull concept, you would need to modify Mars to accept the city field and pass it through to its moons.
By using gravity as a metaphor for variable sharing, each moon can directly access the city field, pulling it into its scope when needed. This simplifies programming by reducing unnecessary modifications and data transfers between objects.
To make the most of this gravitational pull concept, think about programming in terms of gravitational fields. The server is like the Sun, providing essential data and functionality to the other objects. Each user session is represented by a planetary body, like Mars, and its variables can be shared with lower orbitals, like Phobos and Deimos.
Gravity ensures that each object can access the appropriate variables from other objects, even when multiple user sessions have the same variable. This approach promotes cleaner, more efficient code by preventing unnecessary data sharing and keeping objects focused on their specific roles and functionalities.



     */
    init {
        sun    = Sun()                 // Sun traps City in
        mars   = Mars().with(sun)
        phobos = Phobos().with(mars)
        deimos = Deimos().with(mars)

    }


}