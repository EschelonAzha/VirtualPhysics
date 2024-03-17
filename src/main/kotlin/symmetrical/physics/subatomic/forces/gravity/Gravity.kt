package symmetrical.physics.subatomic.forces.gravity

class Gravity : IGravity {
    private lateinit var parent:IGravity
    override fun setGravitationalField(gravitationalField:IGravity) : IGravity {
        this.parent = gravitationalField
        return this
    }
}