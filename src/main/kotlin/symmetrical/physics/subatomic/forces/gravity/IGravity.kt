package symmetrical.physics.subatomic.forces.gravity

interface IGravity {
    fun getGravitationalField()         : IGravitationalField
    fun getGravity()                    : IGravity
    fun orbit(gravity:IGravity)         : IGravity
    fun setSelf(gravity:IGravity)       : IGravity
}