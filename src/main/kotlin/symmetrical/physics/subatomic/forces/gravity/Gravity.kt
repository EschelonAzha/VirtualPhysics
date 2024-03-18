package symmetrical.physics.subatomic.forces.gravity

class Gravity : IGravity {
    private lateinit var self      :IGravity

    private var gravitationalField :IGravitationalField = GravitationalField()
    init {
        gravitationalField.setGravity(this)
    }
    override fun setSelf(gravity:IGravity) : IGravity {
        this.self = gravity
        return this
    }

    override fun getGravitationalField() : IGravitationalField {
        return gravitationalField
    }
    override fun getGravity()            : IGravity {
        return this
    }
    override fun orbit(gravity:IGravity) : Gravity {
        gravitationalField.orbit(gravity.getGravitationalField())
        return this
    }

}