package symmetrical.physics.subatomic.forces.gravity

import kotlin.reflect.KClass

class Gravity : IGravity {
    private lateinit var self      :IGravity

    private var gravitationalField :IGravitationalField = GravitationalField()
    init {
        gravitationalField.setGravity(this)
    }

    override fun attract(item:Any) : IGravity {
        gravitationalField.attract(item)
        return this
    }

    override fun deorbit() : Gravity {
        gravitationalField.deorbit()
        return this
    }


    override fun eject(item:Any) : IGravity {
        gravitationalField.eject(item)
        return this
    }

    override fun getGravitationalField() : IGravitationalField {
        return gravitationalField
    }
    override fun getGravity()            : IGravity {
        return this
    }

    override fun gravitate(kClass: KClass<*>) : Any? {
        return gravitationalField.gravitate(kClass)
    }
    override fun orbit(gravity:IGravity) : Gravity {
        gravitationalField.orbit(gravity.getGravitationalField())
        return this
    }



    override fun setSelf(gravity:IGravity) : IGravity {
        this.self = gravity
        return this
    }

}