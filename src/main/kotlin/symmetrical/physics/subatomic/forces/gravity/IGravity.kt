package symmetrical.physics.subatomic.forces.gravity

import kotlin.reflect.KClass

interface IGravity {
    fun attract                 (item:Any)              : IGravity
    fun deorbit                 ()                      : IGravity
    fun eject                   (item:Any)              : IGravity
    fun getGravitationalField   ()                      : IGravitationalField
    fun getGravity              ()                      : IGravity
    fun gravitate               (kClass: KClass<*>)     : Any?
    fun orbit                   (gravity:IGravity)      : IGravity
    fun pull                    (kClass: KClass<*>)     : Any?

    fun setSelf                 (gravity:IGravity)      : IGravity
}