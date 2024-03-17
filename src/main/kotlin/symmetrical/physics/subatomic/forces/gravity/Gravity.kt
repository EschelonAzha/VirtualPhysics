package symmetrical.physics.subatomic.forces.gravity

class Gravity : IGravity {
    private lateinit var parent:IGravity
    override fun setGravity(gravity:IGravity) : IGravity {
        this.parent = gravity
        return this
    }
}